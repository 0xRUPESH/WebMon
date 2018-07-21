package com.example.monster.webmon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class companyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_info);
    }
    public void goBack(View v){
        finish();
    }
    public void aboutApp(View v){
        Intent i = new Intent(getApplicationContext(),about.class); startActivity(i);
    }
}
