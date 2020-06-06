package com.example.bmikotlin

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_how_many_calories.*

class HowManyCalories : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_many_calories)

        showWhat.setOnClickListener {
            showMinimalCalories()
        }
    }

    fun showMinimalCalories(){
        val heightString:String = heightHarrisBenedict.text.toString()
        val weightString: String = weightHarrisBenedict.text.toString()
        val ageString: String = ageHarrisBenedict.text.toString()

        if(heightString.isNotEmpty()&&weightString.isNotEmpty()&&ageString.isNotEmpty()){
            val radio: RadioButton= findViewById(radioSexGroup.checkedRadioButtonId)
            calculateMinimumCalories(radio.text.toString() ,heightString.toDouble(),
                                        weightString.toDouble(), ageString.toInt())
        }
        else{
            youCanEatText.text= getString(R.string.enter_values)
        }



    }

    fun calculateMinimumCalories(sex:String, height: Double, weight: Double, age: Int){
        if(sex.equals("mężczyzna")){
           val minimKcal: Double = 66.47 + 13.7 * weight + 5.0 * height - 6.76 * age
            youCanEatText.text= getString(R.string.you_can_eat, String.format("%.0f",minimKcal))
        }else{
            val minimKcal: Double = 655.1 + 9.567 * weight + 1.85 * height - 4.68 * age
            youCanEatText.text=  getString(R.string.you_can_eat, String.format("%.0f",minimKcal))
        }
    }
}
