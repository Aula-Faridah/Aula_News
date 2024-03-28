package com.bcas.aula_news.module

import android.app.Service
import com.bcas.aula_news.data.NewsService
import com.bcas.aula_news.data.remote.NewsRemoteDataSource
import com.bcas.aula_news.data.remote.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(service: NewsService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(service)
    }
}