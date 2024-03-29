package com.amonteiro.a01_supvincia.model

import java.util.Random

fun main() {
    val randomName = RandomName()
    randomName.add("bobby")
    repeat(10) {
        println(randomName.next() + " ")
    }
    val list = arrayListOf("Bob", "Tobby", "John")
    println(list.joinToString { "${it} " }) //toto : 22 null : 20 Charles : 14
}

const val LONG_TEXT = """Le Lorem Ipsum est simplement
    du faux texte employé dans la composition
    et la mise en page avant impression.
    Le Lorem Ipsum est le faux texte standard
    de l'imprimerie depuis les années 1500"""
data class PictureData(val url: String, val text: String, val longText: String)

//jeu de donnée
val pictureList = arrayListOf(PictureData("https://picsum.photos/200", "ABCD", LONG_TEXT),
    PictureData("https://picsum.photos/201", "BCDE", LONG_TEXT),
    PictureData("https://picsum.photos/202", "CDEF", LONG_TEXT),
    PictureData("https://picsum.photos/203", "EFGH", LONG_TEXT)
)



class RandomName() {


    private val list = arrayListOf("Bob", "Tobby", "John")
    private var oldValue = ""

    fun add(s: String?) = if(!s.isNullOrBlank() && s !in list) list.add(s) else false


    fun next() = list.random()

    fun nextDiff2(): String {
        oldValue = list.filter { it != oldValue }.random()
        return oldValue
    }

    fun next2() = Pair(nextDiff(), nextDiff())

    fun nextDiff3() = list.filter { it != oldValue }.random().also { oldValue = it }

    fun nextDiff(): String {

        var newValue = next()

        while(newValue == oldValue) {
            newValue = next()
        }

        oldValue = newValue
        return newValue
    }




}

object User {
    var old = 0

    init {
        println("Créatrion de User")
    }
}


class PrintRandomIntBean(val max: Int) {

    private val random = Random()

    init {
        println(random.nextInt(max))
        println(random.nextInt(max))
        println(random.nextInt(max))
    }


    constructor() : this(100) {
        println()
        println(random.nextInt(max))
    }


}

class ThermometerBean(var min: Int, var max: Int, value: Int) {
    var value = value.coerceIn(min..max)
        set(newValue) {
            field = newValue.coerceIn(min..max)
        }
}


class HouseBean(var color: String, width: Int, length: Int) {
    var area = width * length
    override fun toString(): String {
        return "HouseBean(color='$color', area=$area)"
    }

    fun print() = println("La maison $color fait ${area}m²")
}

data class CarBean(var marque: String, var model: String?) {
    var color = ""

    fun printCar() = "coucou $marque $color"
}