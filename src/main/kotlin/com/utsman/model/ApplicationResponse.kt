package com.utsman.model

data class ApplicationResponse<T>(
    val status: Boolean = false,
    val message: String = "",
    val data: T? = null
)