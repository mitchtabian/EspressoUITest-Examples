package com.codingwithmitch.espressouitestexamples.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView

interface ImageLoader {

    fun loadBitmap(
        bitmap: Bitmap,
        imageView: ImageView
    )

    fun loadDrawable(
        drawable: Drawable,
        imageView: ImageView
    )

    fun loadImageUrl(
        url: String,
        imageView: ImageView
    )

}

















