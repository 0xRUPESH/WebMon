package com.example.monster.webmon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    public void goBack(View v){
        finish();
    }
    public void same(View v){
        Intent i = new Intent(getApplicationContext(),about.class); startActivity(i);
    }
}
