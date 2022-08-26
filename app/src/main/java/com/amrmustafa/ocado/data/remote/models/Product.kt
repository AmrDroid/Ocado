package com.amrmustafa.ocado.data.remote.models

data class Product(
    val id: Int,
    val price: String,
    val title: String,
    val size: String,
    val imageUrl: String
)