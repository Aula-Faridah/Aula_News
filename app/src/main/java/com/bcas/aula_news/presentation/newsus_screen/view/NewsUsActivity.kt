package com.bcas.aula_news.presentation.newsus_screen.view

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bcas.aula_news.databinding.ActivityNewsUsBinding
import dagger.hilt.android.AndroidEntryPoint

class NewsUsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsUsBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")
        webViewSetup(url)

        binding.ivBackButton.setOnClickListener {
            if (binding.wvWebView.canGoBack()) {
                binding.wvWebView.goBack()
            } else  (
                    finish()
                    )
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(url: String?){
        binding.wvWebView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.loadingProgressBar.visibility = View.VISIBLE
            }
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.loadingProgressBar.visibility = View.GONE // Hiding Progress Bar
            }
        }
        binding.wvWebView.apply {
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
        url?.let {
            binding.wvWebView.loadUrl(it)
        }
    }

}