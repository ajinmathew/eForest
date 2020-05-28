package com.android.cs.project.eforest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class CustomAdapterImage extends RecyclerView.Adapter<CustomAdapterImage.MyViewHolder> {
    List<Image> imagelist;
    Context context;
    Picasso picasso;
    public CustomAdapterImage(List<Image> imagelist, Context applicationContext) {
        this.imagelist=imagelist;
        this.context=applicationContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.imagecard,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Image image=imagelist.get(position);
        holder.txtHeading.setText(image.imageHeading);

        //setting intent for open a new activity on button (here card) click....
        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent( view.getContext(),ViewImage.class );
                in.putExtra("ImgHead", image.imageHeading);
                in.putExtra("ImgTime", image.uploadTime);
                in.putExtra("ImgDesc", image.imageDescription);
                in.putExtra("ImgUrl", image.imageUrl);
                view.getContext().startActivity( in );
            }
        } );
        //holder.txtTime.setText(image.uploadTime);

        picasso.with(this.context).load(image.imageUrl).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtHeading,txtTime;
        ImageView imageView;
        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtHeading=itemView.findViewById(R.id.headingImgCard);
            //txtTime=itemView.findViewById(R.id.timeImgCard);
            imageView=itemView.findViewById(R.id.imageImgCard);


        }
    }
}
