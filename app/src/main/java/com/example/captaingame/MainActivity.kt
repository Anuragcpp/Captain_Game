package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    captainGame()
                }
            }
        }
    }

    @Composable
    fun captainGame(){
        val traserFound = remember{ mutableStateOf(0) }
        val direction = remember{ mutableStateOf("north") }
        val treaserOrStrom = remember{ mutableStateOf("") }

        Column {
            Text(text = "Treaser found : ${traserFound.value}")
            Text(text = "Current Direction : ${direction.value}")
            Text(text = treaserOrStrom.value)
            Button(
                onClick = {
                    direction.value = "East"
                    if (Random.nextBoolean()){
                        traserFound.value +=1
                        treaserOrStrom.value ="Treaser found"
                    }else{
                        treaserOrStrom.value = "Strom ahead"
                    }
                }
            ) {
                    Text(text = "Sail East")          
            }
            Button(
                onClick = {
                    direction.value = "Wast"
                    if (Random.nextBoolean()){
                        traserFound.value +=1
                        treaserOrStrom.value = "Treaser found"
                    }else{
                        treaserOrStrom.value = "Strom found"
                    }
                }
            ) {
                Text(text = "Sail Wast")
            }
            Button(
                onClick = {
                    direction.value = "South"
                    if (Random.nextBoolean()){
                        traserFound.value +=1
                        treaserOrStrom.value = "Treaser Found"
                    }else{
                        treaserOrStrom.value = "Strom ahead"
                    }
                }
            ) {
                Text(text = "Sail South")
            }
            Button(
                onClick = {
                    direction.value = "North"
                    if (Random.nextBoolean()){
                        traserFound.value +=1
                        treaserOrStrom.value = "Treaser found"
                    }else{
                        treaserOrStrom.value = "Strom ahead"
                    }
                }
            ) {
                Text(text = "Sail North")
            }
        }
    }
}
