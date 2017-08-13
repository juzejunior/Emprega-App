package br.com.spacerocket.emprega.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import adapter.JobsAdapter;
import adapter.JobsOfertAdapter;
import br.com.spacerocket.emprega.R;
import model.Candidato;
import model.Experiencia;
import model.Interesse;
import model.Jobs;
import model.Vagas;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Candidato mCandidato;
    private ArrayList<Vagas> mVagas = new ArrayList<>();
    private ArrayList<Vagas> mVagasReserva = new ArrayList<>();
    //Firebase instances
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef =  FirebaseDatabase.getInstance().getReference().child("trabalhador");
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

    ProgressBar pgb;

    //for card
    private RecyclerView mRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initElements();
        //get user data
        getUserData();

    }

    public void initElements(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        mCandidato = new Candidato();

        pgb = (ProgressBar) findViewById(R.id.progressLoad1);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvVagas);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new JobsOfertAdapter(this, mVagas);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void getUserData(){
        // Read from the database
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Candidato c = dataSnapshot.getValue(Candidato.class);
                if(c != null && c.getUserID().equals(firebaseUser.getUid())){
                    mCandidato  = c;
                    DataSnapshot dataSnapshotInt = dataSnapshot.child("interesses");
                    Iterable<DataSnapshot> intChildren = dataSnapshotInt.getChildren();
                    for(DataSnapshot intC : intChildren){
                        Interesse intT = intC.getValue(Interesse.class);
                        mCandidato.getmInteresses().add(intT);
                    }

                    DataSnapshot dataSnapshotExt = dataSnapshot.child("experiencia");
                    Iterable<DataSnapshot> expChildren = dataSnapshotExt.getChildren();
                    for(DataSnapshot intC : expChildren){
                        Experiencia exp = intC.getValue(Experiencia.class);
                        mCandidato.getmExperiencia().add(exp);
                    }

                    loadVagas();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

    }

    public  void loadVagas(){
        // Read from the database
        myRef = FirebaseDatabase.getInstance().getReference().child("vagas");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Vagas vaga = dataSnapshot.getValue(Vagas.class);
                vaga.setVagaId(dataSnapshot.getKey());
                pgb.setVisibility(View.INVISIBLE);
                DataSnapshot dataSnapshotInt = dataSnapshot.child("interesses");
                Iterable<DataSnapshot> intChildren = dataSnapshotInt.getChildren();
                for(DataSnapshot intC : intChildren){
                    Interesse intT = intC.getValue(Interesse.class);
                    vaga.getmInteresses().add(intT);
                }

                if(mCandidato.getMunicipio().toLowerCase().equals(vaga.getCidade().toLowerCase())){
                    //encontrei vaga proxima
                    for(Experiencia e : mCandidato.getmExperiencia()){
                        if (e.getCbo().toLowerCase().equals(vaga.getCBO().toLowerCase()) || e.getCbo().toLowerCase().equals(vaga.getOcupacao().toLowerCase())) {//se o CBO for igual já adiciona a lista
                            Log.d("LOCAL: ", "Encontrei um local com sua experiência.");
                            if(!mVagas.contains(vaga)){
                                pgb.setVisibility(View.INVISIBLE);
                                mVagas.add(vaga);
                                mAdapter.notifyDataSetChanged();
                            }
                        }else{//Verifica as habilidades do funcionário se há alguma possibilidade de contratação
                            for(Interesse canInt : mCandidato.getmInteresses()){
                                for(Interesse vagaInt : vaga.getmInteresses()){
                                    if(canInt.getChave().toLowerCase().equals(vagaInt.getChave().toLowerCase())){
                                        if(!mVagas.contains(vaga)){
                                            pgb.setVisibility(View.INVISIBLE);
                                            mVagas.add(vaga);
                                            mAdapter.notifyDataSetChanged();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(this, JobsActivity.class);
            intent.putExtra("userID", mCandidato.getUserID());
            startActivity(intent);


        } else if (id == R.id.nav_send) {
            firebaseAuth.signOut();
            Intent loginIntent = new Intent(this, StartActivity.class);
            startActivity(loginIntent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void newJob(Vagas v){
        //put on database
        DatabaseReference myRef =  FirebaseDatabase.getInstance().getReference().child("vagas").child(v.getVagaId())
                .child("candidaturas");

        Jobs job1 = new Jobs(v.getOcupacao(), v.getNomeDaEmpresa(), "Aguardando", v.getSalario(), v.getVagaId(), mCandidato.getUserID());
        myRef.push().setValue(job1);

    }
}
