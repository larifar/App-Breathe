package br.com.fiap.appbreathe.service

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task

class LocationService(private val context: Context) {

    private val mFusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    interface LocationCallback {
        fun onLocationReceived(location: Location)
        fun onLocationError(exception: Exception)
    }

    fun getLastLocation(callback: LocationCallback) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            callback.onLocationError(SecurityException("Permission not granted"))
            return
        }
        mFusedLocationClient.lastLocation
            .addOnCompleteListener(object : OnCompleteListener<Location?> {
                override fun onComplete(task: Task<Location?>) {
                    if (task.isSuccessful && task.result != null) {
                        callback.onLocationReceived(task.result!!)
                    } else if(task.result == null) {
                        callback.onLocationError(NullPointerException("Location result is null"))
                    } else{
                        callback.onLocationError(task.exception!!)
                    }
                }
            })
    }
}
