package com.bcas.aula_news.presentation.newsde_screen.viewmodel

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
class NewsDeViewModel @Inject constructor(
    private val newsDeRemoteDataSource: NewsRemoteDataSource
): ViewModel() {
    private val  _newsDe = MutableLiveData<NewsResponse>()

    val newsDe: LiveData<NewsResponse>
        get() = _newsDe

    private val _newsDeError = MutableLiveData<String>()
    val newsDeError: LiveData<String>
        get() = _newsDeError

    fun getNewsDe() = viewModelScope.launch(Dispatchers.IO) {
        newsDeRemoteDataSource.getDataNewsDe().let {
            if (it.isSuccessful){
                _newsDe.postValue(it.body())
            } else {
                _newsDeError.postValue(it.message())
            }
        }
    }
}