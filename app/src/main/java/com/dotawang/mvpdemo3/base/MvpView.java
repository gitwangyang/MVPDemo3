package com.dotawang.mvpdemo3.base;

import com.dotawang.mvpdemo3.model.login.User;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public interface MvpView {

    void onRequestSuccessData(User data);
}
