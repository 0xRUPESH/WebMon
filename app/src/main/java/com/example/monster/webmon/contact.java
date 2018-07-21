package com.example.monster.webmon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void openDetails(View v ){
        Intent i = new Intent(getApplicationContext(), contactDetails.class); startActivity(i);
        finish();
    }

}
