package com.example.monster.webmon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class info extends AppCompatActivity {

    EditText name, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        String name_value = getIntent().getStringExtra("name");
        String email_value = getIntent().getStringExtra("email");
        name.setText(name_value);
        email.setText(email_value);

    }
}
