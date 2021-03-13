package com.ny.times.data.ws.rest.listeners

import com.ny.times.data.ws.model.response.BaseResponse

interface IResponseListener {
    fun onSuccess(
        serviceName:String,
        result: BaseResponse?
    )
    fun onFailure(serviceName:String)
}
