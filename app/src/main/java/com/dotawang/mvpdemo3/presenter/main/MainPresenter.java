package com.dotawang.mvpdemo3.presenter.main;


import com.dotawang.mvpdemo3.base.MvpPresenter;
import com.dotawang.mvpdemo3.view.main.MainView;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public interface MainPresenter extends MvpPresenter<MainView> {
    void requestContent();

}
