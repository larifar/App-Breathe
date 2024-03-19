package br.com.fiap.appbreathe.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.appbreathe.R

@Composable
fun CardAirQuality(
    modifier: Modifier,
    iqaNumber: String,
    textQuality: String,
    barNumber: Double
) {
    Card(
        modifier = modifier
            .size(width = 320.dp, height = 120.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
        colors= CardDefaults.cardColors(containerColor = Color.White)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = textQuality,
                color = colorResource(id = R.color.black_lighter),
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 10.dp, bottom = 15.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.iqa_bar),
                contentDescription = "IQA bar"
            )
            Row{
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.offset(x = barNumber.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.arrow_simple),
                        contentDescription = "Arrow simple",
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = iqaNumber,
                        modifier = Modifier.offset(x = 1.dp, y = (-4).dp),
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}