package br.com.fiap.appbreathe.util

import android.util.Log
import br.com.fiap.appbreathe.service.LocationCity
import br.com.fiap.appbreathe.service.RetrofitFactoryMaps

suspend fun getCity(lat: Double, lon: Double): LocationCity {
    val service = RetrofitFactoryMaps().getMapsService()
    val response = service.getLocationCity(
        format = "json", lat =lat, lon = lon
    )
    Log.i("response", "$response")

    return response
}

fun formatCityToString(loc: LocationCity): String{
    val city = loc.address.city
    val state = loc.address.state
    val country = loc.address.country
    return "$city, $state - $country"
}