package com.jmariohv.testmeli.modules.search.domain

import com.jmariohv.testmeli.modules.search.model.SearchResponse
import com.jmariohv.testmeli.network.ApiServiceState
import kotlinx.coroutines.flow.Flow


interface SearchRepository {
    suspend fun search(value: String): Flow<ApiServiceState<SearchResponse?>>
}