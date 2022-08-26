package com.amrmustafa.ocado.data.remote.helpers


import com.amrmustafa.ocado.data.remote.ApiConstants.Details_URI
import com.amrmustafa.ocado.data.remote.ApiConstants.NO_Products_URI
import com.amrmustafa.ocado.data.remote.ApiConstants.Products_URI
import com.amrmustafa.ocado.data.remote.DETAILS_RESULT
import com.amrmustafa.ocado.data.remote.NO_RESULT
import com.amrmustafa.ocado.data.remote.PRODUCT_API_RESULT
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection


internal class ApiRequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {

        return when (request.path) {

            Products_URI -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(PRODUCT_API_RESULT)
            }
            Details_URI -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(DETAILS_RESULT)
            }
            NO_Products_URI -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(NO_RESULT)
            }

            else -> throw IllegalArgumentException("Unknown Request Path ${request.path.toString()}")
        }
    }

}