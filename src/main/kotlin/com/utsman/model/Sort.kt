package com.utsman.model

enum class Sort {
    RATING, LOW_PRICE, HIGH_PRICE, DISCOUNT, NONE
}

fun String.toSort(): Sort {
    return Sort.valueOf(this.uppercase())
}