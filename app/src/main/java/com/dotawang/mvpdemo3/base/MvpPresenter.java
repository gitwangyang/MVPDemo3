package com.dotawang.mvpdemo3.base;

import android.os.Bundle;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description 定义P层生命周期与V层同步
 */
public interface MvpPresenter<V extends MvpView> {
    void onMvpAttachView(V view, Bundle savedInstanceState);

    void onMvpStart();

    void onMvpResume();

    void onMvpPause();

    void onMvpStop();

    void onMvpSaveInstanceState(Bundle savedInstanceState);

    void onMvpDetachView(boolean retainInstance);

    void onMvpDestroy();
}
