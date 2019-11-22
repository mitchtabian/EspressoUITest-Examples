package com.codingwithmitch.espressouitestexamples.ui.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.espressouitestexamples.R
import com.codingwithmitch.espressouitestexamples.factory.MovieFragmentFactory

class MainActivity : AppCompatActivity() {

    // dependency (typically would be injected with dagger)
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        initGlideInstance()
        supportFragmentManager.fragmentFactory = MovieFragmentFactory(requestManager)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MovieDetailFragment::class.java, null)
            .commit()
    }

    private fun initGlideInstance(){
        val requestOptions = RequestOptions
            .placeholderOf(R.drawable.default_image)
            .error(R.drawable.default_image)
        requestManager = Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

}







