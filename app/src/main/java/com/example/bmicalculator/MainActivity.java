package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.bmicalculator.chart.CovidChartActivity;

public class MainActivity extends AppCompatActivity {

    private Button calculateHarrisBenedict;
    private Button calcBmiButton;
    private Button covidQuizButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calcBmiButton =  findViewById(R.id.calcBmiButton);
        calculateHarrisBenedict= findViewById(R.id.howManyKcalButton);
        Button covidChartButton = findViewById(R.id.covidChartButton);
        Button covidQuizButton = findViewById(R.id.covidQuizButton);

        calcBmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivityCalculateBmi();
            }
        });

        calculateHarrisBenedict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivityHowManyCalories();
            }
        });

        covidChartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivityCovidChart();
            }
        });

        covidQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivityCovidQuiz();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void launchActivityCalculateBmi(){
        Intent intent = new Intent(this, BmiActivity.class);
        startActivity(intent);
    }
    private void launchActivityHowManyCalories(){
        Intent intent = new Intent(this, HowManyCalories.class);
        startActivity(intent);
    }

    private void  launchActivityCovidChart(){
        Intent intent = new Intent(this, CovidChartActivity.class);
        startActivity(intent);
    }

    private void launchActivityCovidQuiz(){
        Intent intent= new Intent(this, QuizMainActivity.class);
        startActivity(intent);
    }
}
