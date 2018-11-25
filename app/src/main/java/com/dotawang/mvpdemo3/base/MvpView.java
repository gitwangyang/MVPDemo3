package com.dotawang.mvpdemo3.base;

import com.dotawang.mvpdemo3.model.login.User;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public interface MvpView {

    /**
     * 请求成功的操作
     * @param data
     */
    void onRequestSuccessData(User data);

    /**
     * 请求失败的操作
     */
    void onRequestFailureData();
}
