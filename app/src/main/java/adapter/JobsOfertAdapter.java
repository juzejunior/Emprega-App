package adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.spacerocket.emprega.R;
import model.Jobs;
import model.Vagas;

/**
 * Created by junior on 03/08/17.
 */

public class JobsOfertAdapter extends RecyclerView.Adapter<JobsOfertAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Vagas> listJobs = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tvCargo;
        public CardView mCardView;

        public View view;

        public MyViewHolder(View view) {
            super(view);
            tvCargo = (TextView) view.findViewById(R.id.tvOcuppation);
            mCardView = (CardView) view.findViewById(R.id.cvOfferJobs);
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
