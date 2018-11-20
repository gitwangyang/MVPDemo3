package com.dotawang.mvpdemo3.presenter.main;

import android.os.Bundle;

import com.dotawang.mvpdemo3.base.BaseMvpPresenter;
import com.dotawang.mvpdemo3.view.main.MainView;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class MainPresenterImpl extends BaseMvpPresenter<MainView> implements MainPresenter {
    @Override
    public void requestContent() {
        if (isViewAttached()) {
            getView().setContent();
        }
    }

    @Override
    public void onMvpAttachView(MainView view, Bundle savedInstanceState) {
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
