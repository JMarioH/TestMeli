package com.jmariohv.testmeli.modules.search.domain

import com.gentera.yastasgo.commons.applicaction.NetWork
import com.jmariohv.testmeli.modules.search.model.SearchResponse
import com.jmariohv.testmeli.network.ApiServerClient
import com.jmariohv.testmeli.network.ApiServiceState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepoImpl @Inject constructor(
    private val network: NetWork,
    private val apiClient: ApiServerClient
) : SearchRepository {

    override suspend fun search(value: String): Flow<ApiServiceState<SearchResponse?>> {
        return network.executeEndPoint {
            apiClient.getSearch(value)
        }
    }
}