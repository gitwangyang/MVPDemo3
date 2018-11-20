package com.dotawang.mvpdemo3.login.presenter;

import android.os.Bundle;

import com.dotawang.mvpdemo3.base.BaseMvpPresenter;
import com.dotawang.mvpdemo3.login.view.LoginView;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class LoginPresenterImpl extends BaseMvpPresenter<LoginView> implements LoginPresenter {
    @Override
    public void requestContent() {
        if (isViewAttached()) {
            getView().setContent();
        }
    }

    @Override
    public void onMvpAttachView(LoginView view, Bundle savedInstanceState) {
        super.onMvpAttachView(view, savedInstanceState);
    }

    /**
     * 重写P层需要的生命周期，进行相关逻辑操作
     */
    @Override
    public void onMvpResume() {
        super.onMvpResume();
    }
}