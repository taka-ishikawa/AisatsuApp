package com.example.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
//                Log.d("hour", "$hour")
                when {
                    (2 <= hour) && (hour < 10) ->
                        textView.text = getString(R.string.key_greeting_morning)
                    (10 <= hour) && (hour < 18) ->
                        textView.text = getString(R.string.key_greeting_daytime)
                    ((18 <= hour) && (hour <= 24)) || ((0 <= hour) && (hour < 2)) ->
                        textView.text = getString(R.string.key_greeting_night)
                }
            },
            0,
            0,
            true
        )
        timePickerDialog.show()
    }
}