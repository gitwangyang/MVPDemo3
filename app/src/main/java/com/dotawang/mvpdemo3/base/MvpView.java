package com.dotawang.mvpdemo3.base;


/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public interface MvpView<T> {

    /**
     * 请求成功的操作
     * @param data
     */
    void onRequestSuccessData(T data);

}
