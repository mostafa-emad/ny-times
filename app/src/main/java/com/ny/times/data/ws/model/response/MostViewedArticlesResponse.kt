package com.ny.times.data.ws.model.response

import com.ny.times.data.ws.model.mostviewed.ResultModel


class MostViewedArticlesResponse (
    val status : String,
    val copyright : String,
    val num_results : Int,
    val results : List<ResultModel> = arrayListOf()

) : BaseResponse()