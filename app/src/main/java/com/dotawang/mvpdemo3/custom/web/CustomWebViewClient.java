package com.dotawang.mvpdemo3.custom.web;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dotawang.mvpdemo3.R;
import com.dotawang.mvpdemo3.custom.WebMessageId;
import com.dotawang.mvpdemo3.utils.Tool;

/**
 * @author Android-汪洋
 * @Date 2018/11/22
 * @Description 统一的webview的WebViewClient
 */
public class CustomWebViewClient extends WebViewClient {

    public static final String WEB_ERROR_URL = "file:///android_asset/web_error/netlessPrompt.html";
    private WebView webView;
    private WebHandler webHandler;

    public CustomWebViewClient(WebView webView) {
        this.webView = webView;
    }

    public WebHandler getWebHandler() {
        return webHandler;
    }

    public void setWebHandler(WebHandler webHandler) {
        this.webHandler = webHandler;
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        view.loadUrl(WEB_ERROR_URL);
        if (webHandler != null) {
            Message message = webHandler.obtainMessage();
            message.what = WebMessageId.INTELLIGENT_HEIGHT;
            message.obj = -1;
            message.sendToTarget();
            webHandler.setReceiveError(true);
        }
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        handler.proceed();
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if ("http".startsWith(url) || "https".startsWith(url)){
            ((Activity)webView.getContext()).finish();
        }else {
            view.loadUrl(url);
        }
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        Uri uri = Uri.parse(url);
        String value = null;
        try {
            value = uri.getQueryParameter("theme");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(value)){
            //状态栏颜色改变
            Tool.smartTintManager((Activity) webView.getContext(), webView.getContext().getResources().getColor(R.color.red));
        }
        super.onPageStarted(view, url, favicon);
    }

    /**
     * 重写的方法 可在嵌入webview的Activity中进行回调时用
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            webView.reload();
        } else {
            if (webHandler != null) {
                webHandler.setBackUrlString(null);
            }
        }
    }

    /**
     * 重写的onResume方法，可在嵌入webview的Activity中进行刷新页面用
     */
    public void onResume() {
        if (webHandler != null) {
            String backUrlString = webHandler.getBackUrlString();
            if (!TextUtils.isEmpty(backUrlString)) {
                webView.loadUrl(backUrlString);
            }
        }
    }

}
