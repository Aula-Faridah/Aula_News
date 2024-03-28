package com.bcas.aula_news.presentation.detail_screen.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeTabAdapter(
    fragment: Fragment,
) : FragmentStateAdapter(
    fragment.childFragmentManager,
    fragment.lifecycle
) {
    private val fragmentContent = arrayListOf<Fragment>()

    fun addListFrament(fragment: Fragment) {
        fragmentContent.add(fragment)
    }

    override fun getItemCount(): Int {
        return fragmentContent.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentContent[position]
    }


}