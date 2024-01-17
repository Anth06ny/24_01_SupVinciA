package com.amonteiro.a01_supvincia.ui.myscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.amonteiro.a01_supvincia.model.PictureData
import com.amonteiro.a01_supvincia.model.pictureList

//Code affiché dans la Preview
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SearchScreenPreview() {
    NomVotreProjetTheme {
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