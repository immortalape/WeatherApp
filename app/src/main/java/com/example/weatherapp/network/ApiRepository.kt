package com.example.weatherapp.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiRepository {

    private val api = Retrofit.api

    fun oneCall(
        lat: Double,
        lon: Double
    ): LiveData<WeatherResponse> {
        val liveData = MutableLiveData<WeatherResponse>()

        api.oneCall(lat, lon).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.isSuccessful) {
                    liveData.value = response.body()
                } else {
                    Log.e("error", "onResponse: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("error", "onFailure: ${t.localizedMessage}")
            }
        })

        return liveData
    }

}