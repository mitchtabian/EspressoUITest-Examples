package com.codingwithmitch.espressouitestexamples.factory

import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.espressouitestexamples.data.source.MoviesDataSource
import com.codingwithmitch.espressouitestexamples.testing.OpenForTesting
import com.codingwithmitch.espressouitestexamples.ui.movie.DirectorsFragment
import com.codingwithmitch.espressouitestexamples.ui.movie.MovieDetailFragment
import com.codingwithmitch.espressouitestexamples.ui.movie.MovieListFragment
import com.codingwithmitch.espressouitestexamples.ui.movie.StarActorsFragment

@OpenForTesting
class MovieFragmentFactory(
    private val requestOptions: RequestOptions? = null,
    private val moviesDataSource: MoviesDataSource? = null
) : FragmentFactory(){

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            MovieListFragment::class.java.name -> {
                if (moviesDataSource != null) {
                    MovieListFragment(moviesDataSource)
                } else {
                    super.instantiate(classLoader, className)
                }
            }

            MovieDetailFragment::class.java.name -> {
                if(requestOptions != null
                    && moviesDataSource != null){
                    MovieDetailFragment(
                        requestOptions,
                        moviesDataSource
                    )
                }
                else{
                    super.instantiate(classLoader, className)
                }
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }


//    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
//
//        val fragmentClass = loadFragmentClass(classLoader, className)
//        var fragment: Fragment? = null
//        var errorDescription: String? = null
//
//        when(className){
//
//            MovieListFragment::class.java.name -> {
//                if(moviesDataSource != null){
//                    Log.d(TAG, "FragmentFactory, MovieListFragment: ")
//                    fragment = MovieListFragment(moviesDataSource)
//                }
//            }
//
//            MovieDetailFragment::class.java.name -> {
//                if(requestOptions != null
//                    && moviesDataSource != null){
//                    Log.d(TAG, "FragmentFactory, MovieDetailFragment: ")
//                    fragment = MovieDetailFragment(
//                        requestOptions,
//                        moviesDataSource
//                    )
//                }
//            }
//
//            DirectorsFragment::class.java.name -> {
//                fragment = DirectorsFragment()
//            }
//
//            StarActorsFragment::class.java.name -> {
//                fragment = StarActorsFragment()
//            }
//
//            else -> {
//                errorDescription = "Something went wrong."
//                Log.d(TAG, "FragmentFactory: $errorDescription")
//            }
//        }
//
//        if(fragment == null)
//            fragment = ErrorFragment(errorDescription)
//        return fragment
//    }

}













