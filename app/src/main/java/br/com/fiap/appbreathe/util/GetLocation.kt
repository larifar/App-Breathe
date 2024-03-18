package br.com.fiap.appbreathe.util

import android.content.Context
import android.location.Location
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.fiap.appbreathe.service.LocationService
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun getLocation(context: Context, callback: (List<Double>) -> Unit) {
    val locationService = LocationService(context)
    locationService.getLastLocation(object : LocationService.LocationCallback {
        override fun onLocationReceived(location: Location) {
            val list = mutableListOf<Double>()
            list.add(location.latitude)
            list.add(location.longitude)
            callback(list)
        }

        override fun onLocationError(exception: Exception) {
            // Trate o erro de obtenção de localização aqui
            Log.e("meuAPP", "Erro ao obter a localização: ${exception.message}")
            callback(emptyList()) // Chama o callback com uma lista vazia em caso de erro
        }
    })
}




