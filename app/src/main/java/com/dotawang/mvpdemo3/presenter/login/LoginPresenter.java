package com.dotawang.mvpdemo3.presenter.login;

import com.dotawang.mvpdemo3.base.MvpPresenter;
import com.dotawang.mvpdemo3.view.login.LoginView;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public interface LoginPresenter extends MvpPresenter<LoginView> {
    void requestContent();
}
