package br.com.fiap.appbreathe.util

import android.util.Log
import br.com.fiap.appbreathe.service.AirQualityResponse
import br.com.fiap.appbreathe.service.Location
import br.com.fiap.appbreathe.service.RequestPostBody
import br.com.fiap.appbreathe.service.RetrofitFactoryAir
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun apiConnection() {

    val requestPostBody = RequestPostBody(
        location = Location(37.4220936, -122.083922),
        universalAqi = true,
        extraComputations = listOf(
            "HEALTH_RECOMMENDATIONS",
            "DOMINANT_POLLUTANT_CONCENTRATION",
            "POLLUTANT_ADDITIONAL_INFO"
        ),
        languageCode = "pt-br"
    )

    val key = "AIzaSyCbwH9qhu8aJ9ngzBv22HKxrkvkz378778"
    val service =RetrofitFactoryAir().getAirService()
    val call = service.getCurrentConditions(requestPostBody, key)

    call.enqueue(object : Callback<AirQualityResponse> {
        override fun onResponse(
            call: Call<AirQualityResponse>,
            response: Response<AirQualityResponse>
        ) {
            if (response.isSuccessful) {
                val airQualityResponse = response.body()
                Log.i("sucess", "$response.body()")
            } else {
                Log.i("erro da resposta", "AAAAAA")
            }
        }

        override fun onFailure(call: Call<AirQualityResponse>, t: Throwable) {
            Log.i("erro do erro", "Deu tudo errado")
            Log.i("erro do erro", "${t.message}")
        }

    })
}