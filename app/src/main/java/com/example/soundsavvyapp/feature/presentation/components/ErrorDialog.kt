package com.example.soundsavvyapp.feature.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.soundsavvyapp.R
import com.example.soundsavvyapp.common.constants.SoundSavvyConstants

@Composable
fun ErrorDialog(
    showErrorDialog: Boolean,
    errorMessage: String,
    onDismiss: () -> Unit,
    onRetry: () -> Unit
) {
    if (showErrorDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .size(300.dp)
                    .background(Color.White)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_error),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = SoundSavvyConstants.ERROR.UNKNOWN_ERROR)
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = errorMessage)
                Spacer(modifier = Modifier.size(16.dp))
                Row {
                    Button(onClick = onDismiss) {
                        Text(text = "Cancelar")
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    Button(onClick = onRetry) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_sync),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}