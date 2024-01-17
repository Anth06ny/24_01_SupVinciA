package com.amonteiro.a01_supvincia.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.amonteiro.a01_supvincia.model.PictureData
import com.amonteiro.a01_supvincia.model.pictureList
import com.amonteiro.a01_supvincia.ui.theme._01_SupVinciATheme

//Code affiché dans la Preview
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SearchScreenPreview() {
    _01_SupVinciATheme {
        Surface(modifier = Modifier.fillMaxWidth(), color = Color.LightGray) {
            SearchScreen()
        }
    }
}

//Composable représentant l'ensemble de l'écran
@Composable
fun SearchScreen() {
    Column {
        PictureRowItem(data = pictureList[0])
    }
}

//Composable affichant 1 PictureData
@Composable
fun PictureRowItem(modifier: Modifier = Modifier, data: PictureData) {
    //TODO
    Text(
        text = "Hello World",
    )
}