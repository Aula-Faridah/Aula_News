package com.bcas.aula_news.data.remote

import android.app.Service
import com.bcas.aula_news.data.NewsService
import com.bcas.aula_news.data.response_model.NewsResponse
import com.bcas.aula_news.utils.Constant
import retrofit2.Response
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val service: NewsService
): NewsRemoteDataSource {
    override suspend fun getDataNews(): Response<NewsResponse> {
        return service.getNews("",Constant.API_KEY)
    }

    override suspend fun getDataNewsId(): Response<NewsResponse> {
        return service.getNews("in",Constant.API_KEY)
    }

    override suspend fun getDataNewsDe(): Response<NewsResponse> {
        return service.getNews("kr", Constant.API_KEY)
    }

    override suspend fun getDataNewsUs(): Response<NewsResponse> {
        return service.getNews("us", Constant.API_KEY)
    }


}