package com.codingwithmitch.espressouitestexamples.factory

import androidx.fragment.app.FragmentFactory
import com.codingwithmitch.espressouitestexamples.util.ImageLoader
import com.codingwithmitch.espressouitestexamples.MainFragment

class MainFragmentFactory(
    val imageLoader: ImageLoader
) : FragmentFactory(){

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            MainFragment::class.java.name -> {
                MainFragment(imageLoader)
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }
}














