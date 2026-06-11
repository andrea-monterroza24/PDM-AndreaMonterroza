package com.example.laboratorio5_aemrseis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.laboratorio5_aemrseis.navigation.NavManager
import com.example.laboratorio5_aemrseis.ui.theme.Laboratorio5_AEMRSEISTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Laboratorio5_AEMRSEISTheme {

                NavManager()

            }
        }
    }
}