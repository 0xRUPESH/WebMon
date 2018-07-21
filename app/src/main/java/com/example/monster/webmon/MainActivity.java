package com.example.monster.webmon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int websites_count;
    EditText website_location;
    EditText website_grab;
    String already;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        website_location = (EditText) findViewById(R.id.editText2);
        website_grab = (EditText) findViewById(R.id.editText);
        websites_count = 0;
        already = website_location.getText().toString();
    }

    public void addWebsite(View v){
        Log.i("See","addWesbtei called");
        already = website_location.getText().toString();
        ++websites_count;

        website_location.setText(already+"\n"+websites_count+". "+website_grab.getText());

    }

    public void removeWebsites(View v){
        websites_count=0;
        website_grab.setText("");
        website_location.setText("");
    }
}
