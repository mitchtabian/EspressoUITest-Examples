package com.codingwithmitch.espressouitestexamples.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingwithmitch.espressouitestexamples.R
import kotlinx.android.synthetic.main.activity_secondary.*

class SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        button_back.setOnClickListener {
            onBackPressed()
        }
    }
}
