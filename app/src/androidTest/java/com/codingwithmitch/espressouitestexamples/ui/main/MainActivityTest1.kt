package com.codingwithmitch.espressouitestexamples.ui.main

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.R
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest1(){
    @get : Rule
     val activityRule=ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_navsecondaryActivity() {
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))

        activityRule.scenario.moveToState(Lifecycle.State.DESTROYED)

    }

    @Test
    fun test_backpresstoMainactivity() {
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
        //onView(withId(R.id.button_back)).perform(click())
        pressBack()
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
}