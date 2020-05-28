package com.android.cs.project.eforest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRegisteration2 extends AppCompatActivity {
String mobileno,name,email,password;
EditText edname,edpassword,edcnfpass,edmobile,edemail;
Button btnReg;
User user;
DatabaseReference reference;
SharedPreferences.Editor editor;
private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registeration2);
        Intent intent=getIntent();
        mobileno=intent.getStringExtra("mobileno");
        name=intent.getStringExtra("name");
        edcnfpass=(EditText)findViewById(R.id.repassUserReg2);
        edemail=(EditText)findViewById(R.id.emailUserReg2);
        edmobile=(EditText)findViewById(R.id.mobilenoUserReg2);
        edname=(EditText)findViewById(R.id.nameUserReg2);
        edpassword=(EditText)findViewById(R.id.passwordUserReg2);
        btnReg=(Button)findViewById(R.id.registerUserReg2);
        edname.setText(name);
        edmobile.setText(mobileno);
        reference= FirebaseDatabase.getInstance().getReference().child("eForest").child("Users").child(mobileno);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=new User();
                email=edemail.getText().toString().trim();
                password=edpassword.getText().toString().trim();
                if (email.isEmpty())
                {
                    edemail.setError("email is required");
                    edemail.requestFocus();
                }else if (password.isEmpty())
                {
                    edpassword.setError("password is required");
                    edpassword.requestFocus();
                }else if (password.length()<8)
                {
                    edpassword.setError("Minimum 8 Characters Required");
                    edpassword.requestFocus();
                }else if ((edcnfpass.getText().toString().trim()).isEmpty())
                {
                    edcnfpass.setError("password is required");
                    edcnfpass.requestFocus();
                }else {

                    if(password.equals((edcnfpass.getText().toString().trim()))){

                        //Uploading data....
                        user.setEmail(email);
                        user.setMobileno(mobileno);
                        user.setName(name);
                        user.setPassword(password);
                        reference.setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"User Registered",Toast.LENGTH_LONG).show();
                            }
                        });
                        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    editor=getSharedPreferences("LOGIN",MODE_PRIVATE).edit();
                                    editor.putString("emaili",email);
                                    editor.putString("mobile",mobileno);
                                    editor.commit();
                                    startActivity( new Intent(getApplicationContext(),HomeUi.class) );
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(),"Registeration Error...",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                    else
                    {
                        edcnfpass.setText("");
                        edcnfpass.setError("password's are different");
                        edcnfpass.requestFocus();
                    }
                }
            }
        });
    }
}
