package com.appku.app.data.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitApi {
    const val NEWS_URL="https://masak-apa.tomorisakura.vercel.app"
    private val client=OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10,TimeUnit.SECONDS)
        .build()

    private fun create(url: String):Retrofit{

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create( ))
            .build()
        return retrofit
    }

    fun newsService():NewsService{
        return  create(NEWS_URL).create(NewsService::class.java)
    }
}