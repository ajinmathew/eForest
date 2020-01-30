package com.android.cs.project.eforest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class User_signup extends AppCompatActivity {

    Button verify;
    LinearLayout L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);

        verify=(Button) findViewById(R.id.verify);
        L=(LinearLayout) findViewById(R.id.layout);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L.setVisibility(View.VISIBLE);
            }
        });
    }
}
