package com.amrmustafa.ocado.domain.models

data class ProductItem(
    val id: Int,
    val price: String,
    val title: String,
    val size: String,
    val imageUrl: String
)