package br.com.fiap.appbreathe.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.appbreathe.R
import br.com.fiap.appbreathe.components.CardAirQuality
import br.com.fiap.appbreathe.components.Navbar
import br.com.fiap.appbreathe.components.Poluente

@Composable
fun Home(locationList: List<Double>) {
    val primaryColor = colorResource(id = R.color.sky_blue)

    Column (modifier = Modifier
        .fillMaxSize()){
        Column (modifier = Modifier
            .height(height = 210.dp)
            .background(color = primaryColor)
            .fillMaxWidth()){
            Text(text = "Latitude: ${locationList.first()} e Longitude: ${locationList[1]}",
                color = Color.White)
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "Qualidade do ar:",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }
        CardAirQuality(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .offset(y = (-76).dp),
            iqaNumber = "60",
            textQuality = "Moderada",
            barNumber = 10.0)

        Column (modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .offset(y = (-50).dp)){
            Navbar(true)
            Poluente(index= 1, name ="PM25", composition = "30 μg/m3")
        }
    }

}