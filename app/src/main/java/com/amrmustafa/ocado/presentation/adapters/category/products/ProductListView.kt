package com.amrmustafa.ocado.presentation.adapters.category.products

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.amrmustafa.ocado.presentation.models.ProductPresentation
import kotlinx.android.synthetic.main.product_listing_layout.view.*
import com.amrmustafa.ocado.R

internal class ProductListView constructor(context: Context, attrs: AttributeSet) :
    FrameLayout(context, attrs) {
    init {
        inflate(getContext(), R.layout.product_listing_layout, this)

    }

    fun setData(data: List<ProductPresentation>) {
        val adapter = ProductsAdapter(data)
        productRecyclerView.adapter = adapter
        productRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        visibility = View.VISIBLE
        productRecyclerView.visibility = View.VISIBLE
    }
}