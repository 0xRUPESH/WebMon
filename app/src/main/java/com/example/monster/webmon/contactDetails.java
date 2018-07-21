package com.example.monster.webmon;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class contactDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
    }

    public void call(View v){
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            String phone = "+918347844601";
            Intent i = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", phone, null));
            startActivity(i);
        }else{
            Toast.makeText(this,"Please give the permission", Toast.LENGTH_LONG).show();
        }
    }

    public void map(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.co.in/maps?q=Christ+University+Bangalore,Hosur+Road") );
        startActivity(i);
    }

    public void emailMe(View v){
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL  , new String[] { "me@somewhere.com" });
        i.putExtra(Intent.EXTRA_SUBJECT, "My subject");

        startActivity(Intent.createChooser(i, "Email via..."));

    }
    public void web(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ronli.xyz"));
        startActivity(i);
    }
}
