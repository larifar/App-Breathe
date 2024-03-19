package br.com.fiap.appbreathe.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.appbreathe.R
import br.com.fiap.appbreathe.components.CardAirQuality
import br.com.fiap.appbreathe.components.CardSaude
import br.com.fiap.appbreathe.components.Navbar
import br.com.fiap.appbreathe.components.Poluente
import br.com.fiap.appbreathe.model.PoluenteModel
import br.com.fiap.appbreathe.model.SaudeModel
import br.com.fiap.appbreathe.service.LocationCity
import br.com.fiap.appbreathe.util.formatCityToString
import br.com.fiap.appbreathe.util.getCity
import kotlinx.coroutines.runBlocking

@Composable
fun Home(locationList: List<Double>) {
    val primaryColor = colorResource(id = R.color.sky_blue)
    var clicked = remember {
        mutableStateOf(true)
    }
    val loc: LocationCity

    runBlocking {
        loc = getCity(locationList.first(), locationList[1])
    }

    Column (modifier = Modifier
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .height(height = 210.dp)
                .background(color = primaryColor)
                .fillMaxWidth()
        ) {
            Text(
                text = formatCityToString(loc),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Qualidade do ar:",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }
        CardAirQuality(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .offset(y = (-76).dp),
            iqaNumber = "60",
            textQuality = "Moderada",
            barNumber = 10.0
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .offset(y = (-50).dp)
        ) {
            Navbar(poluentes = clicked.value) { state ->
                clicked.value = state
            }
            val poluente = PoluenteModel(
                index = 1,
                name = "PM25",
                composition = "30 μg/m3"
            )
            val saude = SaudeModel(
                categoria = "Geral",
                texto = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
            )

            val listaPoluentes = listOf(poluente, poluente, poluente)
            val listaSaude = listOf(saude, saude, saude)
            LazyColumn() {
                    if (clicked.value) {
                        items(listaPoluentes) { poluente ->
                            Poluente(poluente = poluente)
                        }
                    } else {
                        items(listaSaude) { saude ->
                            CardSaude(model = saude)
                        }
                    }
                

            }
        }
    }
}