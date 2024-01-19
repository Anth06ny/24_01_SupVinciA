package com.amonteiro.a01_supvincia.model

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    val res = WeatherAPI.loadWeatherAround("Nice")
    println(res)
}

object WeatherAPI {
    val client = OkHttpClient()
    val gson = Gson()

    const val URL_API = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr"
    const val URL_API_AROUND = "https://api.openweathermap.org/data/2.5/find?cnt=5&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr&q="

    fun loadWeather(cityName : String): WeatherBean {
        val json = sendGet(URL_API.format(cityName))
        return gson.fromJson(json, WeatherBean::class.java)
    }

    fun loadWeatherAround(cityName : String): List<WeatherBean> {

        if(cityName.length < 3 ){
            throw Exception("Il faut au moins 3 caractères")
        }

        val json = sendGet(URL_API_AROUND + cityName)
        return gson.fromJson(json, WeatherAroundResult::class.java).list
    }

    //Méthode qui prend en entrée une url, execute la requête
    //Retourne le code HTML/JSON reçu
    fun sendGet(url: String): String {
        println("url : $url")
        //Création de la requête
        val request = Request.Builder().url(url).build()
        //Execution de la requête
        return client.newCall(request).execute().use { //it:Response
            //use permet de fermer la réponse qu'il y ait ou non une exception
            //Analyse du code retour
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }
}

/* -------------------------------- */
// Bean
/* -------------------------------- */
data class WeatherAroundResult(val list : List<WeatherBean>)
data class WeatherBean(var main : TempBean, var wind:WindBean, var name:String, var weather:List<DescriptionBean> )
data class TempBean(var temp : Double)
data class WindBean(var speed : Double)
data class DescriptionBean(
    var description: String,
    var icon: String
)

