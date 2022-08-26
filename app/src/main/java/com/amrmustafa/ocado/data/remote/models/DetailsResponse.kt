package com.amrmustafa.ocado.data.remote.models

data class DetailsResponse(
    val id: Int,
    val price: String,
    val title: String,
    val imageUrl: String,
    val description: String,
    val allergyInformation: String
)

