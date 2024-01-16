package com.amonteiro.a01_supvincia.model

import java.util.Random

fun main() {
    val u1 = User
    u1.old++
    val u2 = User
    User.old++
    print(u2.old)


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