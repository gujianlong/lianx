package com.example.myapplication2.api;
/*
 *@auther:谷建龙
 *@Date: 2020/2/26
 *@Time:16:36
 *@Description:
 * */


import com.example.myapplication2.bean.LoginBean;
import com.example.myapplication2.bean.RegBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("user/v1/login")
    Observable<LoginBean> getDataLogin(@Field("phone") String phone, @Field("pwd") String pwd);

    @FormUrlEncoded
    @POST("user/v1/register")
    Observable<RegBean> getDataReg(@Field("phone") String phone, @Field("pwd") String pwd);
}
