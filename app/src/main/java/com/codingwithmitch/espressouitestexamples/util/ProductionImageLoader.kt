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
        loadImage(bitmap, imageView)
    }

    override fun loadDrawable(drawable: Drawable, imageView: ImageView) {
        loadImage(drawable, imageView)
    }

    override fun loadImageUrl(url: String, imageView: ImageView) {
        loadImage(url, imageView)
    }

    private fun loadImage(resource: Any, imageView: ImageView){
        requestManager
            .load(resource)
            .into(imageView)
    }
}













