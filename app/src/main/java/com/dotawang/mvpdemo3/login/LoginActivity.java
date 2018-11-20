package com.dotawang.mvpdemo3.login;

import android.util.Log;

import com.dotawang.mvpdemo3.R;
import com.dotawang.mvpdemo3.base.BaseMvpActivity;
import com.dotawang.mvpdemo3.login.presenter.LoginPresenter;
import com.dotawang.mvpdemo3.login.presenter.LoginPresenterImpl;
import com.dotawang.mvpdemo3.login.view.LoginView;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginView {

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenterImpl();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
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
        Log.i(getClass().getSimpleName(), "Login测试成功");
    }
}
