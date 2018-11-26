package com.dotawang.mvpdemo3.model.main;

import com.dotawang.mvpdemo3.base.BaseModel;
import com.dotawang.mvpdemo3.http.HttpFunction;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class MainModel extends BaseModel{
    public static MainModel getInstance() {
        return getPresent(MainModel.class);
    }

    public void execute(Observer<List<MainInfo>> observer){
        Observable observable = mServletApi.getArticle(mParams).map(new HttpFunction());
        toSubscribe(observable, observer);
    }
}
