package com.example.myweather


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.myweather.ui.theme.MyWeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyWeatherTheme {
                Image(
                    painter = painterResource(R.drawable.fog),
                    contentDescription = "Image"
                )
            }
        }
    }
}