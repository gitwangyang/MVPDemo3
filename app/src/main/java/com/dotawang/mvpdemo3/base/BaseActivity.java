package com.dotawang.mvpdemo3.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public abstract class BaseActivity<P extends MvpPresenter> extends AppCompatActivity {

//    protected P basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
//        basePresenter = initPresenter();
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
     * @return new 当前Activity对应的Presenter
     */
//    protected abstract P initPresenter();

    /**
     * 处理adapter的创建以及数据请求发送
     */
    protected abstract void onPrepare();
}
