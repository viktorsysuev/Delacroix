package com.viktorsysuev.delacroix.data.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.viktorsysuev.delacroix.BuildConfig
import com.viktorsysuev.delacroix.data.model.Photo
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface UpsplashService {

    @GET("/photos/?order_by=popular")
    suspend fun getPopularPhotos(): List<Photo>

    companion object {
        fun create(): UpsplashService {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)

            val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

            client.addInterceptor(Interceptor { chain ->
                val original = chain.request()
                val originalHttpUrl: HttpUrl = original.url
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("client_id", BuildConfig.API_KEY)
                    .build()

                val requestBuilder = original.newBuilder()
                    .url(url)

                val request = requestBuilder.build()
                chain.proceed(request)
            })

            return Retrofit.Builder()
                .client(client.build())
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(UpsplashService::class.java)
        }
    }

}