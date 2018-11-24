package com.dotawang.mvpdemo3.view.login;

import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Button;

import com.dotawang.mvpdemo3.R;
import com.dotawang.mvpdemo3.base.BaseMvpActivity;
import com.dotawang.mvpdemo3.base.BaseMvpPresenter;
import com.dotawang.mvpdemo3.model.login.User;
import com.dotawang.mvpdemo3.presenter.login.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginView {
    @BindView(R.id.et_user_name)
    TextInputEditText etUserName;
    @BindView(R.id.et_password)
    TextInputEditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
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
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        moveTaskToBack(true);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onRequestSuccessData(User data) {
        presenter.toMainActivity(this);
    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        if (TextUtils.isEmpty(getUserName())) {
            etPassword.setError("用户名不能为空");
            return;
        }
        if (TextUtils.isEmpty(getPassword())) {
            etPassword.setError("密码不能为空");
            return;
        }
        presenter.getUserData(this);
    }
}
