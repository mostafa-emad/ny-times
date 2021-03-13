package com.ny.times.data.ws.rest.constants

object ApiServicesNames {
    const val BASE_URL = "http://api.nytimes.com/svc/mostpopular/v2/"
    const val API_KEY = "ASnxXcs5M93Ah5f8arkeAwjw2GPCXUwk"

    const val CONNECTION_TIMEOUT = 10
    const val READ_TIMEOUT = 2
    const val WRITE_TIMEOUT = 2

    //parameters
    const val PATH_SECTION = "section"
    const val PATH_PERIOD = "period"
    const val QUERY_API_KEY = "api-key"

    //services
    const val GET_MOST_VIEWED = "mostviewed/{$PATH_SECTION}/{$PATH_PERIOD}.json"
    const val GET_CITY_FORECAST = "forecast"
}
