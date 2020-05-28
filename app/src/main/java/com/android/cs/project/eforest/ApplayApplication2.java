package com.android.cs.project.eforest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplayApplication2 extends AppCompatActivity {
EditText edNameBank,edifscBank,edAccnoBank,edBranchBank,edCnfAccno;
Button btnSelTax,btnSave,btnIdentity,btnPassbook;
String taxpath=null;
String passbookpath=null;
String identitypath=null;
    ProgressBar progressBar;
    Bank bank;
    SharedPreferences preferences;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1){
            if (resultCode==RESULT_OK){
                try {
                    assert data != null;
                    Uri fileUri=data.getData();
                    //Setting reference of storege,.. Child name is the folder name...
                    StorageReference storageReference= FirebaseStorage.getInstance().getReference().child("eForest").child("Documents");
                    //Creating a timestamp for rename...
                    String timestamp=String.valueOf(System.currentTimeMillis());
                    final StorageReference storageReference1=storageReference.child(timestamp+fileUri.getLastPathSegment());
                    storageReference1.putFile(fileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            //Download the uploaded file url from storefe... To store it in database...
                            storageReference1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    //uri contain the path of the Uploaded file...
                                    taxpath=String.valueOf(uri);
                                    Toast.makeText(getApplicationContext(),"File Uploaded",Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.INVISIBLE);
                                }
                            });
                        }
                    });
                }catch (NullPointerException ne){
                    Toast.makeText(getApplicationContext(),"Null Pointer exception occured",Toast.LENGTH_LONG).show();
                }

            }
        }

        if (requestCode==2){
            if (resultCode==RESULT_OK){
                try {
                    assert data != null;
                    Uri fileUri=data.getData();
                    //Setting reference of storege,.. Child name is the folder name...
                    StorageReference storageReference= FirebaseStorage.getInstance().getReference().child("eForest").child("Documents");
                    //Creating a timestamp for rename...
                    String timestamp=String.valueOf(System.currentTimeMillis());
                    final StorageReference storageReference1=storageReference.child(timestamp+fileUri.getLastPathSegment());
                    storageReference1.putFile(fileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            //Download the uploaded file url from storefe... To store it in database...
                            storageReference1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    //uri contain the path of the Uploaded file...
                                    passbookpath=String.valueOf(uri);
                                    Toast.makeText(getApplicationContext(),"File Uploaded",Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.INVISIBLE);
                                }
                            });
                        }
                    });
                }catch (NullPointerException ne){
                    Toast.makeText(getApplicationContext(),"Null Pointer exception occured",Toast.LENGTH_LONG).show();
                }

            }
        }
        if (requestCode==3){
            if (resultCode==RESULT_OK){
                try {
                    assert data != null;
                    Uri fileUri=data.getData();
                    //Setting reference of storege,.. Child name is the folder name...
                    StorageReference storageReference= FirebaseStorage.getInstance().getReference().child("eForest").child("Documents");
                    //Creating a timestamp for rename...
                    String timestamp=String.valueOf(System.currentTimeMillis());
                    final StorageReference storageReference1=storageReference.child(timestamp+fileUri.getLastPathSegment());
                    storageReference1.putFile(fileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            //Download the uploaded file url from storefe... To store it in database...
                            storageReference1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    //uri contain the path of the Uploaded file...
                                    identitypath=String.valueOf(uri);
                                    Toast.makeText(getApplicationContext(),"File Uploaded",Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.INVISIBLE);
                                }
                            });
                        }
                    });
                }catch (NullPointerException ne){
                    Toast.makeText(getApplicationContext(),"Null Pointer exception occured",Toast.LENGTH_LONG).show();
                }

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applay_application2);
        progressBar=(ProgressBar)findViewById(R.id.prgress);
        edAccnoBank=(EditText)findViewById(R.id.accnoBank);
        edBranchBank=(EditText)findViewById(R.id.branchBank);
        edifscBank=(EditText)findViewById(R.id.ifscBank);
        edNameBank=(EditText)findViewById(R.id.nameBank);
        edCnfAccno=(EditText)findViewById(R.id.cnfaccnoBank);

        Intent intent=getIntent();
        final String temp=intent.getStringExtra("MNO");


        btnSelTax=(Button)findViewById(R.id.taxImg);
        btnSave=(Button)findViewById(R.id.saveBank);
        btnIdentity=(Button)findViewById(R.id.identityImg);
        btnPassbook=(Button)findViewById(R.id.passbookImg);
        btnSelTax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSelTax.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,1);
            }
        });
        btnPassbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPassbook.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,2);
            }
        });
        btnIdentity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnIdentity.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,3);
            }
        });
        preferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
        String mno=preferences.getString("mobile",null);
        final DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("eForest").child("Applications").child("Bank,Documents").child(mno);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnSave.setVisibility(View.INVISIBLE);
                if ((edNameBank.getText().toString().trim()).isEmpty()){
                    edNameBank.setError("Bank name is required");
                    edNameBank.requestFocus();
                }else if ((edifscBank.getText().toString().trim()).isEmpty()){
                    edifscBank.setError("IFSC is required");
                    edifscBank.requestFocus();
                }else if ((edBranchBank.getText().toString().trim()).isEmpty()){
                    edBranchBank.setError("Branch name is required");
                    edBranchBank.requestFocus();
                }else if ((edAccnoBank.getText().toString().trim()).isEmpty()){
                    edAccnoBank.setError("account no is required");
                    edAccnoBank.requestFocus();
                }else if ((edCnfAccno.getText().toString().trim()).isEmpty()){
                    edCnfAccno.setError("account no is required");
                    edCnfAccno.requestFocus();
                }else {
                    if ((edAccnoBank.getText().toString().trim()).equals(edCnfAccno.getText().toString().trim())){

                        if (taxpath.equals(null)){
                            Toast.makeText(getApplicationContext(),"Wait Image is Selecting!..",Toast.LENGTH_LONG).show();
                        }else if (identitypath.equals(null)){
                            Toast.makeText(getApplicationContext(),"Wait Image is Selecting!..",Toast.LENGTH_LONG).show();
                        }else if (passbookpath.equals(null)){
                            Toast.makeText(getApplicationContext(),"Wait Image is Selecting!..",Toast.LENGTH_LONG).show();
                        }else if (passbookpath.equals(null)){
                            Toast.makeText(getApplicationContext(),"Wait Image is Selecting!..",Toast.LENGTH_LONG).show();
                        }else {

                            bank=new Bank();
                            bank.setTaxImgUrl(taxpath);
                            bank.setIdentityImgUrl(identitypath);
                            bank.setPassbookImgUrl(passbookpath);
                            bank.setBankAccNo(edAccnoBank.getText().toString().trim());
                            bank.setBankBranch(edBranchBank.getText().toString().trim());
                            bank.setBankIFSC(edifscBank.getText().toString().trim());
                            bank.setBankName(edNameBank.getText().toString().trim());
                            DateFormat df= new SimpleDateFormat("MMM-dd,yyyy HH:mm:ss");
                            Date dateobj = new Date();
                            bank.setTime(df.format(dateobj));

                            reference.child(temp).setValue(bank).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                                    identitypath=null;
                                    taxpath=null;
                                    passbookpath=null;
                                    startActivity(new Intent(getApplicationContext(),HomeUi.class));
                                }
                            });

                        }

                    }else {
                        edCnfAccno.setError("Account no diffrent");
                        edCnfAccno.requestFocus();
                        edCnfAccno.setText("");
                    }
                }
                btnSave.setVisibility(View.VISIBLE);
            }
        });
    }
}
