package com.dotawang.mvpdemo3.model.login;

import com.dotawang.mvpdemo3.greendao.BaseGreenDao;
import com.dotawang.mvpdemo3.greendao.bean.UserInfo;

import java.util.List;

/**
 * @author Dota.Wang
 * @date 2018/11/20
 * @description
 */

public class UserDao extends BaseGreenDao<UserInfo> {
    private static final String TAG = "UserDao";

    private UserDao() {

    }

    private static class Singleton {
        private static UserDao mInstance = new UserDao();
    }

    public static UserDao getInstance() {
        return Singleton.mInstance;
    }

    public boolean isHaveUser() {
        if (getUserId() != -1) {
            return true;
        }
        return false;
    }

    public UserInfo getUserInfo() {
        List<UserInfo> userInfoList = queryAll(UserInfo.class);
        if (null != userInfoList && userInfoList.size() > 0) {
            return userInfoList.get(0);
        }
        return null;
    }

    public long getUserId() {
        if (null != getUserInfo()) {
            return getUserInfo().getId();
        }
        return -1;
    }

    public String getToken() {
        if (null != getUserInfo()) {
            return getUserInfo().getToken();
        }
        return "";
    }
}
