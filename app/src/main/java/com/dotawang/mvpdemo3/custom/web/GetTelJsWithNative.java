package com.dotawang.mvpdemo3.custom.web;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;

import com.blankj.utilcode.util.StringUtils;
import com.dotawang.mvpdemo3.constant.ConstantValues;
import com.dotawang.mvpdemo3.utils.EncryptUtil;
import com.dotawang.mvpdemo3.utils.Tool;

/**
 * @author Android-汪洋
 * @Date 2018/11/22
 * @Description 获取电话拨打-实现js交互
 */
public class GetTelJsWithNative extends BaseJsInterface {

    @JavascriptInterface
    public String getTelphone() {
        //TODO  修改为sp保存的tel
        String telNum = ConstantValues.tel_phone;
        if (TextUtils.isEmpty(telNum)) {
            return "";
        } else {
            return "telphone=" + telNum;
        }
    }

    @JavascriptInterface
    public String getSign() {
        String sign = "";
        //TODO  修改为sp保存的tel
        String phone = ConstantValues.tel_phone;
        sign = EncryptUtil.getMd5Value(phone + ConstantValues.app_name + Tool.getcurrentDate());
        if (StringUtils.isTrimEmpty(sign)) {
            return "";
        } else {
            return "sign=" + sign;
        }
    }

}
