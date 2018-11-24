package com.dotawang.mvpdemo3.model.login;

import com.dotawang.mvpdemo3.base.BaseModel;
import com.dotawang.mvpdemo3.http.HttpFunction;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class LoginModel extends BaseModel{

    public static LoginModel getInstance(){
        return getPresent(LoginModel.class);
    }

    public void execute(String phone, String password, Observer<User> observer) {
        addParams("username", phone);
        addParams("password", password);
        Observable observable = mServletApi.getUserInfo(mParams).map(new HttpFunction());
        toSubscribe(observable, observer);
    }
}
