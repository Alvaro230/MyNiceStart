package com.example.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity3 extends AppCompatActivity {
    private WebView miweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        miweb = findViewById(R.id.webview);
        WebSettings webSettings = miweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        miweb.loadUrl("https://console.dialogflow.com/api-client/demo/embedded/cf9c6443-79f6-4c49-8a6e-88c4c9409482");
    }
}