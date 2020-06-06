package com.example.bmikotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calc_bmi.*
import kotlinx.android.synthetic.main.activity_main.*

class CalcBmi : AppCompatActivity() {
    var bmi:Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_bmi)
        bmiResultView.visibility= View.INVISIBLE

        calculateBmiButton.setOnClickListener{
            takeParamsForBmi()
        }

        startDietRecomendation()
    }

    fun startDietRecomendation(){
        dietRecomendationButton.setOnClickListener {
            val intent = Intent(this, DietRecomendation::class.java)
            if(bmi!= 0.0) {
                intent.putExtra("BMI", bmi.toString())
                startActivity(intent)
            }
            else{
                bmiResultView.visibility = View.VISIBLE
                bmiResultView.text=getString(R.string.calculate_bmi_before)
            }
        }
    }

    fun takeParamsForBmi(){
        var weight : String= weightText.text.toString()
        var height : String= heightText.text.toString()

        if(weight.isNotEmpty() && height.isNotEmpty())
        {

            var weightD:Double = weight.toDouble()
            var heightD: Double= height.toDouble()

            bmi = (weightD/(heightD*heightD))*10000
            showBmi(bmi)

        }
        else {
            bmiResultView.visibility = View.VISIBLE
            bmiResultView.text = getString(R.string.enter_values)
        }

    }

    fun showBmi(bodyMassIndex:Double){
        bmiResultView.visibility= View.VISIBLE
        if(bodyMassIndex<=18.49) {
            bmiResultView.text = getString(R.string.bmi_value_underweight, String.format("%.2f", bodyMassIndex))
        }
        else if (bodyMassIndex>=18.50 && bodyMassIndex < 25){
            bmiResultView.text= getString(R.string.bmi_value_ok_weight, String.format("%.2f", bodyMassIndex))
        }
        else{
            bmiResultView.text= getString(R.string.bmi_value_overweight, String.format("%.2f", bodyMassIndex))}
    }
}

