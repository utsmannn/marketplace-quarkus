package com.utsman.model

data class Category(
    val id: Int,
    val name: String,
    val description: String
) {
    companion object {
        fun unknown(): Category {
            return Category(
                id = 500,
                name = "Other",
                description = "Unknown category"
            )
        }
    }
}