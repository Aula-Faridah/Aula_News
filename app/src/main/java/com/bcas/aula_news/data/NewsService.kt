package com.bcas.aula_news.data

import com.bcas.aula_news.data.response_model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
    ) : Response<NewsResponse>
}