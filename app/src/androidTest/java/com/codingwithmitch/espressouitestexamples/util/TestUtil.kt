package com.codingwithmitch.espressouitestexamples.util

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import org.hamcrest.Matcher


object TestUtil {

    fun setViewVisibility(value: Boolean): ViewAction {

        return object: ViewAction{
            override fun getDescription(): String {
                return "Show / Hide View"
            }

            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(View::class.java)
            }

            override fun perform(uiController: UiController?, view: View?) {
                view?.let{
                    it.visibility = if (value) View.VISIBLE else View.GONE
                }
            }

        }
    }
}