package com.example.soundsavvyapp.view.screns

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val employees = remember { Details.MusicDetailsLists }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            SearchBar()
        }
        item {
            Banner()
        }
        item {
            Text(
                modifier = modifier.padding( horizontal = 24.dp),
                text = "Top Músicas",
                fontSize = 16.sp,
            )
        }
        item {
            LazyRow(Modifier.padding(vertical = 16.dp)) {
                items(music.size) { index ->
                    CardItem(index)
                }
            }
        }
        item {
            Text(
                modifier = modifier.padding( horizontal = 24.dp),
                text = "Mais Vistas",
                fontSize = 16.sp,
            )
        }

        items(
            employees
        ) {
            EmployeeCard(emp = it)
        }

    }


}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}