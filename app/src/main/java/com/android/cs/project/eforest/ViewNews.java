package com.android.cs.project.eforest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewNews extends AppCompatActivity {
    ImageView imageView;
    TextView txtHeading,txtTime,txtDesc;
    Picasso picasso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_news);

        Intent intent=getIntent();
        //String imgheading=i.getStringExtra( "TAGforIMG" );


        imageView=(ImageView)findViewById(R.id.imageviewViewNews);
        txtHeading=(TextView)findViewById(R.id.headingViewNews);
        txtTime=(TextView)findViewById(R.id.timeViewNews);
        txtDesc=(TextView)findViewById(R.id.descriptionViewNews);
        txtHeading.setText(intent.getStringExtra( "NewsHead" ));
        txtDesc.setText(intent.getStringExtra( "NewsDesc" ));
        txtTime.setText(intent.getStringExtra( "NewsTime" ));
        picasso.with(getApplicationContext()).load(intent.getStringExtra( "NewsUrl" )).into(imageView);
    }
}
