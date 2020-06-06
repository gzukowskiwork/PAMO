package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    private EditText weight, height;
    private TextView resultText;
    private Button calculate;
    private Button mBtLaunchActivity;
    public String Bmi;
    private Button mBtGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        mBtLaunchActivity =  findViewById(R.id.button_change_page);

        weight=findViewById(R.id.Weight);
        height = findViewById(R.id.Height);
        resultText = findViewById(R.id.Result);
        calculate=findViewById(R.id.button);
        mBtGoBack = findViewById(R.id.goBackBtn1);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBmi();
            }
        });

        mBtLaunchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity();
            }
        });

        mBtGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void calculateBmi(){
        String heightString = height.getText().toString();
        String weightString = weight.getText().toString();

        if(!heightString.isEmpty() && !weightString.isEmpty()){
            float heightValue= Float.parseFloat(heightString)/100;
            float weightValue = Float.parseFloat(weightString);

            float bmi = weightValue/(heightValue*heightValue);

            displayBmi(bmi);
            Bmi = displayBmi(bmi);
        }
    }

    private String displayBmi(float value){
        String bmiLabel= "";

        if(Float.compare(value, 15f)<=0)
            bmiLabel=getString(R.string.starved);
        else if(Float.compare(value, 15f)>0&&  Float.compare(value, 16f) <= 0)
            bmiLabel=getString(R.string.emaciation);
        else if(Float.compare(value, 16f)>0&&  Float.compare(value, 18.5f) <= 0)
            bmiLabel=getString(R.string.underweight);
        else if(Float.compare(value, 18.5f)>0&&  Float.compare(value, 25f) <= 0)
            bmiLabel=getString(R.string.optimal);
        else if(Float.compare(value, 25f)>0&&  Float.compare(value, 30f) <= 0)
            bmiLabel=getString(R.string.overweight);
        else if(Float.compare(value, 30f)>0&&  Float.compare(value, 35f) <= 0)
            bmiLabel=getString(R.string.obesity_level_I);
        else if(Float.compare(value, 35f)>0&&  Float.compare(value, 40f) <= 0)
            bmiLabel=getString(R.string.obesity_level_II);
        else if(Float.compare(value, 40f)>0)
            bmiLabel=getString(R.string.obesity_level_III);

        bmiLabel=value+"\n"+bmiLabel;
        resultText.setText(bmiLabel);
        return bmiLabel;
    }

    private void  launchActivity(){

        Intent intent = new Intent(this, WhatCanIEat.class);
        if(Bmi == null || Bmi.isEmpty()){
            resultText.setText(R.string.bmi_val_null);
        }else {
            intent.putExtra("DietOptions",Bmi);
            startActivity(intent);
        }
    }
}
