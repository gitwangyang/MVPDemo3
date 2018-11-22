package com.dotawang.mvpdemo3.custom.web;

/**
 * @author Android-汪洋
 * @Date 2018/11/22
 * @Description JS interface的基类, 所有使用@JsInterface的类继承此类
 */
public class BaseJsInterface {
    protected WebHandler webHandler;

    public void setWebHandler(WebHandler webHandler) {
        this.webHandler = webHandler;
    }

    public WebHandler getWebHandler() {
        return webHandler;
    }
}
