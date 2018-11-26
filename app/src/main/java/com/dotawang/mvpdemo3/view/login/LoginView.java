package com.dotawang.mvpdemo3.view.login;

import com.dotawang.mvpdemo3.base.MvpView;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public interface LoginView<T> extends MvpView<T> {

    String getUserName();

    String getPassword();

    /**
     * 登录请求失败
     */
    void onRequestFailureData();

}