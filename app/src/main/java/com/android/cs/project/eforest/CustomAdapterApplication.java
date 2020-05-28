package com.android.cs.project.eforest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class CustomAdapterApplication extends RecyclerView.Adapter<CustomAdapterApplication.MyViewHolder> {
    List<Application> listApplication;
    Context context;

    public CustomAdapterApplication(List<Application> listApplication, Context applicationContext) {
        this.context=applicationContext;
        this.listApplication=listApplication;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewapplication,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterApplication.MyViewHolder holder, int position) {
        final Application application=listApplication.get(position);
        holder.txtAppId.setText(application.id);
        holder.txtAppType.setText(application.typeApplication);

        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent( view.getContext(),DisplayApplication.class );
                in.putExtra("AppId", application.id);
                view.getContext().startActivity( in );
            }
        } );
    }

    @Override
    public int getItemCount() {
        return listApplication.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtAppId,txtAppType;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAppId=itemView.findViewById(R.id.appidCardViewApplication);
            txtAppType=itemView.findViewById(R.id.apptypeCardViewApplication);
        }
    }
}
