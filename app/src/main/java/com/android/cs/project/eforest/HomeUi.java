package com.android.cs.project.eforest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class HomeUi extends AppCompatActivity {
    private long backpressedtime;
    SliderLayout sliderLayout;
    Button btnRapid,btnNews,btnGallery,btnApp,btnLogOut,btnNearest,btnHelpLine,btnSocial,btnAbout;
    SharedPreferences.Editor editor;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ui);
        btnApp=(Button)findViewById(R.id.applicationLog);
        btnRapid=(Button)findViewById(R.id.rapidLog);
        btnGallery=(Button)findViewById(R.id.galleryLog);
        btnNews=(Button)findViewById(R.id.newsLog);
        btnLogOut=(Button)findViewById(R.id.logoutLog);
        btnNearest=(Button)findViewById(R.id.forsetoffLog);
        btnHelpLine=(Button)findViewById(R.id.helplineLog);
        btnSocial=(Button)findViewById(R.id.socialLog);
        btnAbout=(Button)findViewById(R.id.aboutLog);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AboutApp.class));
            }
        });
        btnSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SocialMedia.class));
            }
        });
        btnHelpLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HelpLine.class));
            }
        });
        btnNearest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=forest office");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor=getSharedPreferences("LOGIN",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();
                Toast.makeText(getApplicationContext(),"Successfully Logout",Toast.LENGTH_LONG).show();
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),News.class));
            }
        });
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Gallery.class));
            }
        });
        btnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
                String uname=preferences.getString("emailid",null);
                if (uname!=null){
                    //startActivity(new Intent(getApplicationContext(),ViewApplication.class));
                    startActivity(new Intent(getApplicationContext(),ApplicationHome.class));
                }else {
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("TAG","application");
                    startActivity(intent);
                }
            }
        });
        btnRapid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
                String uname=preferences.getString("emailid",null);
                if (uname!=null){
                    startActivity(new Intent(getApplicationContext(),RapidResponse.class));
                }else {
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("TAG","rapid");
                    startActivity(intent);
                }
            }
        });
        sliderLayout=findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.DROP);//animation
        sliderLayout.setScrollTimeInSec(2);//scroll delay
        setSliderViews();
    }

    private void setSliderViews() {
        for(int i=0;i<=5;i++) {
            DefaultSliderView sliderView1 = new DefaultSliderView(this);
            switch (i) {
                case 0:
                    sliderView1.setImageDrawable(R.drawable.f2);
                    sliderView1.setDescription("Elephant");
                    break;
                case 1:
                    sliderView1.setImageDrawable(R.drawable.f6);
                    sliderView1.setDescription("Rescue");
                    break;
                case 2:
                    sliderView1.setImageDrawable(R.drawable.f0);
                    sliderView1.setDescription("Forest");
                    break;
                case 3:
                    sliderView1.setImageDrawable(R.drawable.f9);
                    sliderView1.setDescription("Passing out parade");
                    break;
                case 4:
                    sliderView1.setImageDrawable(R.drawable.f4);
                    sliderView1.setDescription("Elephants");
                    break;
                case 5:
                    sliderView1.setImageDrawable(R.drawable.f5);
                    sliderView1.setDescription("Tiger");
                    break;
            }
            sliderView1.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView1);
        }
    }

    @Override
    public void onBackPressed() {
        if (backpressedtime+2000>System.currentTimeMillis()){
            super.onBackPressed();
        }else {
            Toast.makeText(getApplicationContext(),"Press again to exit",Toast.LENGTH_SHORT).show();
        }
        backpressedtime=System.currentTimeMillis();
    }
}
