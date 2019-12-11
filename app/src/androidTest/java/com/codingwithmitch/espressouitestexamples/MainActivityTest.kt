package com.codingwithmitch.espressouitestexamples

import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)


    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }



}













