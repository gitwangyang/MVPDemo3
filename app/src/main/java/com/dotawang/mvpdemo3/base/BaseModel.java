package com.dotawang.mvpdemo3.base;

import android.text.TextUtils;
import android.util.Log;

import com.dotawang.mvpdemo3.constant.APIService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public class BaseModel extends BaseRetrofit {
    private static final String TAG = "BaseModel";

    protected APIService mServletApi;   //所有的注解接口

    protected Map<String, String> mParams = new HashMap<>();

    public BaseModel() {
        super();
        mServletApi = mRetrofit.create(APIService.class);
    }

    //获取公共参数
    @Override
    protected Map<String, String> getCommonMap() {
        Map<String, String> commonMap = new HashMap<>();
//        commonMap.put("user_id", String.valueOf(UserDao.getInstance().getUserId()));
//        commonMap.put("token", String.valueOf(UserDao.getInstance().getToken()));
        return commonMap;
    }

    //添加一个参数
    protected void addParams(String key, String value) {
        if (TextUtils.isEmpty(key)) {
            Log.e(TAG, "the key is null");
            return;
        }
        mParams.put(key, value);
    }

    //添加多个参数
    protected void addParams(Map<String, String> params) {
        if (null == params) {
            Log.e(TAG, "the map is null");
            return;
        }
        mParams.putAll(params);
    }
}
