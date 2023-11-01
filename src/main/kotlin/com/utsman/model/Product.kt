package com.utsman.model

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val category: Category,
    val price: Double,
    val rating: Double,
    val discount: Int,
    val images: List<String>,
    val userReview: List<UserReview>
)