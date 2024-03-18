package br.com.fiap.appbreathe.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LocationViewModel : ViewModel() {
    var locationList by mutableStateOf(emptyList<Double>())
        private set

    fun updateLocationList(list: List<Double>) {
        locationList = list
    }
}
