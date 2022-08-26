package com.amrmustafa.ocado.domain.repository
import com.amrmustafa.ocado.domain.models.Cluster

interface IProductsRepository {
    suspend fun getProducts(): List<Cluster>
}