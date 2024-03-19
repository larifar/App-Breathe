package br.com.fiap.appbreathe.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.appbreathe.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navbar(poluentes: Boolean) {
    val silverColor = colorResource(id = R.color.silver_gray)
    val peachColor = colorResource(id = R.color.strong_peach)
    val lightGray = colorResource(id = R.color.light_gray)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(340.dp)
                .height(50.dp),
            shape = RoundedCornerShape(50),
            colors = CardDefaults.cardColors(containerColor = silverColor),
            border = BorderStroke(2.dp, color = silverColor)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(50))){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = if (poluentes) Color.White else silverColor),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Poluentes",
                            fontWeight = if (poluentes) FontWeight.Bold else FontWeight.Medium,
                            color = if (poluentes) peachColor else lightGray
                        )
                    }
                }

                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(50))){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = if (!poluentes) Color.White else silverColor),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Saúde",
                            fontWeight = if (!poluentes) FontWeight.Bold else FontWeight.Medium,
                            color = if (!poluentes) peachColor else lightGray
                        )
                    }
            }



            }

        }
    }
}