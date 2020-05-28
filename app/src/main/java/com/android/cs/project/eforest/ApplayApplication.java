package com.android.cs.project.eforest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.niwattep.materialslidedatepicker.SlideDatePickerDialog;
import com.niwattep.materialslidedatepicker.SlideDatePickerDialogCallback;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class ApplayApplication extends AppCompatActivity implements SlideDatePickerDialogCallback {
Spinner spinner;
RadioButton ryes,rno;
EditText nameApp,relationApp,addressApp,pinApp,incomeApp,divisionApp,rangeApp,placeApp,natureAnim,compApp;
Button btnSave,btnView,btnDobApp;

String current;
int nbr;
Application application;
DatabaseReference reference;
SharedPreferences preferences;
String dob="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applay_application);
        spinner=(Spinner)findViewById(R.id.typeApplicant);
        ryes=(RadioButton) findViewById(R.id.yesrad);
        rno=(RadioButton) findViewById(R.id.norad);
        nameApp=(EditText)findViewById(R.id.nameApplicant);
        relationApp=(EditText)findViewById(R.id.relationApplicant);
        addressApp=(EditText)findViewById(R.id.addressApplicant);
        pinApp=(EditText)findViewById(R.id.pincodeApplicant);
        btnDobApp=(Button) findViewById(R.id.dobApplicant);
        incomeApp=(EditText)findViewById(R.id.incomeApplicant);
        divisionApp=(EditText)findViewById(R.id.divisionApplicant);
        rangeApp=(EditText)findViewById(R.id.rangeApplicant);
        placeApp=(EditText)findViewById(R.id.placeApplicant);
        natureAnim=(EditText)findViewById(R.id.natureAnimal);
        compApp=(EditText)findViewById(R.id.compApplicant);
        btnSave=(Button) findViewById(R.id.save1);

        //btnView=(Button) findViewById(R.id.viewApply);

        /*btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ViewApplication.class));
            }
        });*/


        btnDobApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideDatePickerDialog.Builder builder=new SlideDatePickerDialog.Builder();
                SlideDatePickerDialog dialog=builder.build();
                dialog.show(getSupportFragmentManager(),"Dialog");
            }
        });


        preferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
        final String mno=preferences.getString("mobile",null);
        Toast.makeText(getApplicationContext(),mno,Toast.LENGTH_LONG).show();
        reference= FirebaseDatabase.getInstance().getReference().child("eForest").child("Applications").child("General").child(mno);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    nbr= (int) dataSnapshot.getChildrenCount();
                    //Toast.makeText(getApplicationContext(),nbr,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSave.setVisibility(View.INVISIBLE);
                if ((nameApp.getText().toString().trim()).isEmpty())
                {
                    nameApp.setError("Name is required");
                    nameApp.requestFocus();
                }else if(dob.equals("")){
                    Toast.makeText(getApplicationContext(),"Select Date of Birth",Toast.LENGTH_LONG).show();
                }else if ((divisionApp.getText().toString().trim()).isEmpty())
                {
                    divisionApp.setError("Division Name is required");
                    divisionApp.requestFocus();
                }else if ((rangeApp.getText().toString().trim()).isEmpty())
                {
                    rangeApp.setError("Range Name is required");
                    rangeApp.requestFocus();
                }else if ((placeApp.getText().toString().trim()).isEmpty())
                {
                    placeApp.setError("Place is required");
                    placeApp.requestFocus();
                }else if ((natureAnim.getText().toString().trim()).isEmpty())
                {
                    natureAnim.setError("Type is required");
                    natureAnim.requestFocus();
                }else if ((compApp.getText().toString().trim()).isEmpty())
                {
                    compApp.setError("Amount is required");
                    compApp.requestFocus();
                }else {


                    application=new Application();
                    if(rno.isChecked()){
                        current="no";
                    }
                    if (ryes.isChecked()){
                        current="yes";
                    }
                    application.setDob(dob);
                    application.setAddressApplicant(addressApp.getText().toString().trim());
                    application.setNameApplicant(nameApp.getText().toString().trim());
                    application.setCompensation_amount(compApp.getText().toString().trim());
                    application.setForest_division(divisionApp.getText().toString().trim());
                    application.setForest_range(rangeApp.getText().toString().trim());
                    application.setIncome(incomeApp.getText().toString().trim());
                    application.setNature_of_accident(natureAnim.getText().toString().trim());
                    application.setPincode(pinApp.getText().toString().trim());
                    application.setPlace_accident(placeApp.getText().toString().trim());
                    application.setRelationofApplicant(relationApp.getText().toString().trim());
                    application.setTypeApplication((String) spinner.getSelectedItem());
                    application.setCurrntPerson(current);
                    final String temp=mno+(nbr++);
                    application.setId(temp);
                    //date are in the format of Feb-20,2020  21.31.10
                    DateFormat df= new SimpleDateFormat("MMM-dd,yyyy HH:mm:ss");
                    Date dateobj = new Date();
                    application.setDate(df.format(dateobj));
                    /*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    application.setDate(String.valueOf(date));*/
                    //preferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
                    //String mno=preferences.getString("mobile",null);
                    application.setMobile(mno);

                    //reference= FirebaseDatabase.getInstance().getReference().child("eForest").child("Applications").child("General").child(mno);
                    reference.child(temp).setValue(application).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();

                            String type= (String) spinner.getSelectedItem();
                            if (type.equals("Select")){
                                Toast.makeText(getApplicationContext(),"Please select type of accident",Toast.LENGTH_SHORT).show();

                            }else {

                                if (type.equals("1.Death or injury of persons")){
                                    Intent intent=new Intent(getApplicationContext(),PersonApplication.class);
                                    intent.putExtra("MNO",temp);
                                    startActivity(intent);
                                }else if (type.equals("2.Cattle Death")){
                                    Intent intent=new Intent(getApplicationContext(),CattleDeathApplication.class);
                                    intent.putExtra("MNO",temp);
                                    startActivity(intent);

                                }else if (type.equals("3.Crop Loss")){
                                    Intent intent=new Intent(getApplicationContext(),CropLossApplication.class);
                                    intent.putExtra("MNO",temp);
                                    startActivity(intent);
                                }else if (type.equals("4.House or property loss")){
                                    Intent intent=new Intent(getApplicationContext(),PropertyLossApplication.class);
                                    intent.putExtra("MNO",temp);
                                    startActivity(intent);
                                }
                            }
                        }
                    });



                }
                btnSave.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void onPositiveClick(int day, int month, int year, Calendar calendar) {
        //use EEEE in pattern for impliment the day such as Sunday....
        SimpleDateFormat format=new SimpleDateFormat("dd MMM,YYYY", Locale.getDefault());
        btnDobApp.setText(format.format(calendar.getTime()));
        dob=format.format(calendar.getTime());
    }
}
