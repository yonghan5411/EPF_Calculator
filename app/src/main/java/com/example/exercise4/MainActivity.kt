package com.example.exercise4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var calendar:Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener{

            val newFragment = DatePickerFragment()
            newFragment.show(fragmentManager, "Date Picker")

        }

        Calculate.setOnClickListener{
            val age = editText.text.toString().toInt()
            val basicSaving = getSaving(age) * 30 / 100;

            editText2.text = "The Saving : RM " + getSaving(age)
            textView4 .text = "The Result: RM " + basicSaving;

        }
    }

    fun getSaving(age:Int) : Double{
        when(age){
            in 16..20 -> return 5000.00
            in 20..25 -> return 14000.00
            in 26..30 -> return 29000.00
            in 31..35 -> return 50000.00
            else -> return 0.00
        }
    }
}
