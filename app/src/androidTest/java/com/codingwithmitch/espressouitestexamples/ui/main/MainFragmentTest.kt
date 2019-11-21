package com.codingwithmitch.espressouitestexamples.ui.main

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.R
import com.codingwithmitch.espressouitestexamples.data.SOME_DATA
import com.codingwithmitch.espressouitestexamples.util.EspressoIdlingResource
import com.codingwithmitch.espressouitestexamples.util.TestUtil
import com.codingwithmitch.espressouitestexamples.util.ViewModelUtil
import com.codingwithmitch.espressouitestexamples.util.mock
import org.junit.*

import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.mockito.Mockito.*


@RunWith(AndroidJUnit4ClassRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MainFragmentTest{

//    @get:Rule
//    val activityRule = ActivityScenarioRule(MainActivity::class.java)

//    private lateinit var scenario: FragmentScenario<MainFragment>
//    private lateinit var viewModel: MainViewModel

    @Before
    fun init(){

    }


    @Test
    fun test1_startFragment_and_getData() {
        // GIVEN
        val scenario = launchFragmentInContainer<MainFragment>(
            null,
            R.style.AppTheme
        )
        val viewModel = mock(MainViewModel::class.java)
        scenario.onFragment { fragment ->
            fragment.viewModelFactory = ViewModelUtil.createFor(viewModel)
        }

        // delegate WHEN and THEN
        testDataGetData(viewModel)
    }

    @Test
    fun test2_getData_navSecondaryFragmentWithNavController() {
        // GIVEN
        val navController = mock<NavController>()
        val viewModel = mock(MainViewModel::class.java)
        val scenario = launchFragmentInContainer<MainFragment>(
            null,
            R.style.AppTheme
        )
        scenario.onFragment { fragment ->
            fragment.view?.let { view ->
                Navigation.setViewNavController(view, navController)
            }
            fragment.viewModelFactory = ViewModelUtil.createFor(viewModel)
        }

        testDataGetData(viewModel)

        // Start SecondaryFragment screen.
        onView(withId(R.id.button_next_fragment)).perform(click())

        // Confirm SecondaryFragment is in view
//        onView(withId(R.id.secondary)).check(matches(isDisplayed()))

        verify(navController).navigate(R.id.action_mainFragment_to_secondaryFragment)
    }



    @Test
    fun test3_navSecondaryFragment_and_back() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        
        // Check that MainFragment is in view.
        onView(withId(R.id.main)).check(matches(isDisplayed()))

        // Check button_next_fragment is invisible
        onView(withId(R.id.button_next_fragment))
            .check(matches(withEffectiveVisibility(Visibility.INVISIBLE)))

        // Manually set button_next_fragment visible
        onView(withId(R.id.button_next_fragment)).perform(TestUtil.setViewVisibility(true))

        // Start SecondaryFragment screen.
        onView(withId(R.id.button_next_fragment)).perform(click())

        // Check that SecondaryFragment was started.
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))

        // go back
        pressBack()

        // Check that MainFragment is in view
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    private fun testDataGetData(viewModel: MainViewModel){
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
}















