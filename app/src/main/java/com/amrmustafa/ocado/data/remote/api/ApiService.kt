package com.amrmustafa.ocado.data.remote.api

import com.amrmustafa.ocado.data.remote.models.ProductsResponse
import com.amrmustafa.ocado.data.remote.models.DetailsResponse
import retrofit2.http.*


interface ApiService {

    @GET("products")
    suspend fun getProducts(): ProductsResponse

    @GET("product/{id}")
    suspend fun getProductDetail(
        @Path("id") id: String,
    ): DetailsResponse


}