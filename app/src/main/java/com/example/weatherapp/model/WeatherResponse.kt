package com.example.weatherapp.model

data class WeatherResponse(
    val daily: List<Daily>,
    val current: Current,
    val hourly: List<Hourly>,
    val lat: Double,
    val lon: Double,
    val minutely: List<Minutely>,
    val timezone: String,
    val timezone_offset: Int
)