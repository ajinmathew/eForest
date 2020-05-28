package com.android.cs.project.eforest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SocialMedia extends AppCompatActivity {
LinearLayout lytYoutube,lytFacebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);

        lytYoutube=(LinearLayout)findViewById(R.id.layoutYoutube);
        lytYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to open Youtube channel....
                Intent intent=null;
                try {
                    intent =new Intent(Intent.ACTION_VIEW);
                    intent.setPackage("com.google.android.youtube");
                    intent.setData(Uri.parse("http://www.youtube.com/channel/UCYawiBh_cNsxAzzBzX_EwxA"));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.youtube.com/channel/UCYawiBh_cNsxAzzBzX_EwxA"));
                    startActivity(intent);
                }
            }
        });
        lytFacebook=(LinearLayout)findViewById(R.id.layoutFacebook);
        lytFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to open Facebook Page....
                String facebookPageID = "KeralaForestsandWildlifeDepartment";
                // URL
                String facebookUrl = "https://www.facebook.com/" + facebookPageID;
                String facebookUrlScheme = "fb://page/" + facebookPageID;
                try {
                    int versionCode = getPackageManager().getPackageInfo("com.facebook.katana", 0).versionCode;
                    if (versionCode >= 3002850) {
                        Uri uri = Uri.parse("fb://facewebmodal/f?href=" + facebookUrl);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    } else {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrlScheme)));
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl)));
                }
            }


        });
    }
}
