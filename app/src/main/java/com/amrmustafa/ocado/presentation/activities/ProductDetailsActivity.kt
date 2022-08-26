package com.amrmustafa.ocado.presentation.activities

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.amrmustafa.ocado.presentation.models.*
import com.amrmustafa.ocado.presentation.utils.*
import com.amrmustafa.ocado.presentation.viewmodel.DetailViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.no_result_text_view
import com.amrmustafa.ocado.R
import com.amrmustafa.ocado.presentation.models.states.Status
import kotlinx.coroutines.flow.collect

internal class ProductDetailsActivity : BaseActivity() {

    private val detailViewModel by viewModel<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val productID = intent.getIntExtra("id", 0).toString()

        if (productID.isBlank()) {
            no_result_text_view.show()
        } else {
            detailViewModel.getDetails(productID)
            observeNetworkChanges()
        }
        observeDetailViewState()
    }

    private fun observeDetailViewState() {
        lifecycleScope.launchWhenStarted {
            detailViewModel.detailsViewState.collect {
                when (it.status) {

                    Status.LOADING -> {
                        detailsProgressBar.show()
                        no_result_text_view.show()
                    }
                    Status.SUCCESS -> {
                        detailsProgressBar.hide()
                        no_result_text_view.hide()
                        it.data.let { result ->
                            if (result == null) {
                                handleNoDetailsResults()
                                return@let
                            }
                            bindBasicInfo(result)
                        }
                    }
                    Status.ERROR -> {
                        handleNoDetailsResults()
                    }
                }

            }
        }

    }


    private fun handleNoDetailsResults() {
        detailsProgressBar.hide()
        no_result_text_view.show()
        showSnackbar(
            detailsProgressBar,
            getString(R.string.info_no_results)
        )
    }

    private fun observeNetworkChanges() {
        onNetworkChange { isConnected ->
            if (isConnected)
                no_result_text_view.hide()
            else
                showSnackbar(
                    detailsProgressBar,
                    getString(R.string.error_check_internet_connection)
                )
        }
    }


    private fun bindBasicInfo(product: DetailsPresentation?) {
        Glide.with(this).load(product?.imageUrl).into(productImageView)
        titleTextView.text = product?.title ?: ""
        descriptionTextView.text = product?.description ?: ""
        allergyInformationTextView.text = product?.allergyInformation ?: ""
    }


}
