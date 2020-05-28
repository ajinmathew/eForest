package com.android.cs.project.eforest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HelpLine extends AppCompatActivity {
    TextView txtKannur,txtWayanad,txtPalakkad,txtNilambur,txtMannarkad,txtKozhikode,txtPeppara,txtRanni,txtKodanad1,txtKodanad2;
    String Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_line);

        txtKannur=(TextView)findViewById(R.id.callKannur);
        txtWayanad=(TextView)findViewById(R.id.callWayanad);
        txtPalakkad=(TextView)findViewById(R.id.callPalakkad);
        txtNilambur=(TextView)findViewById(R.id.callNilambur);
        txtMannarkad=(TextView)findViewById(R.id.callMannarkad);
        txtKozhikode=(TextView)findViewById(R.id.callKozhikode);
        txtPeppara=(TextView)findViewById(R.id.callPeppara);
        txtRanni=(TextView)findViewById(R.id.callRani);
        txtKodanad1=(TextView)findViewById(R.id.callKodanad1);
        txtKodanad2=(TextView)findViewById(R.id.callKodanad2);

        txtKannur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number="+91"+txtKannur.getText().toString().trim();
                Toast.makeText(getApplicationContext(),"Calling to "+Number,Toast.LENGTH_LONG).show();
                Intent intent=new Intent( Intent.ACTION_CALL );
                intent.setData( Uri.parse("tel:"+Number) );
                if(ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity( intent );
            }
        });
        txtKodanad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number="+91"+txtKodanad1.getText().toString().trim();
                Toast.makeText(getApplicationContext(),"Calling to "+Number,Toast.LENGTH_LONG).show();
                Intent intent=new Intent( Intent.ACTION_CALL );
                intent.setData( Uri.parse("tel:"+Number) );
                if(ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity( intent );
            }
        });
        txtKodanad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number="+91"+txtKodanad2.getText().toString().trim();
                Toast.makeText(getApplicationContext(),"Calling to "+Number,Toast.LENGTH_LONG).show();
                Intent intent=new Intent( Intent.ACTION_CALL );
                intent.setData( Uri.parse("tel:"+Number) );
                if(ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity( intent );
            }
        });
        txtPeppara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number="+91"+txtPeppara.getText().toString().trim();
                Toast.makeText(getApplicationContext(),"Calling to "+Number,Toast.LENGTH_LONG).show();
                Intent intent=new Intent( Intent.ACTION_CALL );
                intent.setData( Uri.parse("tel:"+Number) );
                if(ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity( intent );
            }
        });
        txtRanni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number="+91"+txtRanni.getText().toString().trim();
                Toast.makeText(getApplicationContext(),"Calling to "+Number,Toast.LENGTH_LONG).show();
                Intent intent=new Intent( Intent.ACTION_CALL );
                intent.setData( Uri.parse("tel:"+Number) );
                if(ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity( intent );
            }
        });
        txtMannarkad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number="+91"+txtMannarkad.getText().toString().trim();
                Toast.makeText(getApplicationContext(),"Calling to "+Number,Toast.LENGTH_LONG).show();
                Intent intent=new Intent( Intent.ACTION_CALL );
                intent.setData( Uri.parse("tel:"+Number) );
                if(ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity( intent );
            }
        });
        txtKozhikode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number="+91"+txtKozhikode.getText().toString().trim();
                Toast.makeText(getApplicationContext(),"Calling to "+Number,Toast.LENGTH_LONG).show();
                Intent intent=new Intent( Intent.ACTION_CALL );
                intent.setData( Uri.parse("tel:"+Number) );
                if(ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity( intent );
            }
        });
        txtWayanad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number="+91"+txtWayanad.getText().toString().trim();
                Toast.makeText(getApplicationContext(),"Calling to "+Number,Toast.LENGTH_LONG).show();
                Intent intent=new Intent( Intent.ACTION_CALL );
                intent.setData( Uri.parse("tel:"+Number) );
                if(ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity( intent );
            }
        });
        txtPalakkad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number="+91"+txtPalakkad.getText().toString().trim();
                Toast.makeText(getApplicationContext(),"Calling to "+Number,Toast.LENGTH_LONG).show();
                Intent intent=new Intent( Intent.ACTION_CALL );
                intent.setData( Uri.parse("tel:"+Number) );
                if(ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity( intent );
            }
        });
        txtNilambur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number="+91"+txtNilambur.getText().toString().trim();
                Toast.makeText(getApplicationContext(),"Calling to "+Number,Toast.LENGTH_LONG).show();
                Intent intent=new Intent( Intent.ACTION_CALL );
                intent.setData( Uri.parse("tel:"+Number) );
                if(ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE )!= PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity( intent );
            }
        });


    }
}
