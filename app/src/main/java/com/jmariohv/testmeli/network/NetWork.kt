package com.gentera.yastasgo.commons.applicaction

import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.annotations.SerializedName
import com.jmariohv.testmeli.R
import com.jmariohv.testmeli.network.ApiServiceState
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject


data class ErrorApiResponse(
    @SerializedName("code"  ) var codeError : Int?     = null,
    @SerializedName("error" ) var error: ErrorGeneric? = ErrorGeneric()
)

data class ErrorGeneric(
    @SerializedName("name") var name: String? = null,
    @SerializedName("message") var message: String? = null

)


class NetWork @Inject constructor(@ApplicationContext val context: Context) {

    suspend inline fun <T> executeEndPoint(
        crossinline callFunction: suspend () -> T
    ): Flow<ApiServiceState<T>> {
        val result = isNetworkAvailable()
        if (result) {
            return flow {
                emit(ApiServiceState.Loading)
                val data = callFunction.invoke()
                emit(ApiServiceState.Success(data))
            }.handleErrors()
        } else {
            return flow {
                emit(ApiServiceState.Loading)
                emit(
                    ApiServiceState.Error(
                        ErrorApiResponse(
                            codeError = 4000,
                            error = ErrorGeneric(
                                "Error",
                                context.getString(R.string.network_error)
                            )
                        )
                    )
                )
            }
        }

    }


    fun <T> Flow<ApiServiceState<T>>.handleErrors(): Flow<ApiServiceState<T>> =
        catch { exception ->
            exception.printStackTrace()

            when (exception) {
                is HttpException -> {
                    emit(
                        ApiServiceState.Error(
                            ErrorApiResponse(
                                codeError = exception.code(),
                                error = ErrorGeneric("Error",  exception.message)
                            )
                        )
                    )
                }

                is IOException -> {
                    emit(
                        ApiServiceState.Error(
                            ErrorApiResponse(
                                codeError = 4000,
                                error = ErrorGeneric("Error",  exception.message)
                            )
                        )
                    )
                }

                is SocketTimeoutException -> {
                    emit(
                        ApiServiceState.Error(
                            ErrorApiResponse(
                                codeError = 4001,
                                error = ErrorGeneric("Error",  exception.message)
                            )
                        )
                    )
                }

                else -> {
                    emit(
                        ApiServiceState.Error(
                            ErrorApiResponse(
                                codeError = 4003,
                                error = ErrorGeneric("Error",  exception.message)
                            )
                        )
                    )
                }
            }

        }


    @JvmName("isNetworkAvailable1")
    fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnected == true
    }

}

