package br.com.fiap.appbreathe.service

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double
)

data class RequestPostBody(
    @SerializedName("location") val location: Location,
    @SerializedName("universalAqi") val universalAqi: Boolean,
    @SerializedName("extraComputations") val extraComputations: List<String>,
    @SerializedName("languageCode") val languageCode: String
)
