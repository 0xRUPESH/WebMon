package com.example.monster.webmon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class calc extends AppCompatActivity {

    TextView res;
    String prev_pressed;
    String operator;
    float op1,op2;
    int addClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        res = (TextView)findViewById(R.id.result);
        prev_pressed="";
        addClicked=0;

    }

    public void buttClicked(View view){

        String prev = res.getText().toString();
        switch (view.getId()) {
            case R.id.number0:
                res.setText(prev+"0");
                prev_pressed = "number";
                break;

            case R.id.number1:
                res.setText(prev+"1");
                prev_pressed = "number";
                break;

            case R.id.number2:
                res.setText(prev+"2");
                prev_pressed = "number";
                break;

            case R.id.number3:
                res.setText(prev+"3");
                prev_pressed = "number";
                break;

            case R.id.number4:
                res.setText(prev+"4");
                prev_pressed = "number";
                break;
            case R.id.number5:
                res.setText(prev+"5");
                prev_pressed = "number";
                break;
            case R.id.number6:
                res.setText(prev+"6");
                prev_pressed = "number";
                break;
            case R.id.number7:
                res.setText(prev+"7");
                prev_pressed = "number";
                break;
            case R.id.number8:
                res.setText(prev+"8");
                prev_pressed = "number";
                break;
            case R.id.number9:
                res.setText(prev+"9");
                prev_pressed = "number";
                break;
            case R.id.operatorDot:
                if(!prev.contains(".")){
                    res.setText(prev+".");
                    prev_pressed = "number";
                }
                break;

            case R.id.operatorDivide:
                if (res.getText().toString().length() > 0) {
                    op1 = Float.parseFloat(res.getText().toString());

                    operator = "/";
                    res.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Nothing to do", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.operatorMultiply:
                if (res.getText().toString().length() > 0) {
                    //op1 = Integer.parseInt(res.getText().toString());
                    op1 = Float.parseFloat(res.getText().toString());
                    operator = "*";
                    res.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Nothing to do", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.operatorPlusMinus:
                Log.i("see","see");
                if (res.getText().toString().length() > 0 && addClicked==0) {
                    //op1 = Integer.parseInt(res.getText().toString());
                    op1 = Float.parseFloat(res.getText().toString());
                    operator = "+";
                    res.setText("");
                    ++addClicked;
                }else{
                    operator = "-";
                    res.setText("");
                    addClicked=0;
                }
                break;

            case R.id.showResult:
                DecimalFormat format = new DecimalFormat();
                format.setDecimalSeparatorAlwaysShown(false);

                if(res.getText().toString().length()>0 ) {
                    //op2 = (int) Integer.parseInt(res.getText().toString());
                    op2 = Float.parseFloat(res.getText().toString());

                    int ans;
                    Log.i("tag", "op1 " + op1 + " op2:" + op2 + " sign:" + operator);
                    switch (operator) {
                        case "*":
                            res.setText( format.format(op1 * op2).toString() );
                            break;
                        case "+":
                            res.setText(format.format(op1 + op2).toString());
                            break;
                        case "-":
                            res.setText(format.format(op1 - op2).toString());
                            break;
                        case "/":
                            res.setText(format.format(op1 / op2).toString());
                            break;

                    }
                }
                break;
            case R.id.clear:
                res.setText("");
                op1 = op2 =addClicked=0 ;
                operator="";
                break;
        }

    }

}
