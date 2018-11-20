package com.dotawang.mvpdemo3.login.presenter;

import com.dotawang.mvpdemo3.base.MvpPresenter;
import com.dotawang.mvpdemo3.login.view.LoginView;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public interface LoginPresenter extends MvpPresenter<LoginView> {
    void requestContent();
}
