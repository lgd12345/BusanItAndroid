package com.example.ex11_webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.ex11_webview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //wepview 생성 및 설정
        binding.webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        //웹뷰로에 url 연결
        binding.webView.loadUrl("https://www.naver.com")
    }
}