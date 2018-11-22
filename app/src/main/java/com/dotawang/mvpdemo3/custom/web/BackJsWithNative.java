package com.dotawang.mvpdemo3.custom.web;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/**
 * @author Android-汪洋
 * @Date 2018/11/22
 * @Description 获取返回键-实现js交互
 */
public class BackJsWithNative extends BaseJsInterface {
    private Activity activity;

    public BackJsWithNative(WebView webView) {
        activity = (Activity) webView.getContext();
    }

    @JavascriptInterface
    public void backToPage() {
        activity.finish();
    }


}
