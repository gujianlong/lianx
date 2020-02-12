package com.example.myorder.api;
/*
 *@auther:谷建龙
 *@Date: 2020/2/11
 *@Time:17:19
 *@Description:
 * */


import com.example.myorder.bean.OrderBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {
    @GET("order/verify/v1/findOrderListByStatus")
    Observable<OrderBean> getOrderData(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("status") int status, @Query("page") int page, @Query("count") int count);
}
