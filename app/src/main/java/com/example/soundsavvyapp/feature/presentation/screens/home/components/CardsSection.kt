package com.example.soundsavvyapp.feature.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.soundsavvyapp.R
import com.example.soundsavvyapp.feature.data.remote.model.All
import com.example.soundsavvyapp.feature.presentation.screens.home.components.model.Music
import com.example.soundsavvyapp.ui.theme.BlueEnd
import com.example.soundsavvyapp.ui.theme.BlueStart
import com.example.soundsavvyapp.ui.theme.GreenEnd
import com.example.soundsavvyapp.ui.theme.GreenStart
import com.example.soundsavvyapp.ui.theme.OrangeEnd
import com.example.soundsavvyapp.ui.theme.OrangeStart
import com.example.soundsavvyapp.ui.theme.PurpleEnd
import com.example.soundsavvyapp.ui.theme.PurpleStart


val music = listOf(

    Music(
        musicType = "Eletrônica",
        musicName = "Daft Punk",
        color = getGradient(PurpleStart, PurpleEnd),
    ),

    Music(
        musicType = "Rock",
        musicName = "Elvis Presley",
        color = getGradient(BlueStart, BlueEnd),
    ),

    Music(
        musicType = "Eletrônica",
        musicName = "twenty one pilots",
        color = getGradient(OrangeStart, OrangeEnd),
    ),

    Music(
        musicType = "Pop",
        musicName = "Billie Eilish",
        color = getGradient(GreenStart, GreenEnd),
    ),

    Music(
        musicType = "Pop",
        musicName = "Michael Jackson",
        color = getGradient(GreenStart, GreenEnd),
    ),

    Music(
        musicType = "Pop",
        musicName = "Trips",
        color = getGradient(GreenStart, GreenEnd),
    )


)

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun CardItem(
    result: All
) {
    var lastItemPaddingEnd = 0.dp

    var image = painterResource(id = R.drawable.ic_test)

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = result.pic_medium),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(25.dp))

            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = result.name,
                color = Color.Black,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

        }

    }
}