package com.amrmustafa.ocado.fakes

import com.amrmustafa.ocado.domain.usecases.MainUseCase
import com.amrmustafa.ocado.presentation.models.ClusterPresentation
import kotlinx.coroutines.flow.Flow
import com.amrmustafa.ocado.utils.Data.cluster1
import com.amrmustafa.ocado.utils.Data.cluster2
import com.amrmustafa.ocado.utils.Result

class FakeGetProductsUseCase(
    result: Result
) : BaseTestUseCase<List<ClusterPresentation>, String>(result),
    MainUseCase<String, Flow<List<ClusterPresentation>>> {

    override suspend fun invoke(params: String): Flow<List<ClusterPresentation>> = execute(params)

    override fun getValue(params: String): List<ClusterPresentation> {
        return listOf(cluster1, cluster2)
    }

}