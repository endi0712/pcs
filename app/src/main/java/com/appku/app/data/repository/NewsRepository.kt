package com.appku.app.data.repository

import com.appku.app.data.model.ActionState
import com.appku.app.data.model.News
import com.appku.app.data.remote.NewsService
import com.appku.app.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class NewsRepository {
    private val newsService: NewsService by lazy { RetrofitApi.newsService() }

    suspend fun listNews(): ActionState<List<News>>{
        return try {
            val list= newsService.listNews().await()
            ActionState(list.results)
        } catch (e: Exception){
            ActionState(message = e.message,isSuccess = false)
        }
    }

    suspend fun detailNews(url:String) :ActionState<News>{
        return try {
            val list=newsService.detailNews(url).await()
            ActionState(list.results.first())
        } catch (e: Exception){
            ActionState(message = e.message,isSuccess = false)
        }
    }

    suspend fun searchNews(query: String):ActionState<List<News>>{
        return try{
            val list= newsService.searchNew(query).await()
            ActionState(list.results)
        }catch (e: Exception){
            ActionState(message = e.message,isSuccess = false)
        }
    }

}