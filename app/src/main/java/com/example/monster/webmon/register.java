package com.example.monster.webmon;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class register extends AppCompatActivity {
    Spinner spinner;
    DatePicker date;
    Calendar mycal;
    EditText dob_tex,e_name,e_email,e_phone,e_address;
    ScrollView layout;
    Switch sw;
    String email;
    Boolean go;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Please accept the T&C first!");

        toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);



        go = false;
        spinner = (Spinner)findViewById(R.id.spinner);
        String domains[] = {"@gmail.com", "@yahoo.com", "@hotmail.com","@outlook.com","@icloud.com"};

        dob_tex = (EditText)findViewById(R.id.dob);

        layout = (ScrollView)findViewById(R.id.Major);

        sw = (Switch)findViewById(R.id.switch1);

        e_name = (EditText)findViewById(R.id.name);

        e_email = (EditText)findViewById(R.id.email);

        e_phone = (EditText)findViewById(R.id.phone);

        e_address = (EditText)findViewById(R.id.address);

        //date = (DatePicker)findViewById(R.id.dob);
        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,domains);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    go = true;
                }else{
                    go = false;
                    //layout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                }
            }
        });
    }


    public void pickDate(View v){
        mycal = Calendar.getInstance();

        int mYear=mycal.get(Calendar.YEAR);
        int mMonth=mycal.get(Calendar.MONTH);
        int mDay=mycal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker=new DatePickerDialog(register.this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                dob_tex.setText(selectedday+"/"+selectedmonth+"/"+selectedyear);
                Log.i("date",selectedday+" "+selectedmonth+"  "+selectedyear+"");
            }
        },mYear, mMonth, mDay);
        mDatePicker.setTitle("Select date");
        mDatePicker.show();
    }

    public void speak(String msg){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(msg);

        toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();
    }

    public void register(View v){
        if(go){
            if(e_name.getText().toString().length()>=1){
                String s = spinner.getSelectedItem().toString();
                Intent i = new Intent(getApplicationContext(),info.class);
                i.putExtra("name",e_name.getText().toString());
                i.putExtra("email",e_email.getText().toString()+s);
                startActivity(i);
            }else{
                speak("Please fill in the details!!");
            }

        }else{
            toast.show();
        }

    }
}

