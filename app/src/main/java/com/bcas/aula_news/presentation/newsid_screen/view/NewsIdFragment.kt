package com.bcas.aula_news.presentation.newsid_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bcas.aula_news.base.BaseFragment
import com.bcas.aula_news.data.response_model.Article
import com.bcas.aula_news.data.response_model.NewsResponse
import com.bcas.aula_news.databinding.FragmentNewsIdBinding
import com.bcas.aula_news.presentation.newsid_screen.adapter.NewsIdAdapter
import com.bcas.aula_news.presentation.newsid_screen.viewmodel.NewsIdViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsIdFragment: BaseFragment<FragmentNewsIdBinding>() {

    private val viewModel: NewsIdViewModel by viewModels()

    private lateinit var newsIdAdapter: NewsIdAdapter
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNewsIdBinding {
        return FragmentNewsIdBinding.inflate(inflater,container,false)
    }

    override fun setUpView() {
        observeViewModel()
        viewModel.getNewsId()
    }

    private fun observeViewModel() {
        viewModel.newsId.observe(viewLifecycleOwner){
            setUpViewNewsId(it.articles)
        }
    }
    private fun setUpViewNewsId(data: List<Article>?) {

        newsIdAdapter = NewsIdAdapter(
            data = data ?: listOf(),
            context = binding.root.context
        )

        binding.componentNewsId.rvContent.adapter = newsIdAdapter
    }

}