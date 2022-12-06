package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bmicalculator.databinding.ActivityBmiactivityBinding
import java.lang.Math.abs
import kotlin.math.pow

class BMIActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculate.setOnClickListener {
            binding.apply {
                if (etName.text.isEmpty() || etWeight.text.isEmpty() || etHeight.text.isEmpty()){
                    Toast.makeText(this@BMIActivity, "همه موراد باید پر شوند", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val name = etName.text.toString().trim()
                val weight = etWeight.text.toString().trim().toDouble()
                val heightCm = etHeight.text.toString().trim().toDouble()
                val heightM = heightCm/100
                var bmi = weight / (heightM.pow(2))
                val healthyWeight =  24 * (heightM.pow(2))
                val weightDifference = (kotlin.math.abs(weight - healthyWeight)).toInt()

                if (radioWoman.isChecked)
                    bmi -=1
                if ( bmi < 16.5)
                    tvResults.text = name + "عزیز شما" + weightDifference + "کیلو گرم کمبود وزن خیلی شدید دارید."
                else if (bmi >= 16.5 && bmi<18.4)
                    tvResults.text = name + "عزیز شما" + weightDifference + "کیلو گرم کمبود وزن دارید."
                else if( bmi >=18.4 && bmi < 25)
                    tvResults.text = name + "عزیز شما وزن و قدتان با هم متناسب است"
                else if (bmi >= 25 && bmi<30)
                    tvResults.text = name + "عزیز شما" + weightDifference + "کیلو گرم اضافه وزن دارید."
                else if ( bmi >=30 && bmi <35)
                    tvResults.text = name + "عزیز شما دچار چاقی درجه 1 هستید و حدود"+ weightDifference +
                            "کیلو گرم اضافه وزن دارید."
                else if ( bmi >= 35 && bmi<40)
                    tvResults.text = name + "عزیز شما دچار چاقی درجه 2 هستید و حدود"+ weightDifference +
                            "کیلو گرم اضافه وزن دارید."
                else if (bmi >= 40)
                    tvResults.text = name + "عزیز شما دچار چاقی درجه 3 هستید و حدود"+ weightDifference +
                            "کیلو گرم اضافه وزن دارید."


            }
        }
    }
}