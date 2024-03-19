package br.com.fiap.appbreathe.service

import retrofit2.http.GET
import retrofit2.http.Query

interface MapsService {
    @GET("/reverse")
    suspend fun getLocationCity(
        @Query("format") format: String = "json",
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("accept-language") lang: String = "pt-BR"
    ): LocationCity
}