package com.bcas.aula_news.presentation.newsus_screen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bcas.aula_news.R
import com.bcas.aula_news.data.response_model.Article
import com.bcas.aula_news.databinding.ItemNewsBinding
import com.bcas.aula_news.utils.NewsItemClickListener
import com.bumptech.glide.Glide

class NewsUsAdapter(
    private val context: Context,
    private val data: List<Article>,
    private val newsItemClickListener: NewsItemClickListener
) : RecyclerView.Adapter<NewsUsAdapter.NewsUsViewHolder>() {
    inner class NewsUsViewHolder(
        val binding: ItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Article) {
            Glide.with(context)
                .load(data.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.mingcute__loading_fill) // Placeholder image while loading
                .error(R.drawable.bx__error) // Error image if loading fails
                .into(binding.ivNews)

            binding.tvTitleNews.text = data.title
            binding.tvClick.setOnClickListener {
                newsItemClickListener.onNewsItemClick(data.url)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsUsViewHolder {
        return NewsUsViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: NewsUsViewHolder, position: Int) {
        holder.bind(data[position])
    }
}