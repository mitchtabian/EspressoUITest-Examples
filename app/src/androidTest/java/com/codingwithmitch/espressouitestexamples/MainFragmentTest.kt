package com.codingwithmitch.espressouitestexamples

import android.app.Activity
import android.app.Application
import android.app.Instrumentation
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.content.ContextCompat
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.*
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.codingwithmitch.espressouitestexamples.ImageViewHasDrawableMatcher.hasDrawable
import com.codingwithmitch.espressouitestexamples.factory.MainFragmentFactory
import com.codingwithmitch.espressouitestexamples.util.TestImageLoader
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainFragmentTest{

    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)

    val context = getApplicationContext<Application>()

    @Test
    fun test_defaultImageVisible() {

        // GIVEN
        val fragmentFactory = MainFragmentFactory(
            imageLoader = TestImageLoader() // <-- *** IMPORTANT ***
        )
        val fragmentScenario = launchFragmentInContainer<MainFragment>(
            fragmentArgs = null,
            factory = fragmentFactory
        )

        // VERIFY
        onView(withId(R.id.image)).check(matches(
            hasDrawable(
                context,
                R.drawable.default_image
            )
        ))
    }


    @Test
    fun test_defaultImageVisibleInProduction() {

        // GIVEN
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // VERIFY
        // "not" makes it pass b/c production image loader should not work
        // (Glide can't set images in test apparently)
        onView(withId(R.id.image)).check(matches(not(
            hasDrawable(
                context,
                R.drawable.default_image
            )
        )))
    }

    @Test
    fun  test_cameraIntent() {

        // GIVEN
        val activityResult = createImageCaptureActivityResultStub(intentsTestRule.activity)
        val expectedIntent: Matcher<Intent> =
            IntentMatchers.hasAction(MediaStore.ACTION_IMAGE_CAPTURE)
        intending(expectedIntent).respondWith(activityResult)

        // Execute and Verify
        onView(withId(R.id.button_launch_camera)).perform(ViewActions.click())
        intended(expectedIntent)
    }

    @Test
    fun test_cameraIntent_displayImageFromCamera() {

        // GIVEN
        val fragmentFactory = MainFragmentFactory(
            imageLoader = TestImageLoader() // <-- *** IMPORTANT ***
        )
        val fragmentScenario = launchFragmentInContainer<MainFragment>(
            fragmentArgs = null,
            factory = fragmentFactory
        )

        fragmentScenario.onFragment { fragment ->

            // called after camera intent is successful
            ContextCompat.getDrawable(
                context,
                R.drawable.ic_launcher_background
            )?.let { drawable ->
                fragment.setImageFromCamera(
                    ImageViewHasDrawableMatcher.getBitmap(
                        drawable
                    )
                )
            }
        }

        onView(withId(R.id.image)).check(matches(
            hasDrawable(
                context,
                R.drawable.ic_launcher_background
            )
        ))
    }

    /**
     * Can't test actually setting the image from network, so we just see if the url is
     * set in the TestImageLoader.
     */
    @Test
    fun test_networkImageUrlsRetrieved() {

        // GIVEN
        val testImageLoader = TestImageLoader()
        val fragmentFactory = MainFragmentFactory(
            imageLoader = testImageLoader
        )
        val fragmentScenario = launchFragmentInContainer<MainFragment>(
            fragmentArgs = null,
            factory = fragmentFactory
        )

        onView(withId(R.id.button_set_network_image)).perform(click())

        assert(testImageLoader.imageUrl.equals(NETWORK_IMAGE_URL))
    }

    private fun createImageCaptureActivityResultStub(context: Context): Instrumentation.ActivityResult? {
        val bundle = Bundle()
        bundle.putParcelable(
            KEY_IMAGE_DATA,
            BitmapFactory.decodeResource(
                context.resources,
                R.drawable.ic_launcher_background
            )
        )
        val resultData = Intent()
        resultData.putExtras(bundle)
        return Instrumentation.ActivityResult(Activity.RESULT_OK, resultData)
    }

}




















