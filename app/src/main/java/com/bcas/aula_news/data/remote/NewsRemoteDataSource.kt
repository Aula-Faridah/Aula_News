package com.bcas.aula_news.data.remote

import com.bcas.aula_news.data.response_model.NewsResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getDataNews() : Response<NewsResponse>
    suspend fun getDataNewsId() : Response<NewsResponse>
    suspend fun getDataNewsDe() : Response<NewsResponse>
    suspend fun getDataNewsUs() : Response<NewsResponse>
}