package br.com.fiap.appbreathe.pages

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.appbreathe.R
import br.com.fiap.appbreathe.model.LocationViewModel
import br.com.fiap.appbreathe.util.getLocation

@Composable
fun Cover(
    navController: NavController,
    context: Context,
    locationViewModel: LocationViewModel
) {
    val primaryColor = colorResource(id = R.color.sky_blue)

    Column(
        modifier = Modifier
            .background(color = primaryColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.size(width = 320.dp, height = 450.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)

        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_breathe),
                    contentDescription = "Logo breathe",
                    modifier = Modifier.size(350.dp)
                )
                Button(
                    onClick = {
                        Log.i("meuAPP", "Clicou no botão")
                        getLocation(context) {
                            Log.i("meuAPP", it.toString())
                            locationViewModel.updateLocationList(it)

                            if (it.isNotEmpty()) {
                                navController.navigate("home")
                            }
                        }

                    },
                    colors = ButtonDefaults
                        .buttonColors(containerColor = primaryColor),
                    elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 1.dp),
                    modifier = Modifier.size(width = 250.dp, height = 40.dp)
                ) {
                    Text(
                        text = "Ativar localização",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.align(alignment = Alignment.CenterVertically),
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
    }
}