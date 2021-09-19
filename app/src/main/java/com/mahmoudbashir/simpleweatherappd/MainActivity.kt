package com.mahmoudbashir.simpleweatherappd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.mahmoudbashir.simpleweatherappd.databinding.ActivityMainBinding
import com.mahmoudbashir.simpleweatherappd.viewModel.weatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMainBinding
    private val viewModel:weatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getWeather()
    }

    private fun getWeather() {
        viewModel.weatherResp.observe(this,{weather ->
            if (weather != null){
                Toast.makeText(this,"temperature : ${weather.temperature}",Toast.LENGTH_LONG).show()
                Log.d("responseD :","temperature : ${weather.temperature}")

                binding.apply {
                    tvCityName.text = "Cairo"
                    tvDescription.text = weather.description
                    tvTemperature.text = weather.temperature
                    tvWind.text = weather.wind

                    val forecast = weather.forecast
                    tvForecast1.text = "${forecast[0].temperature}/ ${forecast[0].wind}"
                    tvForecast2.text = "${forecast[1].temperature}/ ${forecast[1].wind}"
                    tvForecast3.text = "${forecast[2].temperature}/ ${forecast[2].wind}"
                }
            }
        })
    }
}