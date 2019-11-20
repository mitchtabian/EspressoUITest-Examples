package com.codingwithmitch.espressouitestexamples.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.codingwithmitch.espressouitestexamples.R
import com.codingwithmitch.espressouitestexamples.data.DataSource
import com.codingwithmitch.espressouitestexamples.factory.MainViewModelFactory
import com.codingwithmitch.espressouitestexamples.testing.OpenForTesting
import com.codingwithmitch.espressouitestexamples.util.EspressoIdlingResource
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OpenForTesting
class MainFragment : Fragment(){

    private val TAG: String = "AppDebug"
    
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelFactory = MainViewModelFactory(DataSource())
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        subscribeObservers()

        button_start.setOnClickListener {
            startEvent()
        }

        button_next_fragment.setOnClickListener {
            viewModel.reset()
            findNavController().navigate(R.id.action_mainFragment_to_secondaryFragment)
        }

        button_next_activity.setOnClickListener {

        }
    }

    override fun onResume() {
        super.onResume()
        setInitialConditions()
    }

    fun subscribeObservers(){
        viewModel.data.observe(viewLifecycleOwner, Observer { data ->
            data?.let{
                Log.d(TAG, data)
                GlobalScope.launch(Main){
                    display_text.text = it
                    EspressoIdlingResource.increment()
                    delay(500)
                    EspressoIdlingResource.decrement()
                    showNextButtons()
                }
            }
        })
    }

    fun showNextButtons(){
        button_next_fragment.visibility = View.VISIBLE
        button_next_activity.visibility = View.VISIBLE
    }

    fun startEvent(){
        button_start.visibility = View.INVISIBLE
        display_text.visibility = View.VISIBLE
        viewModel.retrieveData()
    }

    fun setInitialConditions(){
        button_next_fragment.visibility = View.INVISIBLE
        button_next_activity.visibility = View.INVISIBLE
        display_text.text = ""
        display_text.visibility = View.INVISIBLE
    }
}


















