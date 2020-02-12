package com.example.zuoye1.api;
/*
 *@auther:谷建龙
 *@Date: 2020/1/15
 *@Time:10:26
 *@Description:
 * */


import com.example.zuoye1.bean.CartBean;
import com.example.zuoye1.bean.LoginBean;
import com.example.zuoye1.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("user/v1/register")
    Observable<RegisterBean> postInfoRegister(@Field("phone") String phone, @Field("pwd") String pwd);

    @FormUrlEncoded
    @POST("user/v1/login")
    Observable<LoginBean> postInfoLogin(@Field("phone") String phone, @Field("pwd") String pwd);

    @GET("order/verify/v1/findShoppingCart")
    Observable<CartBean> getInfoCart(@Header("userId") String userId, @Header("sessionId") String sessionId);

}
