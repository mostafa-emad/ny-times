package com.ny.times.data.ws.rest.listeners

import com.ny.times.data.ws.model.response.MostViewedArticlesResponse


interface ApiResponseListener {
    fun onSuccess(operation: String, result: MostViewedArticlesResponse)
    fun onFailure(operation: String, errorMessage: String)
}
