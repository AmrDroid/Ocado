package com.amrmustafa.ocado.domain.usecases

import com.amrmustafa.ocado.domain.converters.toViewModel
import com.amrmustafa.ocado.domain.repository.IProductsRepository
import com.amrmustafa.ocado.presentation.models.ClusterPresentation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetProductsUseCase(
    private val productRepository: IProductsRepository
) : MainUseCase<String, Flow<List<ClusterPresentation>>> {

    override suspend operator fun invoke(params: String) = flow {
        emit(productRepository.getProducts().toViewModel())
    }
}