package br.com.fiap.appbreathe.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
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
import br.com.fiap.appbreathe.model.SaudeModel

@Composable
fun CardSaude(model: SaudeModel) {
    val lightBlack = colorResource(id = R.color.black_lighter)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(horizontal = 50.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column (modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center){
            Text(
                text = "População ${model.categoria}:",
                color = lightBlack,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Text(
                text = model.texto,
                color = lightBlack,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }
    }
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        thickness = 1.dp,
        color = colorResource(id = R.color.light_gray)
    )

}