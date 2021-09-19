package com.mahmoudbashir.simpleweatherappd.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudbashir.simpleweatherappd.model.WeatherModel
import com.mahmoudbashir.simpleweatherappd.repositories.WeatherRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class weatherViewModel
@Inject constructor(private val repository: WeatherRepositories):ViewModel(){

    private val TAG = "weatherViewModel"
    
    private val _respo = MutableLiveData<WeatherModel>()
    val weatherResp:LiveData<WeatherModel>
    get() = _respo

    init {
        getWeather()
    }

    private fun getWeather()= viewModelScope.launch {
        repository.getWeather().let {
            if (it.isSuccessful){
                _respo.postValue(it.body())
                
            }else{
                Log.d(TAG, "getWeather: Error ${it.message()}")
            }
        }
    }
}