package com.codingwithmitch.espressouitestexamples.ui.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.espressouitestexamples.R
import com.codingwithmitch.espressouitestexamples.data.source.MoviesDataSource
import com.codingwithmitch.espressouitestexamples.data.source.MoviesRemoteDataSource
import com.codingwithmitch.espressouitestexamples.factory.MovieFragmentFactory

class MainActivity : AppCompatActivity() {

    // dependencies (typically would be injected with dagger)
    lateinit var requestManager: RequestManager
    lateinit var movieRemoteDataSource: MoviesRemoteDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory = MovieFragmentFactory(
            requestManager,
            movieRemoteDataSource
            )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        val bundle = Bundle()
        bundle.putInt("movie_id", 1)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MovieDetailFragment::class.java, bundle)
            .commit()
    }

    private fun initDependencies(){

        // glide
        val requestOptions = RequestOptions
            .placeholderOf(R.drawable.default_image)
            .error(R.drawable.default_image)
        requestManager = Glide.with(application)
            .setDefaultRequestOptions(requestOptions)

        // Data Source
        movieRemoteDataSource = MoviesRemoteDataSource()
    }

}







