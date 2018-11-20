package com.dotawang.mvpdemo3;


import com.dotawang.mvpdemo3.constant.HttpServletAddress;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpServletAddress.getInstance().setOfflineAddress("http://192.168.31.250:8080/FriendCircle/");
    }

}
