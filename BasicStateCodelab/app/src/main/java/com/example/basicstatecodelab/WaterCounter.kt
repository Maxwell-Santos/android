package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun StateFullCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, onIncrement = { count++ }, modifier)
}

@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("Você já bebeu ${count} copos de água")
        }

        Button(onClick = onIncrement, Modifier.padding(16.dp), enabled = count < 10) {
        Text(
            text = "Adicionar um copo"
        )
    }

    }
    
}