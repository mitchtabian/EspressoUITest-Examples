package com.codingwithmitch.espressouitestexamples.util

import androidx.test.espresso.IdlingRegistry
import com.codingwithmitch.espressouitestingexamples.util.EspressoIdlingResource
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * Option 1
 * This option is much more difficult to read and is more verbose.
 */
//class EspressoIdlingResourceRule: TestRule{
//
//    override fun apply(base: Statement?, description: Description?)
//            = IdlingResourceStatement(base)
//
//    class IdlingResourceStatement(private val base: Statement?) : Statement() {
//
//        private val idlingResource = EspressoIdlingResource.countingIdlingResource
//
//        @Throws(Throwable::class)
//        override fun evaluate() {
//            // Add something you do before test
//            IdlingRegistry.getInstance().register(idlingResource)
//            try {
//                base?.evaluate()
//                    ?: throw Exception("Error evaluating test. Base statement is null.")
//
//            } finally {
//                // Add something you do after test
//                IdlingRegistry.getInstance().unregister(idlingResource)
//            }
//        }
//    }
//
//}


/**
 * Option 2
 * Simplified version of option #1. (TestWatcher class implements TestRule)
 */
class EspressoIdlingResourceRule: TestWatcher() {

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























