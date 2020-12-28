package com.appku.app.data.remote

import retrofit2.Call
import com.appku.app.data.model.NewsList
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/api/recipes/")
    fun listNews(): Call<NewsList>

    @GET("detail/")
    fun detailNews(@Query("url") url: String): Call<NewsList>

    @GET("search")
    fun searchNew(@Query("q") query: String): Call<NewsList>

}
