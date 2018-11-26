package com.dotawang.mvpdemo3.constant;

import com.dotawang.mvpdemo3.http.BaseResponse;
import com.dotawang.mvpdemo3.model.login.User;
import com.dotawang.mvpdemo3.model.main.MainInfo;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author Android-汪洋
 * @Date 2018/11/20
 * @Description
 */
public interface APIService {
    @FormUrlEncoded
    @POST("LoginServlet")
    Observable<BaseResponse<User>> getUserInfo(@FieldMap Map<String, String> params);


    @FormUrlEncoded
    @POST("MainServlet")
    Observable<BaseResponse<List<MainInfo>>> getArticle(@FieldMap Map<String, String> params);
}
