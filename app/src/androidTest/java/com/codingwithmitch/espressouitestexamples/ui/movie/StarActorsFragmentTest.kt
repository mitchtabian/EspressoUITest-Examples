package com.codingwithmitch.espressouitestexamples.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.R
import com.codingwithmitch.espressouitestexamples.factory.MovieFragmentFactory
import org.junit.Test

import org.junit.runner.RunWith
import java.lang.StringBuilder

@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest{
    @Test
    fun test_isDirectorsListVisible() {
        //SETUP
        val startActors = arrayListOf(
            "Dwayne Johnson", "Seann William Scott",
            "Rosario Dawson", "Christopher Walken"
        )
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors", startActors)

        val scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle, factory = fragmentFactory
        )

        onView(withId(R.id.star_actors_text)).check(
            matches(
                withText(
                    StarActorsFragment.stringBuilderForStarActors(
                        startActors
                    )
                )
            )
        )
    }
}

