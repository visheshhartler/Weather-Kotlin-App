package com.hartleylab.weatherkotlinapp.domain.commands

import com.hartleylab.weatherkotlinapp.data.ForecastRequest
import com.hartleylab.weatherkotlinapp.domain.mappers.ForecastDataMapper
import com.hartleylab.weatherkotlinapp.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String): Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}