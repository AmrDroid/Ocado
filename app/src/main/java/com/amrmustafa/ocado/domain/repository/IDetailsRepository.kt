package com.amrmustafa.ocado.domain.repository


import com.amrmustafa.ocado.domain.models.Details

interface IDetailsRepository {
    suspend fun getProductDetail(productID: String): Details
}