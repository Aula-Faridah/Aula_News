package com.bcas.aula_news.presentation.home_screen.viewmodel

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

class HomeViewModel : ViewModel() {

//    private val _homeNews = MutableLiveData<NewsResponse>()
//
//    val homeNews: LiveData<NewsResponse>
//        get() = _homeNews
//
//    private val _homeNewsError = MutableLiveData<String>()
//
//    val homeNewsError: LiveData<String>
//        get() = _homeNewsError
//
//    fun getHomeNews() = viewModelScope.launch(Dispatchers.IO){
//        homeRemoteDataSource.getDataNews().let {
//            if (it.isSuccessful){
//                _homeNews.postValue(it.body())
//            } else {
//                _homeNewsError.postValue(it.message())
//            }
//        }
//    }
}