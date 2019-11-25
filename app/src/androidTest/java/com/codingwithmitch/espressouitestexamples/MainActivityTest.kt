package com.codingwithmitch.espressouitestexamples

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{


    @Test
    fun test_showDialog_confirmVisible() {

        // GIVEN
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Execute and Verify
        onView(withId(R.id.button_launch_dialog)).perform(click())

        onView(withText(R.string.text_title_of_dialog)).check(matches(isDisplayed()))

        onView(withText(R.string.text_ok)).perform(click())

        // 'doesNotExist' must be used here b/c material dialog isn't on view hierarchy
        onView(withText(R.string.text_title_of_dialog)).check(doesNotExist())
    }
}












