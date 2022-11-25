package com.example.meldcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bmi extends AppCompatActivity {
    EditText height,weight;
    TextView result;
    Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        height=findViewById(R.id.height);
        weight=findViewById(R.id.weight);
        result=findViewById(R.id.result);
        calc=findViewById(R.id.calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(bmi.this, "Button works", Toast.LENGTH_SHORT).show();
        Double h = Double.parseDouble(height.getText().toString());
        Double w = Double.parseDouble(weight.getText().toString());
        double ht= Math.pow(h,2);
        double bmi=w/ht;
        double r= Math.round(bmi);
                //Toast.makeText(bmi.this, "BMI  "+bmi, Toast.LENGTH_SHORT).show();
        String finalresult = new Double(r).toString();
        result.setText(String.valueOf(finalresult));
            }
        });




    }
}