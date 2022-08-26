package com.amrmustafa.ocado.data.remote.repository

import com.amrmustafa.ocado.data.remote.api.ApiService
import com.amrmustafa.ocado.data.remote.converters.toDomain
import com.amrmustafa.ocado.domain.models.Cluster
import com.amrmustafa.ocado.domain.repository.IProductsRepository

//ProductsRepository that interact with domain layer to provide data to presentation layer when required


class ProductsRepository(
    private val apiService: ApiService
) : IProductsRepository {

    override suspend fun getProducts(): List<Cluster> {
        val clusters = mutableListOf<Cluster>()
        apiService.getProducts().clusters.map { data ->
            clusters.add(Cluster(data.tag, data.items.map { it.toDomain() }))
        }
        return clusters
    }

}