package br.com.fiap.appbreathe.service

import com.google.gson.annotations.SerializedName

data class AirQualityResponse(
    @SerializedName("dateTime") val dateTime: String,
    @SerializedName("indexes") val indexes: List<AirQualityIndex>,
    @SerializedName("pollutants") val pollutants: List<Pollutant>,
    @SerializedName("healthRecommendations") val healthRecommendations: HealthRecommendations
)

data class AirQualityIndex(
    @SerializedName("aqi") val aqi: Int,
    @SerializedName("aqiDisplay") val aqiDisplay: String,
    @SerializedName("category") val category: String,
    @SerializedName("dominantPollutant") val dominantPollutant: String
)

data class Pollutant(
    @SerializedName("displayName") val displayName: String,
    @SerializedName("concentration") val concentration: Concentration
)

data class Concentration(
    @SerializedName("value") val value: Float,
    @SerializedName("units") val units: String
)

data class HealthRecommendations(
    @SerializedName("generalPopulation") val generalPopulation: String,
    @SerializedName("elderly") val elderly: String,
    @SerializedName("lungDiseasePopulation") val lungDiseasePopulation: String,
    @SerializedName("heartDiseasePopulation") val heartDiseasePopulation: String,
    @SerializedName("athletes") val athletes: String,
    @SerializedName("pregnantWomen") val pregnantWomen: String,
    @SerializedName("children") val children: String
)