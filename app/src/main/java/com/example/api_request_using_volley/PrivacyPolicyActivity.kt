package com.example.api_request_using_volley

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class PrivacyPolicyActivity : AppCompatActivity(){
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true // Enable JavaScript if needed
        webView.webViewClient = WebViewClient()

        // Load the privacy_policy.html file from the assets folder
        webView.loadUrl("www.google.com")
    }
}