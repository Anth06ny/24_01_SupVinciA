package com.amonteiro.a01_supvincia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.amonteiro.a01_supvincia.ui.screen.SearchScreen
import com.amonteiro.a01_supvincia.ui.theme._01_SupVinciATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _01_SupVinciATheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SearchScreen()
                    //TestShareRemember()
                }
            }
        }
    }
}

@Composable
fun TestShareRemember() {
    val expanded = remember { mutableStateOf(false) }

    Column {
        ElevatedButton(
            onClick = { expanded.value = !expanded.value }
        ) {
            Text(if (expanded.value) "Show less" else "Show more")
        }

        ElevatedButton(
            onClick = { expanded.value = !expanded.value },
        ) {
            Text(if (expanded.value) "Show less" else "Show more")
        }
        MyButton(expanded)
        MyButton()
    }
}
//Permet d'écouter l'état en dehors de la méthode
@Composable
fun MyButton(expanded: MutableState<Boolean> = remember { mutableStateOf(false) }) {

    ElevatedButton(
        onClick = { expanded.value = !expanded.value },
    ) {
        Text(if (expanded.value) "Show less" else "Show more")
    }
}
