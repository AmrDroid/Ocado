package com.amrmustafa.ocado.presentation.models


data class DetailsPresentation(
    val id: Int,
    val price: String,
    val title: String,
    val imageUrl: String,
    val description: String,
    val allergyInformation: String
)
