package com.example.lianxi2.api;
/*
 *@auther:谷建龙
 *@Date: 2020/2/13
 *@Time:14:10
 *@Description:
 * */


import com.example.lianxi2.bean.LoginBean;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.RegBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @FormUrlEncoded
    @POST("user/v1/register")
    Observable<RegBean> getReg(@Field("phone") String phone, @Field("pwd") String pwd);

    @FormUrlEncoded
    @POST("user/v1/login")
    Observable<LoginBean> getLogin(@Field("phone") String phone, @Field("pwd") String pwd);

    @GET("order/verify/v1/findOrderListByStatus")
    Observable<OrderBean> getDataOrder(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("status") int status, @Query("page") int page, @Query("count") int count);
}
