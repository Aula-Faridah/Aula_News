package com.bcas.aula_news.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bcas.aula_news.base.BaseFragment
import com.bcas.aula_news.databinding.FragmentHomeBinding
import com.bcas.aula_news.presentation.newsde_screen.view.NewsDeFragment
import com.bcas.aula_news.presentation.home_screen.adapter.HomeAdapter
import com.bcas.aula_news.presentation.newsid_screen.view.NewsIdFragment
import com.bcas.aula_news.presentation.newsus_screen.view.NewsUsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(){

    private var adapterHome: HomeAdapter? = null
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater,container,false)
    }

    override fun setUpView() {
        setupTabView()
    }

    private fun setupTabView() {
        val tabLayout = binding.tabHome
        val viewPager = binding.vpHome
        adapterHome = HomeAdapter(this)
        adapterHome?.addListFrament(NewsIdFragment())
        adapterHome?.addListFrament(NewsUsFragment())
        adapterHome?.addListFrament(NewsDeFragment())
        viewPager.adapter = adapterHome

        TabLayoutMediator(tabLayout, viewPager) {tab,position ->
            when(position){
                0 -> {
                    tab.text = "ID"
                }
                1 -> {
                    tab.text = "US"
                }
                2 -> {
                    tab.text = "DE"
                }
            }
        }.attach()
    }

}