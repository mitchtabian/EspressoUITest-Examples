package com.codingwithmitch.espressouitestexamples.ui.main

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.R
import junit.framework.TestCase
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest1 (){
    //Verify the main Activity display
    @Test
    fun test_lunchMainActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun TestVisibility_Title_NextButton() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_main_title))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))//method2
        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
    }

    @Test
    fun Test_Text_Visibility() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(withText("MainActivity")))

    }
}