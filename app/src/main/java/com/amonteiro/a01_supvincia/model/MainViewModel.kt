package com.amonteiro.a01_supvincia.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var searchText = mutableStateOf("")
    val myList = mutableStateListOf<PictureData>()

    fun uploadSearchText(newText : String){
        searchText.value = newText
    }

    fun getFilterListBySearchText() = myList.filter { it.text.contains(searchText.value) }

    fun loadData() {//Simulation de chargement de donnée
        myList.clear()

        viewModelScope.launch(Dispatchers.Default) {
            delay(5000) //simule temps de la requête
            myList.addAll(pictureList)

        }
    }
}