package com.jmariohv.testmeli.network

import kotlinx.coroutines.flow.Flow

interface NetworkStatus {

    fun observe(): Flow<Status>

    enum class Status {
        Conectado, Desconectado
    }
}