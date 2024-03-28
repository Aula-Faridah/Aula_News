package com.bcas.aula_news.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bcas.aula_news.base.BaseFragment
import com.bcas.aula_news.databinding.FragmentNewsIdBinding

class NewsIdFragment: BaseFragment<FragmentNewsIdBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNewsIdBinding {
        return FragmentNewsIdBinding.inflate(inflater,container,false)
    }

    override fun setUpView() {
    }

}