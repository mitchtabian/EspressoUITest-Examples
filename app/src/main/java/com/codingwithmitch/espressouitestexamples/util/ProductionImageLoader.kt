package com.codingwithmitch.espressouitestexamples.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions

class ProductionImageLoader(
    context: Context,
    requestOptions: RequestOptions
) : ImageLoader {

    private val requestManager: RequestManager = Glide.with(context)
        .applyDefaultRequestOptions(requestOptions)

    override fun loadBitmap(bitmap: Bitmap, imageView: ImageView) {
        requestManager
            .load(bitmap)
            .into(imageView)
    }

    override fun loadDrawable(drawable: Drawable, imageView: ImageView) {
        requestManager
            .load(drawable)
            .into(imageView)
    }


}













