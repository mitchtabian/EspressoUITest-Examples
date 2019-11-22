package com.codingwithmitch.espressouitestexamples.ui.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingwithmitch.espressouitestexamples.R
import com.codingwithmitch.espressouitestexamples.factory.MovieFragmentFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = MovieFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MovieDetailFragment::class.java, null)
            .commit()
    }

}







