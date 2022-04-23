package com.viktorsysuev.delacroix.data.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.viktorsysuev.delacroix.BuildConfig
import com.viktorsysuev.delacroix.data.model.Photo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface UpsplashService {

    @GET("/photos/random?client_id=${BuildConfig.API_KEY}")
    suspend fun getRandomPhoto(): Photo


    companion object {
        fun create(): UpsplashService {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

            return Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(UpsplashService::class.java)
        }
    }

}