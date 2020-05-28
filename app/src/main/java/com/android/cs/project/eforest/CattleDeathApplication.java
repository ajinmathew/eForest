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
import com.niwattep.materialslidedatepicker.SlideDatePickerDialog;
import com.niwattep.materialslidedatepicker.SlideDatePickerDialogCallback;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CattleDeathApplication extends AppCompatActivity implements SlideDatePickerDialogCallback {
EditText edNature,edNbr,edDEsc,edName,edPlace;
Button btnSelCer,btnSave,btnDate;
ProgressBar progressBar;
String cerpath="";
Cattle cattle;
String date="";
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
                                    cerpath=String.valueOf(uri);
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
        setContentView(R.layout.activity_cattle_death_application);
        btnDate=(Button)findViewById(R.id.datetimeAccident);
        edDEsc=(EditText)findViewById(R.id.descAccident);
        edName=(EditText)findViewById(R.id.nameApp);
        edNature=(EditText)findViewById(R.id.natureAnimAccident);
        edNbr=(EditText)findViewById(R.id.noAnimal);
        edPlace=(EditText)findViewById(R.id.placeApp);
        btnSave=(Button)findViewById(R.id.save3);
        btnSelCer=(Button)findViewById(R.id.certificateDoc);
        progressBar=(ProgressBar)findViewById(R.id.progress);
        btnSelCer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,1);
            }
        });

        Intent intent=getIntent();
        final String temp=intent.getStringExtra("MNO");

        preferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
        String mno=preferences.getString("mobile",null);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideDatePickerDialog.Builder builder=new SlideDatePickerDialog.Builder();
                SlideDatePickerDialog dialog=builder.build();
                dialog.show(getSupportFragmentManager(),"Dialog");
            }
        });

        final DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("eForest").child("Applications").child("CattleDeath").child(mno);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSave.setVisibility(View.INVISIBLE);
                if (date.equals("")){
                    Toast.makeText(getApplicationContext(),"Select Date",Toast.LENGTH_LONG).show();
                }else if ((edNature.getText().toString().trim()).isEmpty()){
                    edNature.setError("field required");
                    edNature.requestFocus();
                }else if ((edNbr.getText().toString().trim()).isEmpty()){
                    edNbr.setError("field required");
                    edNbr.requestFocus();
                }else if ((edName.getText().toString().trim()).isEmpty()){
                    edName.setError("name required");
                    edName.requestFocus();
                }else if (cerpath.equals("")){
                    Toast.makeText(getApplicationContext(),"Wait Image is Selecting!..",Toast.LENGTH_LONG).show();
                }else {

                    cattle=new Cattle();
                    cattle.setCertificateuUrl(cerpath);
                    cattle.setDateAccident(date);
                    cattle.setDescription(edDEsc.getText().toString().trim());
                    cattle.setName_applicant(edName.getText().toString().trim());
                    cattle.setNatureofAnimal(edNature.getText().toString().trim());
                    cattle.setNo_animal(edNbr.getText().toString().trim());
                    cattle.setPlace(edPlace.getText().toString().trim());

                    reference.child(temp).setValue(cattle).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                            cerpath=null;


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

    @Override
    public void onPositiveClick(int day, int month, int year, Calendar calendar) {
        //use EEEE in pattern for impliment the day such as Sunday....
        SimpleDateFormat format=new SimpleDateFormat("dd MMM,YYYY", Locale.getDefault());
        btnDate.setText(format.format(calendar.getTime()));
        date=format.format(calendar.getTime());
    }
}
