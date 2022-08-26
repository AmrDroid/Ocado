package com.amrmustafa.ocado.utils

import com.amrmustafa.ocado.presentation.models.ClusterPresentation
import com.amrmustafa.ocado.presentation.models.DetailsPresentation
import com.amrmustafa.ocado.presentation.models.ProductPresentation


object Data {

    val products = arrayListOf(
        ProductPresentation(
            91500011,
            "1.35",
            "Ocado Baby Leeks",
            "110g",
            "https://mobile.ocado.com/webservices/catalogue/items/item/91500011/images/image/0/240x240.jpg"

        ), ProductPresentation(
            65453011,
            "0.85",
            "Ocado Red Onions",
            "3 per pack",
            "https://mobile.ocado.com/webservices/catalogue/items/item/65453011/images/image/0/240x240.jpg"
        )
    )
    val cluster1 = ClusterPresentation("cat", products)
    val cluster2 = ClusterPresentation("cat2", products)


    val details = DetailsPresentation(
        309396011,
        "1.45",
        "Ocado Organic Fairtrade Bananas",
        "https://mobile.ocado.com/webservices/catalogue/items/item/309396011/images/image/0/360x360.jpg",
        "Organic. Suitable for vegetarians",
        "May contain traces of Sesame Seeds"
    )


}
