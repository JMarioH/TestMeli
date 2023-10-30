package com.jmariohv.testmeli.network

import com.gentera.yastasgo.commons.applicaction.ErrorApiResponse

sealed class ApiServiceState<out R> {
    object Loading : ApiServiceState<Nothing>()
    class Success<out T>(val data: T) : ApiServiceState<T>()
    data class Error(val exception: ErrorApiResponse) : ApiServiceState<Nothing>()
}