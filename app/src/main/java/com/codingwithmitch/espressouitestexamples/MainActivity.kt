package com.codingwithmitch.espressouitestexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.espressouitestexamples.factory.MainFragmentFactory
import com.codingwithmitch.espressouitestexamples.util.ProductionImageLoader


class MainActivity : AppCompatActivity(){

    private val TAG: String = "AppDebug"

    override fun onCreate(savedInstanceState: Bundle?) {
        initFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun initFragmentFactory(){
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.default_image)
            .error(R.drawable.default_image)
        supportFragmentManager.fragmentFactory = MainFragmentFactory(
            ProductionImageLoader(this, requestOptions)
        )
    }

    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment::class.java, null)
                .commit()
        }
    }



}




















