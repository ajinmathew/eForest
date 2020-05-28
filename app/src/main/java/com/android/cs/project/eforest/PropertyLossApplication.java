package com.android.cs.project.eforest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PropertyLossApplication extends AppCompatActivity {
EditText edType,edTime,edDesc,edLoses,edName,edPlace;
String reason="";
RadioButton rHouse,rProperty;
Button btnSave;
Property property;
SharedPreferences preferences;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_loss_application);
        btnSave=(Button)findViewById(R.id.save5);
        edDesc=(EditText)findViewById(R.id.descPro);
        edLoses=(EditText)findViewById(R.id.ideaPro);
        edName=(EditText)findViewById(R.id.namePro);
        edPlace=(EditText)findViewById(R.id.placePro);
        edTime=(EditText)findViewById(R.id.timePro);
        edType=(EditText)findViewById(R.id.natPro);
        rHouse=(RadioButton)findViewById(R.id.house);
        rProperty=(RadioButton)findViewById(R.id.property);
        preferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
        String mno=preferences.getString("mobile",null);
        reference= FirebaseDatabase.getInstance().getReference().child("eForest").child("Applications").child("Property Loss").child(mno);
        Intent intent=getIntent();
        final String temp=intent.getStringExtra("MNO");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnSave.setVisibility(View.INVISIBLE);
                if (rHouse.isChecked()){
                    reason="House";
                }
                if (rProperty.isChecked()){
                    reason="Property";
                }
                if ((edType.getText().toString().trim()).isEmpty()){
                    edType.setError("Field required");
                    edType.requestFocus();
                }else if ((edTime.getText().toString().trim()).isEmpty()){
                    edTime.setError("Field required");
                    edTime.requestFocus();
                }else if ((edLoses.getText().toString().trim()).isEmpty()){
                    edLoses.setError("Field required");
                    edLoses.requestFocus();
                }else if ((edName.getText().toString().trim()).isEmpty()){
                    edName.setError("Field required");
                    edName.requestFocus();
                }else if (reason.equals("")){
                    Toast.makeText(getApplicationContext(),"required fields",Toast.LENGTH_LONG).show();
                }else {

                    property=new Property();
                    property.setDescription(edDesc.getText().toString().trim());
                    property.setLosesrate(edLoses.getText().toString().trim());
                    property.setName(edName.getText().toString().trim());
                    property.setPlace(edPlace.getText().toString().trim());
                    property.setReason(reason);
                    property.setTime(edTime.getText().toString().trim());
                    property.setType(edType.getText().toString().trim());

                    reference.child(temp).setValue(property).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();
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
