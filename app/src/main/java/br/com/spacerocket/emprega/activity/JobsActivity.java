package br.com.spacerocket.emprega.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.JobsAdapter;
import br.com.spacerocket.emprega.R;
import model.Jobs;

public class JobsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static ArrayList<Jobs> jobs = new ArrayList<>();
    // Get a reference to our posts
    //final FirebaseDatabase database = DatabaseInstaceFactory.getDatabase();
    //DatabaseReference ref = database.getReference("user/paciente");

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

        //get all stations
        fullyList();
    }

    public void fullyList(){
        jobs.clear();
        Jobs job = new Jobs("Pedreiro", "XIS", "Em andamento", "950", "sd");
        jobs.add(job);
        job = new Jobs("Ajudante de Pedreiro", "XIS", "Em andamento", "450","dasfsdf");
        jobs.add(job);
        job = new Jobs("Mestre de Obras", "XIS", "Em andamento", "1450","asdfasf");
        jobs.add(job);

    }
}
