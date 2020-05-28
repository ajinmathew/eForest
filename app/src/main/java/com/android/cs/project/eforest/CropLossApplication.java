package com.android.cs.project.eforest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CropLossApplication extends AppCompatActivity {
EditText edTime,edDesc,edCropDEs,edNat,edAmount,edSent,edName,edPlace;
Button btnSave;
Crop crop;
SharedPreferences preferences;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_loss_application);
        btnSave=(Button)findViewById(R.id.save4);
        edAmount=(EditText)findViewById(R.id.amountCrop);
        edCropDEs=(EditText)findViewById(R.id.deCrop);
        edDesc=(EditText)findViewById(R.id.descCrop);
        edName=(EditText)findViewById(R.id.nameCrop);
        edPlace=(EditText)findViewById(R.id.placeCrop);
        edSent=(EditText)findViewById(R.id.sentCrop);
        edTime=(EditText)findViewById(R.id.timeCrop);
        edNat=(EditText)findViewById(R.id.natureCrop);

        Intent intent=getIntent();
        final String temp=intent.getStringExtra("MNO");

        preferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
        String mno=preferences.getString("mobile",null);
        reference= FirebaseDatabase.getInstance().getReference().child("eForest").child("Applications").child("Crop Loss").child(mno);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSave.setVisibility(View.INVISIBLE);
                if ((edTime.getText().toString().trim()).isEmpty()){
                    edTime.setError("required field");
                    edTime.requestFocus();
                }else if ((edNat.getText().toString().trim()).isEmpty()){
                    edNat.setError("required field");
                    edNat.requestFocus();
                }else if ((edSent.getText().toString().trim()).isEmpty()){
                    edSent.setError("required field");
                    edSent.requestFocus();
                }else if ((edAmount.getText().toString().trim()).isEmpty()){
                    edAmount.setError("required field");
                    edAmount.requestFocus();
                }else if ((edName.getText().toString().trim()).isEmpty()){
                    edName.setError("required field");
                    edName.requestFocus();
                }else {


                    crop=new Crop();
                    crop.setAmount(edAmount.getText().toString().trim());
                    crop.setArea(edSent.getText().toString().trim());
                    crop.setCrop_nature(edNat.getText().toString().trim());
                    crop.setCroploss_desc(edCropDEs.getText().toString().trim());
                    crop.setDescription(edDesc.getText().toString().trim());
                    crop.setName(edName.getText().toString().trim());
                    crop.setPlace(edPlace.getText().toString().trim());
                    crop.setTime(edTime.getText().toString().trim());


                    reference.child(temp).setValue(crop).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(getApplicationContext(),ApplayApplication2.class);
                            intent.putExtra("MNO",temp);
                            startActivity(intent);
                        }
                    });
                }
                btnSave.setVisibility(View.VISIBLE);
            }
        });

    }
}
