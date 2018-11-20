package com.dotawang.mvpdemo3.constant;

import android.text.TextUtils;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description 不同环境的配置
 */
public class HttpServletAddress {

    private String onlineAddress;   //线上地址
    private String offlineAddress;  //线下地址

    private static final class SingletonHolder {
        private static final HttpServletAddress INSTANCE = new HttpServletAddress();
    }

    public static HttpServletAddress getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private HttpServletAddress() {
    }

    public String getOnlineAddress() {
        return onlineAddress;
    }

    public void setOnlineAddress(String onlineAddress) {
        this.onlineAddress = onlineAddress;
    }

    public String getOfflineAddress() {
        return offlineAddress;
    }

    public void setOfflineAddress(String offlineAddress) {
        this.offlineAddress = offlineAddress;
    }

    public String getServletAddress() {
        return TextUtils.isEmpty(onlineAddress) ? offlineAddress : onlineAddress;
    }
}
