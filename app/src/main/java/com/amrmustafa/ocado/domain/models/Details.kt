package com.amrmustafa.ocado.domain.models

data class Details(
    val id: Int,
    val price: String,
    val title: String,
    val imageUrl: String,
    val description: String,
    val allergyInformation: String
)

