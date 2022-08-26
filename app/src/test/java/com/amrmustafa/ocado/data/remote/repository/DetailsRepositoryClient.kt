package com.amrmustafa.ocado.data.remote.repository

import com.amrmustafa.ocado.data.remote.BaseClient
import com.amrmustafa.ocado.domain.repository.IDetailsRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class DetailsRepositoryClient : BaseClient() {

    private lateinit var detailsRepository: IDetailsRepository

    @Before
    override fun setup() {
        super.setup()
        detailsRepository = DetailsRepository(apiService)

    }

    @Test
    fun get_product_details_test() {
        runBlocking {
            val reviews = detailsRepository.getProductDetail("309396011")

            Truth.assertThat(reviews).isNotNull()

        }
    }
}
