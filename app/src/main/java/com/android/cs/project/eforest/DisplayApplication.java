package com.android.cs.project.eforest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DisplayApplication extends AppCompatActivity {
DatabaseReference reference;
SharedPreferences preferences;
TextView txtName,txtId,txtAddress,txtDate,txtDob,txtDivision,txtRange,txtAmount,txtMobile,txtType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_application);
        Intent intent=getIntent();
        String id=intent.getStringExtra("AppId");
        preferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
        String mno=preferences.getString("mobile",null);

        txtAddress=(TextView)findViewById(R.id.appAddressDisplayApplication);
        txtAmount=(TextView)findViewById(R.id.appAmountDisplayApplication);
        txtDate=(TextView)findViewById(R.id.appDateDisplayApplication);
        txtDivision=(TextView)findViewById(R.id.appDivisionDisplayApplication);
        txtDob=(TextView)findViewById(R.id.appDoBDisplayApplication);
        txtId=(TextView)findViewById(R.id.appIdDisplayApplication);
        txtMobile=(TextView)findViewById(R.id.appMOBDisplayApplication);
        txtName=(TextView)findViewById(R.id.appNameDisplayApplication);
        txtRange=(TextView)findViewById(R.id.appRangeDisplayApplication);
        txtType=(TextView)findViewById(R.id.appTypeDisplayApplication);

        reference= FirebaseDatabase.getInstance().getReference().child("eForest").child("Applications").child("General").child(mno).child(id);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Application application=dataSnapshot.getValue(Application.class);
                txtDob.setText(application.dob);
                txtName.setText(application.nameApplicant);
                txtAddress.setText(application.addressApplicant);
                txtAmount.setText(application.compensation_amount);
                txtDate.setText(application.date);
                txtDivision.setText(application.forest_division);
                txtId.setText(application.id);
                txtMobile.setText(application.mobile);
                txtRange.setText(application.forest_range);
                txtType.setText(application.typeApplication);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
