package com.amrmustafa.ocado.domain.usecases

import com.amrmustafa.ocado.domain.converters.toViewModel
import kotlinx.coroutines.flow.Flow
import com.amrmustafa.ocado.domain.repository.IDetailsRepository
import com.amrmustafa.ocado.presentation.models.DetailsPresentation
import kotlinx.coroutines.flow.flow

class GetProductDetailUseCase(
    private val detailsRepository: IDetailsRepository
) : MainUseCase<String, Flow<DetailsPresentation>> {

    override suspend operator fun invoke(params: String) = flow {
        emit(detailsRepository.getProductDetail(params).toViewModel())
    }
}


