package com.bcas.aula_news.presentation.newsde_screen.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bcas.aula_news.base.BaseFragment
import com.bcas.aula_news.data.response_model.Article
import com.bcas.aula_news.databinding.FragmentNewsDeBinding
import com.bcas.aula_news.presentation.newsde_screen.adapter.NewsDeAdapter
import com.bcas.aula_news.presentation.newsde_screen.viewmodel.NewsDeViewModel
import com.bcas.aula_news.presentation.newsid_screen.adapter.NewsIdAdapter
import com.bcas.aula_news.presentation.newsid_screen.view.NewsIdActivity
import com.bcas.aula_news.utils.NewsItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDeFragment:BaseFragment<FragmentNewsDeBinding>(), NewsItemClickListener {

    private val viewModel: NewsDeViewModel by viewModels()

    private lateinit var newsDeAdapter: NewsDeAdapter
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNewsDeBinding {
        return FragmentNewsDeBinding.inflate(inflater,container,false)
    }

    override fun setUpView() {
        observeViewModel()
        viewModel.getNewsDe()
    }

    private fun observeViewModel() {
        viewModel.newsDe.observe(viewLifecycleOwner) {
            setUpViewNewsId(it.articles)
        }
    }

    private fun setUpViewNewsId(data: List<Article>?) {

        newsDeAdapter = NewsDeAdapter(
            data = data ?: listOf(),
            context = binding.root.context,
            newsItemClickListener = this
        )

        binding.componentNewsDe.rvContent.adapter = newsDeAdapter
    }

    override fun onNewsItemClick(url: String) {
        val intent = Intent(requireContext(), NewsIdActivity::class.java)
        intent.putExtra("url", url)
        startActivity(intent)    }

}