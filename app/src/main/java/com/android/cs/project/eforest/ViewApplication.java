package com.android.cs.project.eforest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewApplication extends AppCompatActivity {
    TextView txtName,txtDob,txtType,txtAddress,txtDivision,txtRange,txtPlace,txtDate;
    DatabaseReference reference;
    SharedPreferences preferences;
    LinearLayout l1,l2,l3,l4,l5,l6,l7,l8,l9;
    Button btnApply;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    List<Application> listApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_application);



        recyclerView=(RecyclerView)findViewById(R.id.recyclerviewApplication);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        listApplication=new ArrayList<>();
        preferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
        String mno=preferences.getString("mobile",null);


        reference= FirebaseDatabase.getInstance().getReference().child("eForest").child("Applications").child("General").child(mno);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot dataApp:dataSnapshot.getChildren()){
                        Application application=dataApp.getValue(Application.class);
                        listApplication.add(application);
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Applications are not Submitted",Toast.LENGTH_LONG).show();
                }
                adapter=new CustomAdapterApplication(listApplication,getApplicationContext());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}
