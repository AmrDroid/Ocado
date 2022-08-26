package com.amrmustafa.ocado.data.remote.converters

import com.amrmustafa.ocado.data.remote.models.DetailsResponse
import com.amrmustafa.ocado.data.remote.models.Product
import com.amrmustafa.ocado.domain.models.Details
import com.amrmustafa.ocado.domain.models.ProductItem

//from remote data layer to provide data to domain layer

internal fun Product.toDomain() = ProductItem(
    id = this.id,
    price = this.price,
    title = this.title,
    size = this.size,
    imageUrl = this.imageUrl
)


internal fun DetailsResponse.toDomain() = Details(
    id = this.id,
    price = this.price,
    title = this.title,
    imageUrl = this.imageUrl,
    description = this.description,
    allergyInformation = this.allergyInformation
)