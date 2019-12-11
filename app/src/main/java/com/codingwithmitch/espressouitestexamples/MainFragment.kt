package com.codingwithmitch.espressouitestexamples


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.codingwithmitch.espressouitestexamples.util.ImageLoader
import kotlinx.android.synthetic.main.fragment_main.*

const val REQUEST_IMAGE_CAPTURE = 1234
const val KEY_IMAGE_DATA = "data"

class MainFragment
constructor(
    val imageLoader: ImageLoader
): Fragment() {

    private val TAG: String = "AppDebug"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_launch_camera.setOnClickListener {
            dispatchCameraIntent()
        }

        setDefaultImage()
    }

    private fun setDefaultImage(){
        context?.run{
            ContextCompat.getDrawable(this, R.drawable.default_image)?.let{ drawable ->
                imageLoader.loadDrawable(
                    drawable,
                    image
                )
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            Log.d(TAG, "RESULT_OK")
            when(requestCode){

                REQUEST_IMAGE_CAPTURE -> {
                    Log.d(TAG, "REQUEST_IMAGE_CAPTURE detected.")
                    data?.extras.let{ extras ->
                        if (extras == null || !extras.containsKey(KEY_IMAGE_DATA)) {
                            return
                        }

                        (extras[KEY_IMAGE_DATA] as Bitmap?)?.let { bm ->
                            setImageFromCamera(bm)
                        }
                    }
                }
            }
        }
    }

    fun setImageFromCamera(bitmap: Bitmap){
        imageLoader.loadBitmap(
            bitmap,
            image
        )
    }

    private fun dispatchCameraIntent() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }
}












