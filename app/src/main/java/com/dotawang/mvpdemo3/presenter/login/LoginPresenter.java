package com.dotawang.mvpdemo3.presenter.login;

import android.content.Context;
import android.content.Intent;

import com.dotawang.mvpdemo3.base.BaseMvpPresenter;
import com.dotawang.mvpdemo3.greendao.bean.UserInfo;
import com.dotawang.mvpdemo3.http.callback.BaseImpl;
import com.dotawang.mvpdemo3.http.callback.CygBaseObserver;
import com.dotawang.mvpdemo3.model.login.LoginModel;
import com.dotawang.mvpdemo3.model.login.User;
import com.dotawang.mvpdemo3.model.login.UserDao;
import com.dotawang.mvpdemo3.view.login.LoginView;
import com.dotawang.mvpdemo3.view.main.MainActivity;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class LoginPresenter extends BaseMvpPresenter<LoginView<User>> {
    public LoginPresenter(LoginView<User> loginView) {
        attach(loginView);
    }

    public void getUserData(BaseImpl baseImpl){
//        LoginModel.getInstance().execute(getView().getUserName(), getView().getPassword(), new CygBaseObserver<User>() {
//            @Override
//            protected void onBaseNext(User data) {
//                UserInfo userInfo = new UserInfo();
//                userInfo.setId(data.getId());
//                userInfo.setToken(data.getToken());
//                userInfo.setUsername(getView().getUserName());
//
//                UserDao.getInstance().deleteAll(UserInfo.class);
//                UserDao.getInstance().insertObject(userInfo);
//                getView().onRequestSuccessData(data);
//            }
//        });
        getView().onRequestFailureData();
    }

    public void toMainActivity(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
