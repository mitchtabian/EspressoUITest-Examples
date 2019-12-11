package com.codingwithmitch.espressouitestexamples

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description


object ImageViewHasDrawableMatcher {


    /**
     * Example:
     * Custom matcher for a particular drawable
     */
    fun hasDrawable(
        context: Context,
        @DrawableRes drawableResId: Int
    ): BoundedMatcher<View, ImageView>{

        return object: BoundedMatcher<View, ImageView>(ImageView::class.java){

            override fun describeTo(description: Description?) {
                description?.appendText("matches with expected bitmap")
            }

            override fun matchesSafely(item: ImageView?): Boolean {

                item?.let { itemView ->

                    ContextCompat.getDrawable(context, drawableResId)?.let{ expectedDrawable ->
                        val expectedBitmap = getBitmap(
                            expectedDrawable
                        )
                        val actualBitmap = getBitmap(itemView.drawable)
                        return actualBitmap.sameAs(expectedBitmap)
                    }
                }
                return false
            }
        }
    }

    fun getBitmap(drawable: Drawable): Bitmap {
        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }
}