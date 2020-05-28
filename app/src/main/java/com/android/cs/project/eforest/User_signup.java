package com.android.cs.project.eforest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class User_signup extends AppCompatActivity {

    Button btnverify,btnOtpVerify;
    LinearLayout L;
    EditText edName,edPhone,edOtp;
    String mobileno,name,verificationcode,phoneno;
    DatabaseReference reference;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);
        edName=(EditText)findViewById(R.id.nameUserReg);
        edPhone=(EditText)findViewById(R.id.phoneUserReg);
        edOtp=(EditText)findViewById(R.id.otpUserReg);
        btnOtpVerify=(Button)findViewById(R.id.otpbtnUserReg);
        btnverify=(Button) findViewById(R.id.verifyUserReg);
        L=(LinearLayout) findViewById(R.id.layout);
        auth=FirebaseAuth.getInstance();
        reference= FirebaseDatabase.getInstance().getReference().child("eForest").child("User");
        btnverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobileno=edPhone.getText().toString().trim();
                name=edName.getText().toString().trim();
                if (name.isEmpty())
                {
                    edName.setError("Name is required");
                    edName.requestFocus();
                }
                else if (mobileno.isEmpty())
                {
                    edPhone.setError("Mobile No. is required");
                    edPhone.requestFocus();
                }
                else if (mobileno.length()<10)
                {
                    edPhone.setError("Mobile No. must have 10 numbers");
                    edPhone.requestFocus();
                }else{
                    phoneno="+91" + mobileno;
                    Query query=reference.orderByChild("mobileno").equalTo(phoneno);
                    query.addListenerForSingleValueEvent(new ValueEventListener()
                    {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                        {
                            if (dataSnapshot.exists())
                            {
                                edPhone.setError("Customer already exist..! Try Login");
                                edPhone.requestFocus();
                            }
                            else
                            {
                                sendVerificationCode(phoneno);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError)
                        {

                        }
                    });
                }
                //make visible ...
                L.setVisibility(View.VISIBLE);
            }
        });


        btnOtpVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code=edOtp.getText().toString().trim();
                if (code.isEmpty()||code.length()<6)
                {
                    edOtp.setError("Enter code...!");
                    edOtp.requestFocus();
                    return;
                }
                verfyCode(code);
            }
        });

    }



    public void verfyCode(String code)
    {
        edOtp.setText(code);
        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(verificationcode, code);
        signInWithCredential(credential);
    }
    void signInWithCredential(PhoneAuthCredential credential)
    {
        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Otp Verification Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),UserRegisteration2.class);
                    intent.putExtra("mobileno",mobileno);
                    intent.putExtra("name",name);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Otp Verification failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void sendVerificationCode(String phoneno) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneno,30, TimeUnit.SECONDS,this,mCallBack);
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential)
        {
            String code=phoneAuthCredential.getSmsCode();
            if (code!=null)
            {
                verfyCode(code);
            }
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationcode = s;
        }

        @Override
        public void onVerificationFailed(FirebaseException e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    };
}
