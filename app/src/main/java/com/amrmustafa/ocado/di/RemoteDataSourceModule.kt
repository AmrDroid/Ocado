package com.amrmustafa.ocado.di

import com.amrmustafa.ocado.data.remote.repository.DetailsRepository
import com.amrmustafa.ocado.data.remote.repository.ProductsRepository
import com.amrmustafa.ocado.domain.repository.IDetailsRepository
import com.amrmustafa.ocado.domain.repository.IProductsRepository
import org.koin.dsl.module


val remoteDataSourceModule = module {

    single<IProductsRepository> { ProductsRepository(apiService = get()) }

    single<IDetailsRepository> { DetailsRepository(apiService = get()) }

}