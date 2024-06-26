package com.bcas.aula_news.data.response_model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val articles: List<Article>
)

data class Article(
    @SerializedName("source")
    val source: Source,
    @SerializedName("author")
    val author: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String?, // Jika null, gunakan nullable type (?)
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String?, // Jika null, gunakan nullable type (?)
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("content")
    val content: String? // Jika null, gunakan nullable type (?)
)

data class Source(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String
)
