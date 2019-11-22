package com.codingwithmitch.espressouitestexamples.ui.movie

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.R
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class NavigationTest{


    @Test
    fun testMovieFragmentsNavigation() {

        // SETUP
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // NAV DirectorsFragment
        onView(withId(R.id.movie_directors)).perform(click())

        // VERIFY
        onView(withId(R.id.fragment_directors_parent))
            .check(matches(isDisplayed()))

        // NAV MovieDetailFragment
        pressBack()

        // VERIFY
        onView(withId(R.id.fragment_movie_detail_parent))
            .check(matches(isDisplayed()))

        // NAV StarActorsFragment
        onView(withId(R.id.movie_star_actors)).perform(click())

        // VERIFY
        onView(withId(R.id.fragment_star_actors_parent))
            .check(matches(isDisplayed()))

        // NAV MovieDetailFragment
        pressBack()

        // VERIFY
        onView(withId(R.id.fragment_movie_detail_parent))
            .check(matches(isDisplayed()))
    }

}











