package com.codingwithmitch.espressouitestexamples.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView

class TestImageLoader :
    ImageLoader {

    override fun loadBitmap(bitmap: Bitmap, imageView: ImageView) {
        imageView.setImageBitmap(bitmap)
    }

    override fun loadDrawable(drawable: Drawable, imageView: ImageView) {
        imageView.setImageDrawable(drawable)
    }

}