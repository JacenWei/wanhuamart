package com.wanhua.wanhuamarket.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wanhua.wanhuamarket.R;
import com.wanhua.wanhuamarket.base.BaseFragment;


public class NearFragment extends BaseFragment {

    @Override
    public int setView() {
        return R.layout.fragment_near;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initView(View view) {
        WebView webView = view.findViewById(R.id.webview_near);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });
        webView.loadUrl("file:///android_asset/product_list.html");
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

}
