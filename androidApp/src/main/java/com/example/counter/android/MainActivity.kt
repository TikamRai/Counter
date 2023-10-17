package com.example.counter.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountView()
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        CountView()
    }
}

@Composable
fun CountView() {
    val displayText = remember {mutableStateOf("0")}
    Column() {
        Row(modifier = Modifier.padding(10.dp).height(50.dp)) {
            CountDisplay(displayText)
        }
        Row(modifier = Modifier.padding(10.dp).height(50.dp)) {
            Column() {
                IncButton(displayText)
            }
            Column() {
                DecButton(displayText)
            }
        }
    }
}

@Composable
fun CountDisplay(display: MutableState<String>) {
    Text(text =  display.value,
        modifier = Modifier
            .height(50.dp)
            .padding(10.dp)
            .fillMaxWidth())
}

@Composable
fun IncButton(display: MutableState<String>) {
    ElevatedButton(onClick = {display.value = (display.value.toInt() + 1).toString()},
        modifier = Modifier.width(100.dp).padding(4.dp)) {
        Text(text = "Up")
    }
}

@Composable
fun DecButton(display: MutableState<String>) {
    ElevatedButton(onClick = {if (display.value.toInt() > 0) {
        display.value = (display.value.toInt() - 1).toString()
        }
    }, modifier = Modifier.width(100.dp).padding(4.dp)) {
        Text(text = "Down")
    }
}