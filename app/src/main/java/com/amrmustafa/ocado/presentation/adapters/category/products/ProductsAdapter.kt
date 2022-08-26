package com.amrmustafa.ocado.presentation.adapters.category.products


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amrmustafa.ocado.R
import com.amrmustafa.ocado.presentation.activities.ProductDetailsActivity
import com.amrmustafa.ocado.presentation.models.ProductPresentation
import com.bumptech.glide.Glide


internal class ProductsAdapter(private val data: List<ProductPresentation>) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {


    override fun getItemCount(): Int = data.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_product, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = data[position]

        holder.titleTextView.text = dataItem.title
        holder.priceTextView.text = dataItem.price

        Glide.with(holder.productImageView.context)
            .load(dataItem.imageUrl).circleCrop()
            .into(holder.productImageView)

        holder.root.setOnClickListener {
            val myIntent = Intent(it.context, ProductDetailsActivity::class.java)
            myIntent.putExtra("id", dataItem.id)
            it.context.startActivity(myIntent)
        }
    }

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val root = listItemView
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
    }

}
