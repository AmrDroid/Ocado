package com.amrmustafa.ocado.viewmodels

import com.amrmustafa.ocado.utils.Result
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amrmustafa.ocado.fakes.FakeGetDetailsUseCase
import com.amrmustafa.ocado.presentation.models.states.ViewState
import com.amrmustafa.ocado.presentation.viewmodel.DetailViewModel
import com.amrmustafa.ocado.utils.Data.details
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [29])
@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class DetailsViewModelTest : BaseViewModelTest() {

    private lateinit var detailsViewModel: DetailViewModel

    override fun prepareViewModel(result: Result) {
        val getDetailsUseCase = FakeGetDetailsUseCase(result)
        detailsViewModel = DetailViewModel(getDetailsUseCase, coroutineTestRule.dispatcher)
    }

    @Test
    fun details_result_success_state() {
        coroutineTestRule.dispatcher.runBlockingTest {
            prepareViewModel(Result.SUCCESS)
            detailsViewModel.getDetails("309396011")
            Truth.assertThat(detailsViewModel.detailsViewState.value)
                .isEqualTo(ViewState.success(details))
        }
    }
}




