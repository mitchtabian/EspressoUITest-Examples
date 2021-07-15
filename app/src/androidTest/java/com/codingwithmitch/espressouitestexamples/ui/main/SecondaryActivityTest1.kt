package com.codingwithmitch.espressouitestexamples.ui.main

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.R
import kotlinx.android.synthetic.main.activity_secondary.view.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest1(){

    @get: Rule
    val activityRule= ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun testVisbility_Secondary() {
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))

        activityRule.scenario.moveToState(Lifecycle.State.DESTROYED)
    }

    //visibility
    @Test
    fun check_visibility_Title_backbutton() {
        onView(withId(R.id.activity_secondary_title)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_secondary_title)).check(matches(withText("SecondaryActivity")))
        onView(withId(R.id.button_back)).check(matches(isDisplayed()))

    }
}