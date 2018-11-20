package com.dotawang.mvpdemo3.http.callback;

import android.content.Context;

import io.reactivex.disposables.Disposable;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */

public interface BaseImpl {

    boolean addDisposable(Disposable disposable);

    Context getContext();

}
