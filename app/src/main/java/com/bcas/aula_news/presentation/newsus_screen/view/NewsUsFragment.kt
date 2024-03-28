package com.bcas.aula_news.presentation.newsus_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bcas.aula_news.base.BaseFragment
import com.bcas.aula_news.databinding.FragmentNewsUsBinding

class NewsUsFragment: BaseFragment<FragmentNewsUsBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNewsUsBinding {
        return FragmentNewsUsBinding.inflate(inflater,container, false)
    }

    override fun setUpView() {
    }

}