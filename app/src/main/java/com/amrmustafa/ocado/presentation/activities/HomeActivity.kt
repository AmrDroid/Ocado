package com.amrmustafa.ocado.presentation.activities

import android.os.Bundle
import com.amrmustafa.ocado.R
import com.amrmustafa.ocado.presentation.models.ProductPresentation
import com.amrmustafa.ocado.presentation.utils.*
import com.amrmustafa.ocado.presentation.viewmodel.ProductsViewModel
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.lifecycleScope
import com.amrmustafa.ocado.presentation.models.states.Status
import kotlinx.coroutines.flow.collect


internal class HomeActivity : BaseActivity() {

    private val productsViewModel by viewModel<ProductsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        observeProductViewState()
        productsViewModel.getProducts()
    }

    private fun observeProductViewState() {
        lifecycleScope.launchWhenStarted {
            productsViewModel.productsViewState.collect {
                when (it.status) {
                    Status.LOADING -> {
                        product_results_progress_bar.show()
                        categoryListingView.hide()
                    }
                    Status.SUCCESS -> {
                        product_results_progress_bar.hide()
                        categoryListingView.show()
                        handleProductResults(it.data!!)
                    }
                    Status.ERROR -> {
                        no_result_text_view.show()
                        categoryListingView.remove()
                        showSnackbar(
                            product_results_progress_bar,
                            it.message.toString(),
                            isError = true
                        )
                    }
                }

            }
        }

    }

    private fun handleProductResults(data: Map<String, List<ProductPresentation>>) {
        no_result_text_view.hide()
        showSnackbar(
            product_results_progress_bar,
            getString(R.string.fetchProduct)
        )
        categoryListingView.setData(data)
    }

}
