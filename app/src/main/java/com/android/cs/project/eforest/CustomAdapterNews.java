package com.android.cs.project.eforest_office;


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


class CustomAdapterNews extends RecyclerView.Adapter<CustomAdapterNews.MyViewHolderNews> {

    Context context;
    List<NewsClass> newslist;
    Picasso picasso;

    public CustomAdapterNews(List<NewsClass> newslist, Context applicationContext) {
        this.context=applicationContext;
        this.newslist=newslist;
    }

    @NonNull
    @Override
    public MyViewHolderNews onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.newscard,parent,false);
        return new MyViewHolderNews(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderNews holder, int position) {
        final NewsClass newsClass=newslist.get(position);
        holder.txtHeading.setText(newsClass.heading);
        picasso.with(this.context).load(newsClass.imageurl).into(holder.imageView);
        //setting intent for open a new activity on button (here card) click....
        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent( view.getContext(),ViewNews.class );
                in.putExtra("NewsHead", newsClass.heading);
                in.putExtra("NewsTime", newsClass.time);
                in.putExtra("NewsDesc", newsClass.description);
                in.putExtra("NewsUrl", newsClass.imageurl);
                view.getContext().startActivity( in );
            }
        } );
    }

    @Override
    public int getItemCount() {
        return newslist.size();
    }

    public class MyViewHolderNews extends RecyclerView.ViewHolder {
        TextView txtHeading,txtTime;
        ImageView imageView;
        public MyViewHolderNews(@NonNull View itemView) {
            super(itemView);
            txtHeading=itemView.findViewById(R.id.headingNewsCard);
            imageView=itemView.findViewById(R.id.imageNewsCard);
        }
    }
}
