package com.codingwithmitch.espressouitestexamples.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codingwithmitch.espressouitestexamples.R
import kotlinx.android.synthetic.main.fragment_error.*

class ErrorFragment
constructor(
    val errorDescription: String? = null
) : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_error, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        errorDescription?.let{description ->
            fragment_error_description.text = description
        }
    }
}











