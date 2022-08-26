package com.amrmustafa.ocado.fakes

import com.amrmustafa.ocado.domain.usecases.MainUseCase
import com.amrmustafa.ocado.presentation.models.DetailsPresentation
import com.amrmustafa.ocado.utils.Data.details
import kotlinx.coroutines.flow.Flow
import com.amrmustafa.ocado.utils.Result

class FakeGetDetailsUseCase(
    result: Result
) : BaseTestUseCase<DetailsPresentation,String>(result), MainUseCase< String,Flow<DetailsPresentation>> {


        override suspend fun invoke(params: String): Flow<DetailsPresentation> {
        return execute(params)
    }

    override fun getValue(params: String): DetailsPresentation {
        return if (params == "309396011") details else DetailsPresentation(0, "", "", "", "", "")

    }

}

