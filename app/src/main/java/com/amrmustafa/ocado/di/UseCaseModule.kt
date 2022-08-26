package com.amrmustafa.ocado.di

import com.amrmustafa.ocado.domain.repository.IDetailsRepository
import com.amrmustafa.ocado.domain.repository.IProductsRepository
import com.amrmustafa.ocado.domain.usecases.*
import kotlinx.coroutines.flow.Flow
import org.koin.core.qualifier.named
import org.koin.dsl.module
import com.amrmustafa.ocado.presentation.models.ClusterPresentation
import com.amrmustafa.ocado.presentation.models.DetailsPresentation


val useCasesModule = module {

    single(named("products")) { provideProductsUseCase(get()) }

    single(named("details")) { provideGetProductDetailsUseCase(get()) }

 }

fun provideProductsUseCase(productsRepository: IProductsRepository): MainUseCase<String, Flow<List<ClusterPresentation>>> {
    return GetProductsUseCase(productsRepository)
}

fun provideGetProductDetailsUseCase(productDetail: IDetailsRepository): MainUseCase<String, Flow<DetailsPresentation>> {
    return GetProductDetailUseCase(productDetail)
}
