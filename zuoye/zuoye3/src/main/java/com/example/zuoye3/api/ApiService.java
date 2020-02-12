package com.example.zuoye3.api;
/*
 *@auther:谷建龙
 *@Date: 2020/1/22
 *@Time:15:11
 *@Description:
 * */


import com.example.zuoye3.bean.OrderBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {
    @GET("order/verify/v1/findOrderListByStatus")
    Observable<OrderBean> getInfo(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("status") int status, @Query("page") int page, @Query("count") int count);
}
