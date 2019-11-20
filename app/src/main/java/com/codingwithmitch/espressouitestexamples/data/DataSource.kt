package com.codingwithmitch.espressouitestexamples.data

import com.codingwithmitch.espressouitestexamples.testing.OpenForTesting
import com.codingwithmitch.espressouitestexamples.util.EspressoIdlingResource
import kotlinx.coroutines.delay

const val FAKE_NETWORK_DELAY = 500L
const val SOME_DATA = "This is some data."

@OpenForTesting
class DataSource
{

    suspend fun getData(): String{
        EspressoIdlingResource.increment() // Set app as busy.
        delay(FAKE_NETWORK_DELAY)
        EspressoIdlingResource.decrement() // Set app as idle.
        return SOME_DATA
    }

}













