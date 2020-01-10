package com.example.lianxi2.api;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:8:58
 *@Description:
 * */


import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface ApiService {

    @GET("order/verify/v1/findShoppingCart")
    Observable<UserBean> getInfoParams(@Header("userId") String userId, @Header("sessionId") String sessionId);

    @GET("order/verify/v1/findOrderListByStatus")
    Observable<OrderBean> getInfoParamsOrder(@Header("userId") String userId, @Header("sessionId") String sessionId,
                                             @Query("count") int count, @Query("page") int page, @Query("status") int status);
}
