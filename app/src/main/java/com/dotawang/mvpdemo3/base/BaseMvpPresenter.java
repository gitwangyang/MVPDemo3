package com.dotawang.mvpdemo3.base;

import android.os.Bundle;

import java.lang.ref.WeakReference;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description Presenter生命周期包装、View的绑定和解除，P层实现的基类
 */
public class BaseMvpPresenter<V extends MvpView>{

    private WeakReference<V> viewRef;

    protected V getView(){
        return viewRef.get();
    }

    protected boolean isViewAttached(){
        return null!= viewRef && null!= viewRef.get();
    }

    protected void attach(V view) {
        viewRef = new WeakReference<V>(view);
    }

    protected void detach() {
        if (null!= viewRef) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
