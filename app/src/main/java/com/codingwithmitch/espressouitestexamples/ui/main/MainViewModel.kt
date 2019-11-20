package com.codingwithmitch.espressouitestexamples.ui.main

import androidx.lifecycle.*
import com.codingwithmitch.espressouitestexamples.data.DataSource
import com.codingwithmitch.espressouitestexamples.testing.OpenForTesting
import kotlinx.coroutines.launch

@OpenForTesting
class MainViewModel
constructor(
    val dataSource: DataSource
): ViewModel(){

    private val _data: MutableLiveData<String> = MutableLiveData()
    val data: LiveData<String>
        get() = _data


    fun retrieveData(){
        viewModelScope.launch {
            val dataResult = dataSource.getData()
            _data.value = dataResult
        }
    }

    fun reset(){
        _data.value = null
    }
}