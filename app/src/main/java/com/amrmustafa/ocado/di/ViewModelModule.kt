package com.amrmustafa.ocado.di

import com.amrmustafa.ocado.presentation.viewmodel.DetailViewModel
import com.amrmustafa.ocado.presentation.viewmodel.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel {
        ProductsViewModel(
            productUseCase = get(named("products"))
        )
    }

    viewModel {
        DetailViewModel(
            getDetailsUseCase = get(named("details")),
        )
    }


}