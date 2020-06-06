package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class WhatCanIEat extends AppCompatActivity {

    private Button mBtGoBack;
    private TextView text;
    private String bmi;
    private ImageView imageView;
    private List<String> skladniki;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_can_i_eat);

        Intent incomingIntent = getIntent();

        mBtGoBack = findViewById(R.id.goBackBtn);

        text = findViewById(R.id.HowManyKcal);
        imageView= findViewById(R.id.obraz);
        bmi= incomingIntent.getStringExtra("DietOptions");
        bmi = bmi.substring(0,4);
        //text.setText(bmi);

        displayDiet(bmi);
        mBtGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void populateList(){
        skladniki.add(0,"kurczak");
        skladniki.add(1,"Woda");
        skladniki.add(2,"Warzywa");
        skladniki.add(3, "Mieso mielone");
        skladniki.add(4, "Bułka");
        skladniki.add(5, "Sos majonezowy");
    }

    private void displayDiet(String data){

        Recepie recepie1 = new Recepie(skladniki,"Burger", "Do bułki dodaj kotleta z miesa mielonego i posiekane warzywa oraz sos majonezowy");
        Recepie recepie2 = new Recepie(skladniki,"Dietetycznie", "Warzywa z kurczakiem ugotuj na parze przez 20 minut");
        Recepie recepie3 = new Recepie(skladniki,"Warzywa", "Jedz tylko warzywa");


        float bmi = Float.valueOf(data);
        if(bmi <=15.5){
            text.setText(recepie1.Title+"\n"+recepie1.HowTo);
            imageView.setImageResource(R.drawable.food1);
        }
        else if(bmi>15.5 && bmi<=25){
            text.setText(recepie2.Title+"\n"+recepie2.HowTo);
            imageView.setImageResource(R.drawable.zbilansow);
        }
        else{
            text.setText(recepie3.Title+"\n"+recepie3.HowTo);
            imageView.setImageResource(R.drawable.download);
        }
    }
}
