package br.com.fiap.appbreathe.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactoryMaps {
    private val BASE_URL = "https://nominatim.openstreetmap.org/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getMapsService(): MapsService{
        return retrofit.create(MapsService::class.java)
    }
}
