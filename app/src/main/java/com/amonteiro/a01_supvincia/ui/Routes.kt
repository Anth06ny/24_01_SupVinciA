package com.amonteiro.a01_supvincia.ui

sealed class Routes(val route : String) {
    object SearchScreen : Routes("searchScreen")
    object DetailScreen : Routes("detailScreen/{data}") {
        fun addParam(position: Int) = "detailScreen/$position"
    }

}