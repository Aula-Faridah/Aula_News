package com.bcas.aula_news.presentation.newsus_screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bcas.aula_news.data.remote.NewsRemoteDataSource
import com.bcas.aula_news.data.response_model.NewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsUsViewModel @Inject constructor(
    private val newsUsRemoteDataSource: NewsRemoteDataSource
): ViewModel(){
    private val  _newsUs = MutableLiveData<NewsResponse>()

    val newsUs: LiveData<NewsResponse>
        get() = _newsUs

    private val _newsUsError = MutableLiveData<String>()
    val newsUsError: LiveData<String>
        get() = _newsUsError

    fun getNewsUs() = viewModelScope.launch(Dispatchers.IO) {
        newsUsRemoteDataSource.getDataNewsUs().let {
            if (it.isSuccessful){
                _newsUs.postValue(it.body())
            } else {
                _newsUsError.postValue(it.message())
            }
        }
    }

}