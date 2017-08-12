package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import br.com.spacerocket.emprega.R;
import br.com.spacerocket.emprega.activity.MainActivity;
import model.Jobs;
import model.Vagas;

/**
 * Created by junior on 03/08/17.
 */

public class JobsOfertAdapter extends RecyclerView.Adapter<JobsOfertAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Vagas> listJobs = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tvEmprsa;
        public TextView tvCargo;
        public TextView tvExperiencia;
        public TextView tvHoras;
        public TextView tvBairro;
        public TextView tvSalario;
        public CardView mCardView;
        public Button btnJob;
        public Button btnCancel;

        public View view;

        public MyViewHolder(View view) {
            super(view);
            tvEmprsa = (TextView) view.findViewById(R.id.tvEmpresaName);
            tvCargo = (TextView) view.findViewById(R.id.tvOcuppation);
            tvExperiencia = (TextView) view.findViewById(R.id.tvExperience);
            tvHoras = (TextView) view.findViewById(R.id.textView2);
            tvBairro = (TextView) view.findViewById(R.id.tvBairroCidade);
            tvSalario = (TextView) view.findViewById(R.id.tvHorario);
            mCardView = (CardView) view.findViewById(R.id.cvOfferJobs);
            btnJob = (Button) view.findViewById(R.id.button4);
            btnCancel = (Button) view.findViewById(R.id.btnCancelar);
        }
    }

    public JobsOfertAdapter(Context mContext, ArrayList<Vagas> listJobs) {
        this.mContext = mContext;
        this.listJobs = listJobs;
    }

    @Override
    public JobsOfertAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_jobs_ofert, parent, false);

        return new JobsOfertAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final JobsOfertAdapter.MyViewHolder holder, final int position) {
        final Vagas job = listJobs.get(position);
        holder.tvCargo.setText(job.getOcupacao());
        holder.tvSalario.setText("Salário: R$ "+job.getSalario());
        holder.tvHoras.setText(job.getHoraririoDeTrabalho()+" Hrs semanais.");
        holder.tvBairro.setText("Bairro: "+job.getBairro()+", "+job.getCidade());
        holder.tvExperiencia.setText(job.getTempoExperiencia()+" de experiência");
        holder.tvEmprsa.setText(job.getNomeDaEmpresa());
         /*hold card click*/
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.btnJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mContext instanceof MainActivity){
                    ((MainActivity)mContext).newJob(job);
                }

                Toast.makeText(mContext, "Parabéns você acaba de dar um JOB em uma vaga," +
                        "fique de olho na sua tela de processo, que em breve a empresa entrará em contato.",
                        Toast.LENGTH_LONG).show();
            }
        });

        holder.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listJobs.size();
    }

}
