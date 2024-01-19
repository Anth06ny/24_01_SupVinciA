package com.amonteiro.a01_supvincia.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.amonteiro.a01_supvincia.model.MainViewModel
import com.amonteiro.a01_supvincia.ui.Routes
import com.amonteiro.a01_supvincia.ui.components.ErrorView
import com.amonteiro.a01_supvincia.ui.theme._01_SupVinciATheme

//Code affiché dans la Preview
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MexicanScreenPreview() {
    _01_SupVinciATheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            MexicanFoodScreen()
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun MexicanScreenPreviewDark() {
    _01_SupVinciATheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            MexicanFoodScreen()
        }
    }
}

//Composable représentant l'ensemble de l'écran
@Composable
fun MexicanFoodScreen(navController: NavHostController? = null, viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    LaunchedEffect("") {
        viewModel.loadMexicanData()
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {


        if(viewModel.runInProgress.value) {
            CircularProgressIndicator()
        }


        if(viewModel.errorMessage.value.isNotBlank()) {
            ErrorView(message = viewModel.errorMessage.value)
        }

        Spacer(Modifier.size(8.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(viewModel.myList.size) {

                PictureRowItem(data = viewModel.myList[it], onPictureClick = {
                    navController?.navigate(Routes.MexicanFoodDetailScreen.addParam(it))
                } )
            }
        }
    }
}