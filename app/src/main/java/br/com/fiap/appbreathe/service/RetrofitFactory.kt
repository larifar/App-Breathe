package br.com.fiap.appbreathe.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "https://airquality.googleapis.com/v1/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAirService(): AirQualityService {
        return retrofitFactory.create(AirQualityService::class.java)
    }

}