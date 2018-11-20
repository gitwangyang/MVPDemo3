package com.dotawang.mvpdemo3.main.presenter;


import com.dotawang.mvpdemo3.base.MvpPresenter;
import com.dotawang.mvpdemo3.main.view.MainView;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public interface MainPresenter extends MvpPresenter<MainView> {
    void requestContent();

}
