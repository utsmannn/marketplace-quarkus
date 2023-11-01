package com.utsman.model

data class ThumbnailProduct(
    val id: Int,
    val name: String,
    val sortDescription: String,
    val category: Category,
    val price: Double,
    val rating: Double,
    val discount: Int,
    val images: String
) {

    companion object {
        fun fromProductRaw(product: Product): ThumbnailProduct {
            return ThumbnailProduct(
                id = product.id,
                name = product.name,
                sortDescription = product.description,
                category = product.category,
                price = product.price,
                rating = product.rating,
                discount = product.discount,
                images = product.images.first()
            )
        }
    }
}