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

public class PersonApplication extends AppCompatActivity {
RadioButton RYeas,RNo,accRe,dieRe;
EditText edAccRegStation,edDoc,edRegDoc,edDesc,edName,edPlace;
Button btnSave,btnNext;
Person person;
String crime="",reason="";

SharedPreferences preferences;
DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_application);

        Intent intent=getIntent();
        final String temp=intent.getStringExtra("MNO");
        Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_LONG).show();
        RYeas=(RadioButton)findViewById(R.id.yescrime);
        RNo=(RadioButton)findViewById(R.id.nocrime);
        accRe=(RadioButton)findViewById(R.id.accreason);
        dieRe=(RadioButton)findViewById(R.id.diereason);
        edAccRegStation=(EditText)findViewById(R.id.accidentregstation);
        edDoc=(EditText)findViewById(R.id.nameDocter);
        edRegDoc=(EditText)findViewById(R.id.regnoDoct);
        edDesc=(EditText)findViewById(R.id.descAcc);
        edName=(EditText)findViewById(R.id.nameAppli);
        edPlace=(EditText)findViewById(R.id.placeAppil);
        btnSave=(Button)findViewById(R.id.save2);
        btnNext=(Button)findViewById(R.id.next2);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnSave.setVisibility(View.INVISIBLE);
                if (RYeas.isChecked()){
                    crime="yes";
                }
                if (RNo.isChecked()){
                    crime="no";
                }
                if (accRe.isChecked()){
                    reason="accident";
                }
                if (dieRe.isChecked()){
                    reason="death";
                }
                if(crime.equals("")){
                    Toast.makeText(getApplicationContext(),"required field",Toast.LENGTH_LONG).show();
                }
                if(reason.equals("")){
                    Toast.makeText(getApplicationContext(),"required field",Toast.LENGTH_LONG).show();
                }

                if ((edDoc.getText().toString().trim()).isEmpty()){
                    edDoc.setError("Doctor Name is required");
                    edDoc.requestFocus();
                }else if ((edRegDoc.getText().toString().trim()).isEmpty()){
                    edRegDoc.setError("Doctor register no is required");
                    edRegDoc.requestFocus();
                }else if ((edName.getText().toString().trim()).isEmpty()){
                    edName.setError("Name is required");
                    edName.requestFocus();
                }else {
                    person=new Person();
                    person.setReg_doctor(edRegDoc.getText().toString().trim());
                    person.setPloice_station(edAccRegStation.getText().toString().trim());
                    person.setPlace(edPlace.getText().toString().trim());
                    person.setDoctor(edDoc.getText().toString().trim());
                    person.setDescription(edDesc.getText().toString().trim());
                    person.setCrime(crime);
                    person.setCompensation_reson(reason);
                    person.setApp_name(edName.getText().toString().trim());
                    preferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
                    String mno=preferences.getString("mobile",null);
                    reference= FirebaseDatabase.getInstance().getReference().child("eForest").child("Applications").child("PersonAccident").child(mno);
                    reference.child(temp).setValue(person).addOnSuccessListener(new OnSuccessListener<Void>() {
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
