package com.android.cs.project.eforest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class RapidResponse extends AppCompatActivity {
    Button btnSendLocation,btnGetLocation;
    EditText edDescr;
    FusedLocationProviderClient client;
    String lat,lng;
    SharedPreferences preferences;
    com.android.cs.project.eforest.Location location;

    /*@Override
    protected void onStart() {
        super.onStart();

        client=LocationServices.getFusedLocationProviderClient(this);
        client.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location!=null){
                    lat=String.valueOf((double)location.getLatitude());
                    lng=String.valueOf((double)location.getLongitude());
                }
            }
        });

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapid_response);
        client=LocationServices.getFusedLocationProviderClient(this);
        client.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location!=null){
                    lat=String.valueOf((double)location.getLatitude());
                    lng=String.valueOf((double)location.getLongitude());
                }
            }
        });
        preferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
        final String mobile=preferences.getString("mobile",null);
        edDescr = (EditText) findViewById(R.id.descrRR);
        btnSendLocation = (Button) findViewById(R.id.sendLocationRR);
        btnGetLocation = (Button) findViewById(R.id.getLocationRR);
        btnGetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),lat+"   "+lng,Toast.LENGTH_LONG).show();
            }
        });

        btnSendLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                location=new com.android.cs.project.eforest.Location();
                location.setMessage(edDescr.getText().toString().trim());
                location.setLocation(lat+","+lng);
                DateFormat df= new SimpleDateFormat("MMM-dd,yyyy HH:mm:ss");
                Date dateobj = new Date();
                location.setTime(df.format(dateobj));
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("eForest").child("Locations").child(mobile);
                reference.setValue(location).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"Location Updated",Toast.LENGTH_SHORT).show();


                    }
                });


            }
        });



    }


}
