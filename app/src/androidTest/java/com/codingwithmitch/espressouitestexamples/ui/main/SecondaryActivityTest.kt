package com.codingwithmitch.espressouitestexamples.ui.main

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.R
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest{

    /**
     * ActivityScenarioRule:
     * https://developer.android.com/reference/androidx/test/ext/junit/rules/ActivityScenarioRule.html
     */
    @get:Rule
    val activityRule = ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun testActivity_inView() {

        onView(withId(R.id.secondary))
            .check(matches(isDisplayed()))

        // Notice this does not effect the next test
        activityRule.scenario.moveToState(Lifecycle.State.DESTROYED)
    }

    // Visibility
    @Test
    fun testVisibility_title_nextButton() {
        onView(withId(R.id.activity_secondary_title))
            .check(matches(isDisplayed()))

        onView(withId(R.id.button_back))
            .check(matches(isDisplayed()))
    }

    // Text
    @Test
    fun testTitleTextDisplayed() {
        onView(withId(R.id.activity_secondary_title))
            .check(matches(withText(R.string.text_secondaryactivity)))
    }

}















