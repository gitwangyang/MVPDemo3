package com.dotawang.mvpdemo3.presenter.main;


import com.dotawang.mvpdemo3.base.BaseMvpPresenter;
import com.dotawang.mvpdemo3.http.callback.BaseImpl;
import com.dotawang.mvpdemo3.http.callback.CygBaseObserver;
import com.dotawang.mvpdemo3.model.main.MainInfo;
import com.dotawang.mvpdemo3.model.main.MainModel;
import com.dotawang.mvpdemo3.view.main.MainView;

import java.util.List;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class MainPresenter extends BaseMvpPresenter<MainView<List<MainInfo>>> {

    public MainPresenter(MainView<List<MainInfo>> mainView) {
        attach(mainView);
    }

    public void getArticleData(BaseImpl baseImpl) {
//        MainModel.getInstance().execute(new CygBaseObserver<List<MainInfo>>(baseImpl) {
//            @Override
//            protected void onBaseNext(List<MainInfo> data) {
//                getView().onRequestSuccessData(data);
//            }
//
//            @Override
//            protected void onBaseError(Throwable t) {
//                super.onBaseError(t);
//                getView().getArticleDataFailure(t);
//            }
//        });
        getView().getArticleDataFailure();//测试无请求时的功能
    }
}
