package com.android.cs.project.eforest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewImage extends AppCompatActivity {
    ImageView imageView;
    TextView txtHeading,txtTime,txtDesc;
    Picasso picasso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        Intent i=getIntent();
        //String imgheading=i.getStringExtra( "TAGforIMG" );


        imageView=(ImageView)findViewById(R.id.imageviewViewImg);
        txtHeading=(TextView)findViewById(R.id.headingViewImg);
        txtTime=(TextView)findViewById(R.id.timeViewImg);
        txtDesc=(TextView)findViewById(R.id.descriptionViewImg);
        txtHeading.setText(i.getStringExtra( "ImgHead" ));
        txtDesc.setText(i.getStringExtra( "ImgDesc" ));
        txtTime.setText(i.getStringExtra( "ImgTime" ));
        picasso.with(getApplicationContext()).load(i.getStringExtra( "ImgUrl" )).into(imageView);
    }
}
