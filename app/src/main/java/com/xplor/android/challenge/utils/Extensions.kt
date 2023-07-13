package com.xplor.android.challenge.utils

fun Long.toImageUrlById(): String {
    // TODO: Return empty string, comment out the real extension function.
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$this.png"
//    return ""
}

fun Long.toEntryNumber(): String {
    val number = this.toString()
    val zeroPrefix = when (number.length) {
        1 -> "00"
        2 -> "0"
        else -> ""
    }
    return "$zeroPrefix$number"
}
