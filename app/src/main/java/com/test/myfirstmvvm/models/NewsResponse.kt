package com.test.myfirstmvvm.models

import com.test.myfirstmvvm.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)