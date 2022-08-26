package com.amrmustafa.ocado.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amrmustafa.ocado.domain.usecases.MainUseCase
import com.amrmustafa.ocado.presentation.models.DetailsPresentation
import com.amrmustafa.ocado.presentation.models.states.ViewState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

internal class DetailViewModel(
    private val getDetailsUseCase: MainUseCase<String, Flow<DetailsPresentation>>,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {


    private val _detailsViewState: MutableStateFlow<ViewState<DetailsPresentation>> =
        MutableStateFlow(ViewState.loading(null))

    val detailsViewState: StateFlow<ViewState<DetailsPresentation>> =
        _detailsViewState


    fun getDetails(id: String) {
        viewModelScope.launch(defaultDispatcher) {
            _detailsViewState.emit(ViewState.loading(data = null))
            try {
                getDetailsUseCase.invoke(id).collect {
                    _detailsViewState.emit(
                        ViewState.success(
                            data = it
                        )
                    )
                }
            } catch (exception: Exception) {
                _detailsViewState.emit(
                    ViewState.error(
                        data = null,
                        message = exception.message ?: "Something went wrong.!"
                    )
                )
            }
        }
    }
}
