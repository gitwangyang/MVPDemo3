package com.dotawang.mvpdemo3.custom.web;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;

import com.dotawang.mvpdemo3.constant.ConstantValues;

/**
 * @author Android-汪洋
 * @Date 2018/11/22
 * @Description 1、获取原生界面进行跳转操作 2、获取原生界面返回 3、获取原生和h5交互的数据来回传递
 */
public class HtmlJsWithNative extends BaseJsInterface {
    private Activity mActivity;

    public HtmlJsWithNative(Activity activity) {
        mActivity = activity;
    }

    //返回退出
    @JavascriptInterface
    public void backToPage() {
        mActivity.finish();
    }

    //H5调原生方法获取手机号
    @JavascriptInterface
    public String phoneToWeb() {
        return getTel();
    }

    /**
     * 获取激活手机号
     * @return
     */
    private String getTel() {
        String phone = ConstantValues.tel_phone;
        return TextUtils.isEmpty(phone)? null:phone;
    }

}
