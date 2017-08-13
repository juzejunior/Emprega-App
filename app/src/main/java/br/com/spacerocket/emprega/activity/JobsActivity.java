package br.com.spacerocket.emprega.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import adapter.JobsAdapter;
import br.com.spacerocket.emprega.R;
import model.Candidato;
import model.Experiencia;
import model.Interesse;
import model.Jobs;
import model.Vagas;

public class JobsActivity extends AppCompatActivity {

    private TextView tvError;
    private RecyclerView mRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static ArrayList<Jobs> jobs = new ArrayList<>();
    // Get a reference to our posts
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("vagas");
    private ArrayList<Vagas> mVagas = new ArrayList<>();
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvPatients);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new JobsAdapter(this, jobs);
        mRecyclerView.setAdapter(mAdapter);
        Bundle bundle = getIntent().getExtras();
        userID = bundle.getString("userID");
        tvError = (TextView) findViewById(R.id.tvErro);
        //get all stations
        fullyList();

    }

    public void fullyList() {
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Vagas v = dataSnapshot.getValue(Vagas.class);
                if(v != null) {
                  DataSnapshot candidatSnap = dataSnapshot.child("candidaturas");
                    Iterable<DataSnapshot> candidaSnapho = candidatSnap.getChildren();
                    for(DataSnapshot candidatura : candidaSnapho){
                        if(candidatura.exists()){
                            Jobs job = candidatura.getValue(Jobs.class);
                            if(job != null){
                                if(job.getCandidatoId() != null){
                                    if(job.getCandidatoId().equals(userID)){
                                       jobs.add(job);
                                        mAdapter.notifyDataSetChanged();
                                    }
                                }
                            }
                        }
                    }

                    if(jobs.isEmpty()){
                      tvError.setVisibility(View.VISIBLE);
                    }else{
                        tvError.setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
