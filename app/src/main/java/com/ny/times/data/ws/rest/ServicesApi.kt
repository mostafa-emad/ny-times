package com.ny.times.data.ws.rest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.ny.times.data.ws.model.response.MostViewedArticlesResponse
import com.ny.times.data.ws.rest.constants.ApiServicesNames
import retrofit2.http.Path

interface ServicesApi {

    @GET(ApiServicesNames.GET_MOST_VIEWED)
    fun getMostViewedData(@Path(ApiServicesNames.PATH_SECTION) section : String,
                          @Path(ApiServicesNames.PATH_PERIOD) period : Int,
                          @Query(ApiServicesNames.QUERY_API_KEY) key : String): Call<MostViewedArticlesResponse>


}
