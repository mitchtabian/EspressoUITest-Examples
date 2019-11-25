package com.codingwithmitch.espressouitestexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

    private val TAG: String = "AppDebug"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_launch_dialog.setOnClickListener {
            showDialog()
        }

    }

    private fun showDialog(){
        MaterialDialog(this)
            .show {
                title(R.string.text_title_of_dialog)
                message(R.string.text_some_information)
                positiveButton(R.string.text_ok)
            }
    }

}















