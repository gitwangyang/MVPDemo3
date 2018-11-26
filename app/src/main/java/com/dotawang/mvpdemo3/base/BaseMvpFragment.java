package com.dotawang.mvpdemo3.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Dota.Wang
 * @date 2018/11/25
 * @description
 */

public abstract class BaseMvpFragment<P extends BaseMvpPresenter> extends Fragment {

    protected P presenter;

    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";

    //定义一个View用来保存Fragment创建的时候使用打气筒工具进行的布局获取对象的存储
    protected View view;

    /**
     * 创建Presenter对象
     */
    protected abstract P createPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }
    /**
     * 这个方法是关于Fragment完成创建的过程中，进行界面填充的方法,该方法返回的是一个view对象
     * 在这个对象中封装的就是Fragment对应的布局
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == view){
            view = inflater.inflate(layoutRes(),null);
            onViewReallyCreated();
        }else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (null != parent){
                parent.removeView(view);
            }
        }
        return view;
    }

    /**
     * 这个方法当onCreateView方法中的view创建完成之后，执行
     * 在inflate完成view的创建之后，可以将对应view中的各个控件进行查找findViewById
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initFragmentChildView(view);
    }

    /**
     * 这个方法是在Fragment完成创建操作之后，进行数据填充操作的时候执行的方法
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragmentData(savedInstanceState);
    }

    /**
     * 完成打气筒操作 添加布局layout
     * @param
     */
    protected abstract int layoutRes();

    /**
     * 实时创建View
     */
    protected abstract void onViewReallyCreated();

    /**
     * 进行findViewById的操作
     * @param view 打气筒生成的View对象
     */
    protected abstract void initFragmentChildView(View view);

    /**
     * 网络数据填充的操作
     * @param savedInstanceState
     */
    protected abstract void initFragmentData(Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != presenter){
            presenter.detach();
        }
    }
}
