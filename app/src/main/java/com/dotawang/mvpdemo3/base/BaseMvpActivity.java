package com.dotawang.mvpdemo3.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dotawang.mvpdemo3.http.callback.BaseImpl;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description 如果要添加基类功能，请在{@link BaseActivity} 中添加;Activity都继承该类
 */
public abstract class BaseMvpActivity<P extends BaseMvpPresenter> extends BaseActivity{
    protected P presenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();

        if (null == presenter){
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != presenter){
            presenter.detach();
        }
    }
}
