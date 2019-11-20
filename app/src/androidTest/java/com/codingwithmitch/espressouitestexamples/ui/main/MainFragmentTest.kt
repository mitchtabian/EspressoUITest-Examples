package com.codingwithmitch.espressouitestexamples.ui.main

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.codingwithmitch.espressouitestexamples.R
import com.codingwithmitch.espressouitestexamples.data.SOME_DATA
import com.codingwithmitch.espressouitestexamples.util.EspressoIdlingResource
import com.codingwithmitch.espressouitestexamples.util.ViewModelUtil
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


@RunWith(AndroidJUnit4::class)
class MainFragmentTest{

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    /**
     * Idling resources tell Espresso that the app is idle or busy. This is needed when operations
     * are not scheduled in the main Looper (for example when executed on a different thread).
     */
    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    /**
     * Unregister your Idling Resource so it can be garbage collected and does not leak any memory.
     */
    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Before
    fun init(){

    }

    @Test
    fun testStart_and_getData() {
        // GIVEN - In MainFragment
        val viewModel = mock(MainViewModel::class.java)
        val scenario = launchFragmentInContainer<MainFragment>(
            null,
            R.style.AppTheme
        )
        scenario.onFragment { fragment ->
            fragment.viewModelFactory = ViewModelUtil.createFor(viewModel)
        }

        // WHEN
        val data = MutableLiveData<String>()
        `when`(viewModel.data).thenReturn(data)

        // THEN
        onView(withId(R.id.button_start))
            .check(matches(isDisplayed()))

        onView(withId(R.id.button_start)).perform(click())

        onView(withId(R.id.button_start))
            .check(matches(withEffectiveVisibility(Visibility.INVISIBLE)))

        onView(withId(R.id.display_text))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        data.postValue(SOME_DATA)

        onView(withId(R.id.display_text)).check(matches(withText(SOME_DATA)))

        onView(withId(R.id.button_next_fragment))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        onView(withId(R.id.button_next_activity))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}















