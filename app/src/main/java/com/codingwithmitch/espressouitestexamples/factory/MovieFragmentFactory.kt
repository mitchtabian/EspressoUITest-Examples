package com.codingwithmitch.espressouitestexamples.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.espressouitestexamples.data.source.MoviesDataSource
import com.codingwithmitch.espressouitestexamples.testing.OpenForTesting
import com.codingwithmitch.espressouitestexamples.ui.ErrorFragment
import com.codingwithmitch.espressouitestexamples.ui.movie.DirectorsFragment
import com.codingwithmitch.espressouitestexamples.ui.movie.MovieDetailFragment
import com.codingwithmitch.espressouitestexamples.ui.movie.MovieListFragment
import com.codingwithmitch.espressouitestexamples.ui.movie.StarActorsFragment

@OpenForTesting
class MovieFragmentFactory(
    private val requestOptions: RequestOptions? = null,
    private val moviesDataSource: MoviesDataSource? = null
) : FragmentFactory(){

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        val fragmentClass = loadFragmentClass(classLoader, className)
        var fragment: Fragment? = null
        var errorDescription: String? = null

        when(fragmentClass){

            MovieListFragment::class.java -> {
                fragment = MovieListFragment()
            }

            MovieDetailFragment::class.java -> {
                if(requestOptions != null
                    && moviesDataSource != null){
                    fragment = MovieDetailFragment(
                        requestOptions,
                        moviesDataSource
                    )
                }
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













