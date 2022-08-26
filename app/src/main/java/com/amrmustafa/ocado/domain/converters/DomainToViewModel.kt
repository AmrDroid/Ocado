package com.amrmustafa.ocado.domain.converters

import com.amrmustafa.ocado.presentation.models.*
import com.amrmustafa.ocado.domain.models.*


//From Domain To Presentation Layer

internal fun List<Cluster>.toViewModel(): List<ClusterPresentation> {

    val clusters = mutableListOf<ClusterPresentation>()

    this.map {
        clusters.add(
            ClusterPresentation(
                it.tag,
                it.items.map { item -> item.toViewModel() })
        )
    }

    return clusters
}


internal fun ProductItem.toViewModel() = ProductPresentation(
    id = this.id,
    price = this.price,
    title = this.title,
    size = this.size,
    imageUrl = this.imageUrl
)


internal fun Details.toViewModel() = DetailsPresentation(
    id = this.id,
    price = this.price,
    title = this.title,
    imageUrl = this.imageUrl,
    description = this.description,
    allergyInformation = this.allergyInformation
)

