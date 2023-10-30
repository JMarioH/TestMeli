package com.jmariohv.testmeli.network

object EndPointsApi {
    //TimeOut
    const val CONNECT_TIMEOUT = 90L
    const val READ_TIMEOUT = 90L

    //Services
    const val CONTENT_TYPE = "Content-Type: application/json"
    const val TOKEN = "Bearer abcdefghijklmñopqrs"

    //Urls
    const val GET_SEARCH = "/sites/MLA/search"
    const val GET_SITES_CAT = "sites/MLA/categories"
    const val GET_CAT = "categories/"

}