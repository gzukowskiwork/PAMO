package com.example.bmikotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBmiCalvulator()

        startHowManyCalories()

        startCovidChart()
    }

    fun startBmiCalvulator(){
        navButtonBmiCalc.setOnClickListener {
            val intent = Intent(this, CalcBmi::class.java)
            startActivity(intent)
        }
    }

    fun startHowManyCalories(){
        navButtonHowManyClaories.setOnClickListener {
            val intent = Intent(this, HowManyCalories::class.java)
            startActivity(intent)
        }
    }

    fun startCovidChart(){
        navButtonCovidChart.setOnClickListener {
            val intent = Intent(this, CovidChartActivit::class.java)
            startActivity(intent)
        }
    }

}
