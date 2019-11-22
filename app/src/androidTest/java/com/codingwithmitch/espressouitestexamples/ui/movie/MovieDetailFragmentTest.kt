package com.codingwithmitch.espressouitestexamples.ui.movie

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.bumptech.glide.RequestManager
import com.codingwithmitch.espressouitestexamples.R
import com.codingwithmitch.espressouitestexamples.data.Movie
import com.codingwithmitch.espressouitestexamples.data.source.MoviesRemoteDataSource
import com.codingwithmitch.espressouitestexamples.factory.MovieFragmentFactory
import com.codingwithmitch.espressouitestexamples.ui.ErrorFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*


@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest{

    private lateinit var context: Context

    @Before
    fun init(){
        context = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun testDetailFragment_isMovieDataVisible() {

        // SETUP
        val movieId = 1
        val title = "The Rundown"
        val description = "A tough aspiring chef is hired to bring home a mobster's son from the Amazon but " +
                "becomes involved in the fight against an oppressive town operator and the search " +
                "for a legendary treasure."
        val movie = Movie(
            movieId,
            title,
            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/The_Rundown-the_rundown.png",
            description ,
            arrayListOf("R.J. Stewart", "James Vanderbilt"),
            arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
        )
        val moviesRemoteDataSource = mock(MoviesRemoteDataSource::class.java)
        `when`(moviesRemoteDataSource.getMovie(movieId)).thenReturn(movie)
        val requestManager = mock(RequestManager::class.java)

        val fragmentFactory = TestMovieFragmentFactory(requestManager, moviesRemoteDataSource)
        val bundle = Bundle()
        bundle.putInt("movie_id", movieId)
        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        // VERIFY
        onView(withId(R.id.movie_title)).check(matches(withText(title)))

        onView(withId(R.id.movie_description)).check(matches(withText(description)))
    }


    class TestMovieFragmentFactory(
        requestManager: RequestManager,
        moviesRemoteDataSource: MoviesRemoteDataSource
    ) : MovieFragmentFactory(requestManager, moviesRemoteDataSource) {

        override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
            val fragmentClass = loadFragmentClass(classLoader, className)
            var fragment: Fragment? = null
            var errorDescription: String? = null

            when(fragmentClass){

                MovieDetailFragment::class.java -> {
                    fragment = TestMovieDetailFragment(
                        requestManager,
                        moviesRemoteDataSource
                    )
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

    class TestMovieDetailFragment(
        requestManager: RequestManager,
        moviesRemoteDataSource: MoviesRemoteDataSource
        ) : MovieDetailFragment(
        requestManager,
        moviesRemoteDataSource
    ) {

        override fun setMovieImage() {
            // do nothing
        }
    }

}



















