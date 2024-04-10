package com.example.soundsavvyapp.feature.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soundsavvyapp.R
import com.example.soundsavvyapp.feature.data.local.Favorite

@Composable
fun CardFavorite(favorite: Favorite) {
    androidx.compose.material.Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.Gray,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {

        Row(
            modifier = Modifier
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(20.dp),
                Arrangement.Center
            ) {
                Text(
                    text = favorite.music,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = "Artista :- " + favorite.art,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )

            }
            Image(
                painter = painterResource(id = R.drawable.ic_favorite_selected),
                contentDescription = null,
                modifier = Modifier.clickable {

                })
        }

    }
}