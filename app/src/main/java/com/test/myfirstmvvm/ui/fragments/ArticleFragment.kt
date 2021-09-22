package com.test.myfirstmvvm.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.test.myfirstmvvm.R
import com.test.myfirstmvvm.databinding.FragmentArticleBinding
import com.test.myfirstmvvm.ui.NewsActivity
import com.test.myfirstmvvm.ui.NewsViewModel

class ArticleFragment: Fragment(R.layout.fragment_article) {


    private var binding: FragmentArticleBinding? = null
    private var viewModel: NewsViewModel? = null
    private val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)
        viewModel = (activity as NewsActivity).viewModel


        val article = args.article
        binding!!.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        binding!!.fab.setOnClickListener{
            viewModel?.saveArticle(article)
            Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}