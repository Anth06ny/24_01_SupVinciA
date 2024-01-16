package com.amonteiro.a01_supvincia.exo

fun main() {

    val res = boulangerie(
        scanNumber("Nb croissant : "),
        scanNumber("Nb sandwitch : "),
        scanNumber("Nb baguette : ")
    )
    println("res=$res")


}

fun scanText(question: String): String {
    print(question)
    return readlnOrNull() ?: "-"
}

fun scanNumber(question: String): Int {
    return scanText(question).toIntOrNull() ?: 0
}

fun boulangerie(nbC: Int = 0, nbS: Int = 0, nbBag: Int = 0) =
    nbC * PRICE_CROI + nbS * PRICE_SAND + nbBag * PRICE_BAG

fun myPrint(text: String) = println("#$text#")

fun pair(c: Int) = c % 2 == 0

fun min(a: Int, b: Int, c: Int) = if (a < b && a < c) a else if (b < a && b < c) b else c


































