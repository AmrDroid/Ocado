package com.amrmustafa.ocado.presentation.adapters.category

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.amrmustafa.ocado.presentation.models.ProductPresentation
import kotlinx.android.synthetic.main.category_listing_layout.view.*
import com.amrmustafa.ocado.R

internal class CategoryListingView constructor(context: Context, attrs: AttributeSet) :
    FrameLayout(context, attrs) {
    init {
        inflate(getContext(), R.layout.category_listing_layout, this)
    }

    fun setData(data: Map<String, List<ProductPresentation>>) {
        val adapter = CategoryAdapter(data)
        categoryRecyclerView.adapter = adapter
        categoryRecyclerView.layoutManager = LinearLayoutManager(context)

        visibility = View.VISIBLE
        categoryRecyclerView.visibility = View.VISIBLE
    }
}