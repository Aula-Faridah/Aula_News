package com.bcas.aula_news.presentation.newsde_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bcas.aula_news.base.BaseFragment
import com.bcas.aula_news.databinding.FragmentNewsDeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDeFragment:BaseFragment<FragmentNewsDeBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNewsDeBinding {
        return FragmentNewsDeBinding.inflate(inflater,container,false)
    }

    override fun setUpView() {
    }

}