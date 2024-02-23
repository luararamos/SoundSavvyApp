package com.example.soundsavvyapp.feature.presentation

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.soundsavvyapp.common.constants.SoundSavvyConstants.ERROR.UNKNOWN_ERROR
import com.example.soundsavvyapp.feature.presentation.navigation.MainScreen
import com.example.soundsavvyapp.feature.presentation.screens.home.HomeViewModel
import com.example.soundsavvyapp.feature.presentation.screens.home.components.AlertDialogError
import com.example.soundsavvyapp.ui.theme.SoundSavvyAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoundSavvyAppTheme {

                val viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
                MainScreen()
                observes()
                var isDisplayDialog by remember {
                    mutableStateOf(false)
                }
                viewModel.error.observe(this, Observer { throwable ->
                    isDisplayDialog = true
                })
                
                if (isDisplayDialog){
                    Dialog(onDismissRequest = {isDisplayDialog = false}) {
                        Column(
                            Modifier
                                .clip(RoundedCornerShape(15))
                                .size(400.dp)
                                .background(Color.White)
                                .padding(16.dp)
                        ) {
                            Text(text = UNKNOWN_ERROR)
                            Spacer(modifier = Modifier.size(16.dp))
                            Button(onClick = {  }) {
                                Text(text = "Concordar")
                                
                            }

                        }
                    }
                }
            }
        }
    }

    private fun observes() {


    }

    @Preview
    @Composable
    fun preview() {
        MainScreen()
    }
}
