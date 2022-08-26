package com.amrmustafa.ocado.data.remote.repository

import com.amrmustafa.ocado.data.remote.api.ApiService
import com.amrmustafa.ocado.data.remote.converters.toDomain
import com.amrmustafa.ocado.domain.models.*
import com.amrmustafa.ocado.domain.repository.IDetailsRepository

//Details Repository that interact with domain layer to provide data to presentation layer when required

class DetailsRepository(
    private val apiService: ApiService
) : IDetailsRepository {

    override suspend fun getProductDetail(productID: String): Details =
        apiService.getProductDetail(id = productID).toDomain()

}