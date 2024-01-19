package com.amonteiro.a01_supvincia.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var searchText = mutableStateOf("")
    val myList = mutableStateListOf<PictureData>()
    var errorMessage = mutableStateOf("")
    var runInProgress = mutableStateOf(false)

    fun uploadSearchText(newText: String) {
        searchText.value = newText
    }

    fun getFilterListBySearchText() = myList.filter { it.text.contains(searchText.value) }

    fun loadData() {//Simulation de chargement de donnée
        myList.clear()

        errorMessage.value =""
        runInProgress.value = true

        viewModelScope.launch(Dispatchers.Default) {
            try {
                val listCity: List<WeatherBean> = WeatherAPI.loadWeatherAround(searchText.value)

                if(listCity.isEmpty()){
                   throw Exception("Pas de résultat")
                }

                myList.clear()

                myList.addAll(listCity.map {

                    val desc = it.weather.getOrNull(0)
                    val text = "Il fait ${it.main.temp}° avec un vent de ${it.wind.speed}\n${desc?.description ?: "-"}"
                    var urlImage = "https://openweathermap.org/img/wn/${desc?.icon ?: ""}@4x.png"
                    println(urlImage)
                    PictureData(urlImage, it.name, text)
                })
            }catch(e:Exception) {
                //Afficher les détails de l'erreur dans la console
                //Pour le developpeur
                e.printStackTrace()
                //Pour l'utilisateur
                errorMessage.value = "Une erreur : ${e.message}"
            }

            runInProgress.value = false
        }
    }


    fun loadMexicanData() {//Simulation de chargement de donnée
        myList.clear()

        errorMessage.value =""
        runInProgress.value = true

        viewModelScope.launch(Dispatchers.Default) {
            try {
                val listCity: List<MexicanAllFoodBeanItem> = MexicanFoodAPI.loadFoods()

                if(listCity.isEmpty()){
                    throw Exception("Pas de résultat")
                }

                myList.clear()

                myList.addAll(listCity.map {
                    val text = "Difficulté : ${it.difficulty}"
                    PictureData(it.image, it.title, text)
                })
            }catch(e:Exception) {
                //Afficher les détails de l'erreur dans la console
                //Pour le developpeur
                e.printStackTrace()
                //Pour l'utilisateur
                errorMessage.value = "Une erreur : ${e.message}"
            }

            runInProgress.value = false
        }
    }
}