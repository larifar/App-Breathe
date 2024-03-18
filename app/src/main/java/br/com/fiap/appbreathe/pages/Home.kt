package br.com.fiap.appbreathe.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import br.com.fiap.appbreathe.R

@Composable
fun Home(locationList: List<Double>) {
    val primaryColor = colorResource(id = R.color.sky_blue)

    Column (modifier = Modifier.background(Color.Black)
        .fillMaxSize()){
        Text(text = "Latitude: ${locationList.first()} e Longitude: ${locationList[1]}",
            color = Color.White
        )
    }

}