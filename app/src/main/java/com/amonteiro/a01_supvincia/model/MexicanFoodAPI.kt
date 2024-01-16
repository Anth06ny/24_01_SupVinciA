package com.amonteiro.a01_supvincia.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    val res = MexicanFoodAPI.loadFood(4)
    println(res)
}

object MexicanFoodAPI {
    val client = OkHttpClient()
    val gson = Gson()

    const val URL_API = "https://the-mexican-food-db.p.rapidapi.com"

    fun loadFood(id: Int): MexicanFoodBean {
        val json = sendGet(URL_API + "/4")
        return gson.fromJson(json, MexicanFoodBean::class.java)
    }

    //Méthode qui prend en entrée une url, execute la requête
    //Retourne le code HTML/JSON reçu
    fun sendGet(url: String): String {
        println("url : $url")
        //Création de la requête
        val request = Request.Builder()
            .url(url)
            .get()
            .addHeader("X-RapidAPI-Key", "93329c7cf9msha136bd696cd1040p10a1dejsnbc52cdb0746e")
            .addHeader("X-RapidAPI-Host", "the-mexican-food-db.p.rapidapi.com")
            .build()
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
data class MexicanFoodBean(
    var description: String,
    var difficulty: String,
    var id: String,
    var image: String,
    var ingredients: List<String>,
    var method: List<Method>,
    var portion: String,
    var time: String,
    var title: String
)

data class Method(
    @SerializedName("Step 1")
    var step1: String?,
    @SerializedName("Step 2")
    var step2: String?,
    @SerializedName("Step 3")
    var step3: String?,
    @SerializedName("Step 4")
    var step4: String?
)

