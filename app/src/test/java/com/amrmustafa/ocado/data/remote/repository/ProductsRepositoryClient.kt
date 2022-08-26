package com.amrmustafa.ocado.data.remote.repository


import com.amrmustafa.ocado.data.remote.BaseClient
import com.amrmustafa.ocado.domain.repository.IProductsRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class ProductsRepositoryClient : BaseClient() {

    private lateinit var productRepository: IProductsRepository

    @Before
    override fun setup() {
        super.setup()
        productRepository = ProductsRepository(apiService)
    }

    @Test
    fun get_products_test() {
        runBlocking {
            val results = productRepository.getProducts()
            Truth.assertThat(results).isNotNull()
        }
    }

}