package com.amrmustafa.ocado.viewmodels

import com.amrmustafa.ocado.utils.Result
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amrmustafa.ocado.fakes.FakeGetProductsUseCase
import com.amrmustafa.ocado.presentation.viewmodel.ProductsViewModel
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [29])
@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class ProductsViewModelTest : BaseViewModelTest() {

    private lateinit var productsViewModel: ProductsViewModel

    override fun prepareViewModel(result: Result) {
        val fakeGetProductsUseCase = FakeGetProductsUseCase(result)
        productsViewModel = ProductsViewModel(fakeGetProductsUseCase,coroutineTestRule.dispatcher)
    }


    @Test
    fun get_products_success_state() {
        coroutineTestRule.dispatcher.runBlockingTest {
            prepareViewModel(Result.SUCCESS)
            productsViewModel.getProducts()
            Truth.assertThat(productsViewModel.productsViewState.value)
                .isNotNull()
        }

    }

}