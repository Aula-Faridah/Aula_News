package com.bcas.aula_news.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.bcas.aula_news.base.BaseFragment
import com.bcas.aula_news.databinding.FragmentHomeBinding
import com.bcas.aula_news.presentation.newsde_screen.view.NewsDeFragment
import com.bcas.aula_news.presentation.home_screen.adapter.HomeAdapter
import com.bcas.aula_news.presentation.newsid_screen.view.NewsIdFragment
import com.bcas.aula_news.presentation.newsus_screen.view.NewsUsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private var adapterHome: HomeAdapter? = null
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun setUpView() {
        setupTabView()
    }

    private fun setupTabView() {
        val tabLayout = binding.tabHome
        val viewPager = binding.vpHome
        val loadingPage = binding.loadingProgressBar

        adapterHome = HomeAdapter(this)
        adapterHome?.addListFrament(NewsIdFragment())
        adapterHome?.addListFrament(NewsDeFragment())
        adapterHome?.addListFrament(NewsUsFragment())
        viewPager.adapter = adapterHome

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            loadingPage.visibility = View.GONE
            when (position) {
                0 -> {
                    tab.text = "INDIA"
                }

                1 -> {
                    tab.text = "KOREA"
                }

                2 -> {
                    tab.text = "UNITED STATES"
                }
            }
        }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                if (state == ViewPager2.SCROLL_STATE_DRAGGING || state == ViewPager2.SCROLL_STATE_SETTLING) {
                    // Ketika sedang melakukan scroll atau menetapkan halaman
                    loadingPage.visibility = View.VISIBLE
                }
                else if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    // Ketika proses loading sudah selesai
                    loadingPage.visibility = View.GONE
                }
            }
        })

        viewPager.post {
            loadingPage.visibility = View.GONE
        }
    }

}