package com.dotawang.mvpdemo3.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description 如果要添加基类功能，请在{@link BaseActivity} 中添加
 */
public abstract class BaseMvpActivity<P extends MvpPresenter> extends BaseActivity implements MvpView {
    protected P presenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (null == presenter){
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        presenter.onMvpAttachView(this,savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (null!= presenter){
            presenter.onMvpStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (null!= presenter){
            presenter.onMvpResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (null!= presenter){
            presenter.onMvpPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (null!= presenter){
            presenter.onMvpStop();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (null!= presenter){
            presenter.onMvpSaveInstanceState(outState);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null!= presenter){
            presenter.onMvpDetachView(false);
            presenter.onMvpDestroy();
        }
    }

}
