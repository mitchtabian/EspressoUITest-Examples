package com.codingwithmitch.espressouitestexamples.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.codingwithmitch.espressouitestexamples.data.source.MoviesDataSource
import com.codingwithmitch.espressouitestexamples.data.source.MoviesRemoteDataSource
import com.codingwithmitch.espressouitestexamples.testing.OpenForTesting
import com.codingwithmitch.espressouitestexamples.ui.ErrorFragment
import com.codingwithmitch.espressouitestexamples.ui.movie.DirectorsFragment
import com.codingwithmitch.espressouitestexamples.ui.movie.MovieDetailFragment
import com.codingwithmitch.espressouitestexamples.ui.movie.StarActorsFragment

@OpenForTesting
class MovieFragmentFactory(
    val requestManager: RequestManager,
    val moviesRemoteDataSource: MoviesRemoteDataSource
) : FragmentFactory(){

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        val fragmentClass = loadFragmentClass(classLoader, className)
        var fragment: Fragment? = null
        var errorDescription: String? = null

        when(fragmentClass){

            MovieDetailFragment::class.java -> {
                fragment = MovieDetailFragment(
                    requestManager,
                    moviesRemoteDataSource
                )
            }

            DirectorsFragment::class.java -> {
                fragment = DirectorsFragment()
            }

            StarActorsFragment::class.java -> {
                fragment = StarActorsFragment()
            }

            else -> errorDescription = "Something went wrong."
        }

        fragment?.let{ nonNullFragment ->
            return nonNullFragment
        }
        fragment = ErrorFragment(errorDescription)

        return fragment
    }



}













