package com.jmariohv.testmeli.di.network

import android.app.Application
import android.content.Context
import com.google.gson.GsonBuilder
import com.jmariohv.testmeli.network.ApiServerClient
import com.jmariohv.testmeli.network.EndPointsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkClientModule {

    private val APPLICATION_JSON = "application/json"

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext


    @Singleton
    @Provides
    @Named("ApiUrl")
    fun providesServerMockUrl() = "https://api.mercadolibre.com/"


    @Singleton
    @Provides
    @Named("ApiClient")
    fun provideOkHttpClient(): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val loggerInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC)

        return OkHttpClient.Builder()
            .addInterceptor(loggerInterceptor)
            .addInterceptor() {
                val original: Request = it.request()
                val request: Request = original.newBuilder()
                    .header("Authorization", "TOKEN")
                    .header("Content-Type", APPLICATION_JSON)

                    .method(original.method, original.body)
                    .build()
                return@addInterceptor it.proceed(request)
            }
            .addInterceptor(logInterceptor)
            .readTimeout(EndPointsApi.READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(EndPointsApi.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build()

    }


    @Singleton
    @Provides
    @Named("RetrofitInstance")
    fun provideRetrofitServer(
        @Named("ApiUrl") baseUrl: String,
        @Named("ApiClient") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setPrettyPrinting().create()
                )
            )
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()

    }


    @Singleton
    @Provides
    fun restApiServerServices(@Named("RetrofitInstance") retrofit: Retrofit): ApiServerClient =
        retrofit.create(ApiServerClient::class.java)

}