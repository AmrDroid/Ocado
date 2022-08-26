package com.amrmustafa.ocado.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amrmustafa.ocado.domain.usecases.MainUseCase
import com.amrmustafa.ocado.presentation.models.ClusterPresentation
import com.amrmustafa.ocado.presentation.models.ProductPresentation
import com.amrmustafa.ocado.presentation.models.states.ViewState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

internal class ProductsViewModel(
    private val productUseCase: MainUseCase<String, Flow<List<ClusterPresentation>>>,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO

) : ViewModel() {

    private val _productViewState: MutableStateFlow<ViewState<Map<String, List<ProductPresentation>>>> =
        MutableStateFlow(ViewState.loading(null))

    val productsViewState: StateFlow<ViewState<Map<String, List<ProductPresentation>>>> =
        _productViewState


    fun getProducts() {
        viewModelScope.launch(defaultDispatcher) {

            _productViewState.emit(ViewState.loading(data = null))
            try {
                productUseCase.invoke("").collect {
                    val result = HashMap<String, List<ProductPresentation>>()
                    it.map { item -> result.put(item.tag, item.items) }
                    _productViewState.emit(
                        ViewState.success(
                            data = result
                        )
                    )
                }
            } catch (exception: Exception) {
                _productViewState.emit(
                    ViewState.error(
                        data = null,
                        message = exception.message ?: "Something went wrong.!"
                    )
                )
            }
        }
    }

}



