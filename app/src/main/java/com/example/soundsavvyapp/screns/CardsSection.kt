package com.example.soundsavvyapp.screns

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soundsavvyapp.R
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

@Preview
@Composable
fun CardsSection() {
    LazyRow {
        items(music.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val card = music[index]
    var lastItemPaddingEnd = 0.dp
    if (index == music.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_test)

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(80.dp)
                .height(80.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = image,
                contentDescription = card.musicName,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.musicName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )


        }
    }
}