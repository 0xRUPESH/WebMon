package com.example.monster.webmon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class cart extends AppCompatActivity {

    String burger, ice, pizza;
    int pizPrice, burPrice, icePrice, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        pizPrice = 100;
        burPrice = 50;
        icePrice = 80;
        burger=ice=pizza = "";
    }

    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();


        switch(view.getId()) {
            case R.id.checkBurger:
                if (checked){
                    burger = "Burger";
                    sum+=burPrice;
                }
            else {
                    burger = "";
                    if (sum >= burPrice)
                        sum -= burPrice;
                }
                break;
            case R.id.checkIce:
                if (checked){
                    ice = "Ice-Cream";
                    sum+=icePrice;
                }
                // Cheese me
            else {
                    ice = "";
                    if (sum >= icePrice)
                        sum -= icePrice;

                }
                break;
            case R.id.checkPizza:
                if(checked){
                    pizza = "Pizza";
                    sum+=pizPrice;
                }else{
                    pizza="";
                    if(sum>=pizPrice)
                        sum-=pizPrice;

                }

        }
    }


    public void buttClicked(View v){
        Log.i("Hi","Items: "+burger+" "+pizza+" "+ice);
        Toast.makeText(this,"Items: "+burger+" "+pizza+" "+ice + "\nTotal: "+Integer.toString(sum),Toast.LENGTH_SHORT).show();


    }
}
