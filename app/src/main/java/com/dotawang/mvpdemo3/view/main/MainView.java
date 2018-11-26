package com.dotawang.mvpdemo3.view.main;

import com.dotawang.mvpdemo3.base.MvpView;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public interface MainView<T> extends MvpView<T> {

    /**
     * 请求失败
     * @param t
     */
    void getArticleDataFailure(Throwable t);

    //测试无请求时的功能
    void getArticleDataFailure();

}