package com.dotawang.mvpdemo3.base;

import android.os.Bundle;

import java.lang.ref.WeakReference;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description Presenter生命周期包装、View的绑定和解除，P层实现的基类
 */
public class BaseMvpPresenter<V extends MvpView> implements MvpPresenter<V> {

    private WeakReference<V> viewRef;

    protected V getView(){
        return viewRef.get();
    }

    protected boolean isViewAttached(){
        return null!= viewRef && null!= viewRef.get();
    }

    private void attach(V view, Bundle savedInstanceState) {
        viewRef = new WeakReference<V>(view);
    }

    @Override
    public void onMvpAttachView(V view, Bundle savedInstanceState) {
        attach(view,savedInstanceState);
    }

    @Override
    public void onMvpStart() {

    }

    @Override
    public void onMvpResume() {

    }

    @Override
    public void onMvpPause() {

    }

    @Override
    public void onMvpStop() {

    }

    @Override
    public void onMvpSaveInstanceState(Bundle savedInstanceState) {

    }

    private void detach(boolean retainInstance) {
        if (null!= viewRef) {
            viewRef.clear();
            viewRef = null;
        }
    }

    @Override
    public void onMvpDetachView(boolean retainInstance) {
        detach(retainInstance);
    }

    @Override
    public void onMvpDestroy() {

    }
}
