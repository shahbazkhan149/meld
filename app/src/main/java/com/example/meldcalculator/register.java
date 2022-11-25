package com.example.meldcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText bilirubin,inr,sodium,creatinine;
    TextView result,res1;
    Button calcu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bilirubin=findViewById(R.id.bilirubin);
        inr=findViewById(R.id.inr);
        sodium=findViewById(R.id.sodium);
        creatinine=findViewById(R.id.creatinine);
        result=findViewById(R.id.result);
        res1=findViewById(R.id.res1);
        calcu=findViewById(R.id.calc);
        calcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(register.this, "Button works", Toast.LENGTH_SHORT).show();
                Double bili = Double.parseDouble(bilirubin.getText().toString());
                Double Inr = Double.parseDouble(inr.getText().toString());
                Double sod = Double.parseDouble(sodium.getText().toString());
                Double crea = Double.parseDouble(creatinine.getText().toString());
                double meldi= ((0.378 * Math.log(bili)) + (1.120*Math.log(Inr)) + (0.957*Math.log(crea)) + 0.643 ) * 10;
                //Toast.makeText(register.this, "MELD  "+meldi, Toast.LENGTH_SHORT).show();
                double m=Math.round(meldi);
                String res = new Double(m).toString();
                res1.setText("Meld(i): "+String.valueOf(res));
                double meld= (m + 1.32 * (137-sod) - (0.033*m*(137-sod)));
                 String finalresult = new Double(meld).toString();
                 result.setText("Meld: " +String.valueOf(finalresult));
            }
            });

    }
}