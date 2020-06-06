package com.example.bmikotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_diet_recomendation.*

class DietRecomendation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_recomendation)

        val bmi = intent.getStringExtra("BMI")

        displayDiet(bmi)
    }

    fun displayDiet(data:String){
        if(data.isNotEmpty()) {
            val bmi: Double = data.toDouble()

            if (bmi <= 15.5) {
                yourDiet.text = getString(R.string.bmi_diet_low)
                imageDiet.setImageResource(R.drawable.food1)
            } else if (bmi > 15.5 && bmi <= 25) {
                yourDiet.text = getString(R.string.bmi_diet_medium)
                imageDiet.setImageResource(R.drawable.zbilansow)
            } else {
                yourDiet.text = getString(R.string.bmi_diet_high)
                imageDiet.setImageResource(R.drawable.download)
            }
        }
        else{
            yourDiet.text = getString(R.string.smothing_went_wrong)
        }

    }

}
