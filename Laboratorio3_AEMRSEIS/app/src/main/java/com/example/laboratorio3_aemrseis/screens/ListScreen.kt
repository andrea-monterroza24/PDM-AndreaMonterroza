package com.example.laboratorio3_aemrseis.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ListaNombresApp(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    val listaNombres = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Regresar al Home")
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                if (nombre.isNotEmpty()) {
                    listaNombres.add(nombre)
                    nombre = ""
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Guardar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Listado de nombres y posición en la lista",
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    listaNombres.clear()
                }
            ) {
                Text("Limpiar")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(3.dp, Color.Blue)
                .padding(10.dp)
        ) {

            LazyColumn {

                itemsIndexed(listaNombres) { index, item ->

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(item)

                        Text("${index + 1}")
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

    }

}