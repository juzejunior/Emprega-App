package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import br.com.spacerocket.emprega.R;
import model.Jobs;

/**
 * Created by junior on 03/08/17.
 */

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Jobs> listJobs = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tvCargo;
        public TextView tvEmpresa;
        public TextView tvSalario;
        public TextView tvSituacao;
        public CardView mCardView;

        public View view;

        public MyViewHolder(View view) {
            super(view);
            tvCargo = (TextView) view.findViewById(R.id.tvCargo);
            tvEmpresa = (TextView) view.findViewById(R.id.tvEmpresa);
            tvSalario = (TextView) view.findViewById(R.id.tvSalario);
            tvSituacao = (TextView) view.findViewById(R.id.tvStatus);
            mCardView = (CardView) view.findViewById(R.id.cvJobs);
        }
    }

    public JobsAdapter(Context mContext, ArrayList<Jobs> listJobs) {
        this.mContext = mContext;
        this.listJobs = listJobs;
    }

    @Override
    public JobsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_jobs, parent, false);

        return new JobsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final JobsAdapter.MyViewHolder holder, final int position) {
        final Jobs job = listJobs.get(position);
        holder.tvCargo.setText(job.getCargo());
        holder.tvEmpresa.setText(job.getEmpresa());
        holder.tvSalario.setText(job.getSalario());
        holder.tvSituacao.setText(job.getSituacao());

         /*hold card click*/
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(mContext instanceof JobsActivity){
                    Intent intentPatientInfo = new Intent(mContext, PatientInfoActivity.class);
                    intentPatientInfo.putExtra("PATIENT_OBJECT", listPatient.get(position));
                    mContext.startActivity(intentPatientInfo);
                }*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return listJobs.size();
    }

}
