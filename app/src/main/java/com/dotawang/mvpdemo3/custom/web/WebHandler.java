package com.dotawang.mvpdemo3.custom.web;

import android.os.Handler;

/**
 * @author Android-汪洋
 * @Date 2018/11/22
 * @Description Webview的消息处理器
 */
public class WebHandler extends Handler {

    /**当前是否是错误页面*/
    private boolean isReceiveError;
    private String backUrlString;

    public boolean isReceiveError() {
        return isReceiveError;
    }

    public void setReceiveError(boolean receiveError) {
        isReceiveError = receiveError;
    }

    public String getBackUrlString() {
        return backUrlString;
    }

    public void setBackUrlString(String backUrlString) {
        this.backUrlString = backUrlString;
    }
}
