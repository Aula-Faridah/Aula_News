package com.bcas.aula_news.presentation.newsus_screen.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bcas.aula_news.base.BaseFragment
import com.bcas.aula_news.data.response_model.Article
import com.bcas.aula_news.databinding.FragmentNewsUsBinding
import com.bcas.aula_news.presentation.newsde_screen.adapter.NewsDeAdapter
import com.bcas.aula_news.presentation.newsid_screen.view.NewsIdActivity
import com.bcas.aula_news.presentation.newsus_screen.adapter.NewsUsAdapter
import com.bcas.aula_news.presentation.newsus_screen.viewmodel.NewsUsViewModel
import com.bcas.aula_news.utils.NewsItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsUsFragment: BaseFragment<FragmentNewsUsBinding>(), NewsItemClickListener {

    private val viewModel: NewsUsViewModel by viewModels()

    private lateinit var newsUsAdapter: NewsUsAdapter
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNewsUsBinding {
        return FragmentNewsUsBinding.inflate(inflater,container, false)
    }

    override fun setUpView() {
        observeViewModel()
        viewModel.getNewsUs()
    }

    private fun observeViewModel() {
        viewModel.newsUs.observe(viewLifecycleOwner) {
            setUpViewNewsUs(it.articles)
        }
    }

    private fun setUpViewNewsUs(data: List<Article>?) {

        newsUsAdapter = NewsUsAdapter(
            data = data ?: listOf(),
            context = binding.root.context,
            newsItemClickListener = this
        )

        binding.componentNewsUs.rvContent.adapter = newsUsAdapter
    }

    override fun onNewsItemClick(url: String) {
        val intent = Intent(requireContext(), NewsUsActivity::class.java)
        intent.putExtra("url", url)
        startActivity(intent)    }

}