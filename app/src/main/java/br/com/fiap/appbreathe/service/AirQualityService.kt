package br.com.fiap.appbreathe.service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface AirQualityService {
    @POST("currentConditions:lookup")
    fun getCurrentConditions(
        @Body body: RequestPostBody,
        @Query(value = "key") key: String
    ):  Call<AirQualityResponse>
}