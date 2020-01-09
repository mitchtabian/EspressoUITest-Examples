package com.codingwithmitch.espressouitestexamples.util

import androidx.test.espresso.IdlingRegistry
import com.codingwithmitch.espressouitestingexamples.util.EspressoIdlingResource
import org.junit.rules.TestWatcher
import org.junit.runner.Description


class EspressoIdlingResourceRule : TestWatcher(){


    private val idlingResource = EspressoIdlingResource.countingIdlingResource

    override fun finished(description: Description?) {
        IdlingRegistry.getInstance().unregister(idlingResource)
        super.finished(description)
    }

    override fun starting(description: Description?) {
        IdlingRegistry.getInstance().register(idlingResource)
        super.starting(description)
    }
}



