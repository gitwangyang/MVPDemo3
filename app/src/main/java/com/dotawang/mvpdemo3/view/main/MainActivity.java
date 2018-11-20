package com.dotawang.mvpdemo3.view.main;

import android.util.Log;

import com.dotawang.mvpdemo3.R;
import com.dotawang.mvpdemo3.base.BaseMvpActivity;
import com.dotawang.mvpdemo3.presenter.main.MainPresenter;
import com.dotawang.mvpdemo3.presenter.main.MainPresenterImpl;
import com.dotawang.mvpdemo3.view.main.MainView;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainView {

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenterImpl();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onPrepare() {
        if (null!= presenter){
            presenter.requestContent();
        }
    }

    @Override
    public void setContent() {
        Log.i(getClass().getSimpleName(), "Main测试成功");
    }

}
