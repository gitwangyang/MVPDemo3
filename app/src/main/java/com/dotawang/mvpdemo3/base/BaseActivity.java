package com.dotawang.mvpdemo3.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dotawang.mvpdemo3.http.callback.BaseImpl;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description 最底层封装，可添加所有Activity的基类功能方法
 */
public abstract class BaseActivity<P extends BaseMvpPresenter> extends AppCompatActivity implements BaseImpl {

    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null == mCompositeDisposable) {
            mCompositeDisposable = new CompositeDisposable();
        }
        setContentView(getLayout());
        ButterKnife.bind(this);
        initView();
        onPrepare();
    }

    /**
     * @return layout布局
     */
    protected abstract int getLayout();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 处理adapter的创建以及数据请求发送
     */
    protected abstract void onPrepare();

    @Override
    public boolean addDisposable(Disposable disposable) {
        if (null != mCompositeDisposable) {
            mCompositeDisposable.add(disposable);
        }
        return true;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mCompositeDisposable) {
            mCompositeDisposable.clear();
        }
    }
}
