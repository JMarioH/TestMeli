package com.jmariohv.testmeli.network

import com.jmariohv.testmeli.modules.search.model.SearchResponse
import com.jmariohv.testmeli.network.EndPointsApi.GET_SEARCH
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServerClient {

    @GET(GET_SEARCH)
    suspend fun getSearch(@Query("q") search: String): SearchResponse

}