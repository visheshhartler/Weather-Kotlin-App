package com.hartleylab.weatherkotlinapp.domain.model

data class ForecastList(val city: String, val country: String, val dailyForecast: List<ModelForecast>) {
    val size: Int get() = dailyForecast.size

    operator fun get(position: Int) = dailyForecast[position]

}
data class ModelForecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)