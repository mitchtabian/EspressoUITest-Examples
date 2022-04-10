package com.codingwithmitch.espressouitestexamples.ui.movie

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.R
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MovieNavigationTest {
    @Test
    fun test_MovieFragmentNavigation() {
        //setUp
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //navigate to directors fragment
        onView(withId(R.id.movie_directiors)).perform(click())

        //verify
        onView(withId(R.id.fragment_movie_directors_parent)).check(matches(isDisplayed()))

        pressBack()

        //verify
        onView(withId(R.id.fragment_movie_details_parent)).check(matches(isDisplayed()))

        //navigate to movie starts fragment
        onView(withId(R.id.movie_directiors)).perform(click())

        //verify
        onView(withId(R.id.fragment_movie_starts_parent)).check(matches(isDisplayed()))
    }
}