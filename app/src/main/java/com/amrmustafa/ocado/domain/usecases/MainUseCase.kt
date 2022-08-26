package com.amrmustafa.ocado.domain.usecases

interface MainUseCase<in Parameter, out Result> {
    suspend operator fun invoke(params: Parameter): Result
}