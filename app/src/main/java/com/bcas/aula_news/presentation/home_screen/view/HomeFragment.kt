package com.bcas.aula_news.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bcas.aula_news.base.BaseFragment
import com.bcas.aula_news.databinding.FragmentHomeBinding
import com.bcas.aula_news.presentation.detail_screen.adapter.HomeTabAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(){


    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater,container,false)
    }

    override fun setUpView() {
        TODO("Not yet implemented")
    }



}