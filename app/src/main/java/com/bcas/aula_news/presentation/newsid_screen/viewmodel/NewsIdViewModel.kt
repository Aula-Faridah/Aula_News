package com.bcas.aula_news.presentation.newsid_screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bcas.aula_news.data.NewsService
import com.bcas.aula_news.data.remote.NewsRemoteDataSource
import com.bcas.aula_news.data.response_model.NewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsIdViewModel @Inject constructor(
    private val newsIdRemoteDataSource: NewsRemoteDataSource
): ViewModel() {
    private val _newsId = MutableLiveData<NewsResponse>()

    val newsId: LiveData<NewsResponse>
        get() = _newsId

    private val _newsIdError = MutableLiveData<String>()

    val newsIdError: LiveData<String>
        get() = _newsIdError

    fun getNewsId() = viewModelScope.launch(Dispatchers.IO){
        newsIdRemoteDataSource.getDataNewsId().let {
            if (it.isSuccessful){
                _newsId.postValue(it.body())
            } else{
                _newsIdError.postValue(it.message())
            }
        }
    }
}