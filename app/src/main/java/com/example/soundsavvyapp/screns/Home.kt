package com.example.soundsavvyapp.screns

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        SearchBar()
        Banner()
        Text(
            modifier = modifier.padding( horizontal = 24.dp),
            text = "Top Músicas",
            fontSize = 16.sp,
        )
        LazyRow(Modifier.padding(vertical = 16.dp)) {
            items(music.size) { index ->
                CardItem(index)
            }
        }
        Text(
            modifier = modifier.padding( horizontal = 24.dp),
            text = "Mais Vistas",
            fontSize = 16.sp,
        )
        DetailsContent()
    }


}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}