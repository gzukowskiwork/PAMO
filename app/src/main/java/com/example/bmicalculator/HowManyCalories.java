package com.example.bmicalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class HowManyCalories extends AppCompatActivity {

    private Button mBtGoBack;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;
    private String sex;
    private TextView weight, height, age, youCanEat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_many_calories);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBtGoBack = findViewById(R.id.goBackBtn2);
        weight = findViewById(R.id.weightHarrisBenedict);
        height= findViewById(R.id.heightHarrisBenedict);
        age = findViewById(R.id.ageHarrisBenedict);
        youCanEat = findViewById(R.id.youCanEatText);
        radioSexGroup = findViewById(R.id.radioSexGroup);
        btnDisplay= findViewById(R.id.showWhat);


        addListenerOnButtons();
    }

    public void addListenerOnButtons(){

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMinimalCalories();
            }
        });

        mBtGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void  ShowMinimalCalories(){
        String heightString = height.getText().toString();
        String weightString = weight.getText().toString();
        String ageString = age.getText().toString();

        int selectedId= radioSexGroup.getCheckedRadioButtonId();
        radioSexButton = findViewById(selectedId);
        sex = radioSexButton.getText().toString();

        if(!heightString.isEmpty() && !weightString.isEmpty() && !ageString.isEmpty()){
            float heightValue= Float.parseFloat(heightString);
            float weightValue = Float.parseFloat(weightString);
            int ageValue= Integer.parseInt(ageString);

            CalculateMinimumCalories(sex, heightValue, weightValue, ageValue);
        }
    }

    private void CalculateMinimumCalories(String sex, float height, float weight, int age){
        double minimKcal;
        if(sex.equals("Mężczyzna")){
            minimKcal= 66.47+13.7*weight+5.0*height-6.76*age;
        }else{
            minimKcal= 655.1+9.567*weight+1.85*height-4.68*age;
        }

        youCanEat.setText(String.valueOf(Math.round(minimKcal)));
    }


}
