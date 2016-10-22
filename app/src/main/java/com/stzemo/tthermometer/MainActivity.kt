package com.stzemo.tthermometer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.stzemo.tthermometer.custom.views.LineTemperatureView

class MainActivity : AppCompatActivity() {

    var finishP: Int = 900;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnUp: Button = findViewById(R.id.btnPressUp) as Button
        val btnDown: Button = findViewById(R.id.btnPressDown) as Button
        val view: LineTemperatureView = findViewById(R.id.temperatureView) as LineTemperatureView
        view.drawToPosition(finishP)
        btnUp.setOnClickListener {
            finishP -= 20
            view.drawToPosition(finishP)
        }
        btnDown.setOnClickListener {
            finishP += 20
            view.drawToPosition(finishP)
        }

    }
}


