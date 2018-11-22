package com.dotawang.mvpdemo3.custom.web;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Android-汪洋
 * @Date 2018/11/22
 * @Description 设置默认的WebViewClient和WebChromeClient, 统一注入js方法
 */
public class CustomWebView extends WebView {
    private CustomWebViewClient webViewClient;
    private CustomWebChromeClient webChromeClient;
    private WebHandler webHandler;
    private Map<String, BaseJsInterface> jsInterfaceMap = new HashMap<>();

    public CustomWebView(Context context) {
        this(context,null);
    }

    public CustomWebView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public CustomWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSettings();
    }

    private void initSettings() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        WebSettings settings = getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setSavePassword(false);
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("gb2312");
        // 设置webview本地js缓存
        settings.setDatabaseEnabled(true);
        String databasePath = getContext().getDir("database", Context.MODE_PRIVATE).getPath();
        settings.setDatabasePath(databasePath);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheMaxSize(1024 * 1024 * 8);
        String appCachePath = getContext().getCacheDir().getAbsolutePath();
        settings.setAppCachePath(appCachePath);
        settings.setSaveFormData(false);
        settings.setSupportZoom(false);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(true);
        webViewClient = new CustomWebViewClient(this);
        webChromeClient = new CustomWebChromeClient(this);
        setWebViewClient(webViewClient);
        setWebChromeClient(webChromeClient);
        addJavaInterfaces();
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    private void addJavaInterfaces() {
        jsInterfaceMap.put("web", new BackJsWithNative(this));
        jsInterfaceMap.put("tel", new GetTelJsWithNative());
        jsInterfaceMap.put("ServiceJsObj", new HtmlJsWithNative((Activity) getContext()));
//        jsInterfaceMap.put("toBindAccount", new ToBindAccountActivity(getContext()));

        for (String key: jsInterfaceMap.keySet()) {
            BaseJsInterface ji = jsInterfaceMap.get(key);
            if (ji != null) {
                addJavascriptInterface(ji, key);
            }
        }
    }

    @Override
    public CustomWebViewClient getWebViewClient() {
        return webViewClient;
    }

    @Override
    public CustomWebChromeClient getWebChromeClient() {
        return webChromeClient;
    }

    public void setWebHandler(WebHandler handler) {
        this.webHandler = handler;
        webViewClient.setWebHandler(handler);
        for (String key: jsInterfaceMap.keySet()) {
            BaseJsInterface ji = jsInterfaceMap.get(key);
            if (ji != null) {
                ji.setWebHandler(handler);
            }
        }
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    @Override
    public void addJavascriptInterface(Object object, String name) {
        super.addJavascriptInterface(object, name);
        if (object instanceof BaseJsInterface) {
            ((BaseJsInterface) object).setWebHandler(webHandler);
        }
    }

}
