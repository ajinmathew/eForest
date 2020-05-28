package com.android.cs.project.eforest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText edusername,edpassword,edMobile;
    Button btnLogin;
    TextView signup;
    FirebaseAuth mAuth;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent=getIntent();
        final String TAG=intent.getStringExtra("TAG");

        //Toast.makeText(getApplicationContext(),TAG,Toast.LENGTH_LONG).show();
        mAuth=FirebaseAuth.getInstance();
        edusername=(EditText)findViewById(R.id.usernameLogin);
        edpassword=(EditText)findViewById(R.id.passwordLogin);
        edMobile=(EditText)findViewById(R.id.mobileLogin);
        btnLogin=(Button)findViewById(R.id.loginLogin);
        //login...
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name,password,mobile,mob;
                name=edusername.getText().toString().trim();
                password=edpassword.getText().toString().trim();
                mob=edMobile.getText().toString().trim();
                mobile="+91"+mob;


                if (name.isEmpty()){
                    edusername.setError("UserName is required");
                    edusername.requestFocus();
                }else if (mob.isEmpty()){
                    edMobile.setError("Mobile Number is required");
                    edMobile.requestFocus();
                }else if (mob.length()<10){
                    edMobile.setError("Invalid Mobile Number");
                    edMobile.requestFocus();
                }
                else if (password.isEmpty()){
                    edpassword.setError("Password is required");
                    edpassword.requestFocus();
                }else if (password.length()<8){
                    edpassword.setError("Minimum 8 Characters");
                    edpassword.requestFocus();
                }else {

                    mAuth.signInWithEmailAndPassword(name,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                editor=getSharedPreferences("LOGIN",MODE_PRIVATE).edit();
                                editor.putString("emailid",name);
                                editor.putString("mobile",mob);
                                editor.commit();
                                Toast.makeText(getApplicationContext(),"Authentication Complete...",Toast.LENGTH_SHORT).show();
                                if (TAG.equals("application")){
                                    //startActivity(new Intent(getApplicationContext(),ViewApplication.class));
                                    startActivity(new Intent(getApplicationContext(),ApplicationHome.class));
                                }else {
                                    startActivity(new Intent(getApplicationContext(),RapidResponse.class));
                                }

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Error...Authentication Failed...",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }


            }
        });


        //User signup...
        signup=(TextView)findViewById(R.id.user_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),User_signup.class);
                startActivity(intent);
            }
        });

    }
}
