package com.dotawang.mvpdemo3.utils;

/**
 * @author Android-汪洋
 * @Date 2017/5/11
 * @Description
 */

public class ResponseThrowable extends Exception {
    public int code;
    public String message;

    public ResponseThrowable(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }
}
