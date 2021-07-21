package com.example.weatherapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.WeatherResponse
import com.example.weatherapp.network.ApiRepository

class HomeViewModel : ViewModel() {
    //MVVM Model View ViewModel
    //MVC - Model View Controller
    //MVP - Model View Presenter

    //View - интерфейс
    //ViewModel - логика приложения
    //Model - источник данных АПИ или БД

    private val repository = ApiRepository

    fun oneCall(lat: Double, lon: Double): LiveData<WeatherResponse> {
        return repository.oneCall(lat, lon)
    }
}