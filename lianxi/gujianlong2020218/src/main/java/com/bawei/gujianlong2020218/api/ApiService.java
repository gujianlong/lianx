package com.bawei.gujianlong2020218.api;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:9:34
 *@Description:
 * */


import com.bawei.gujianlong2020218.bean.OrderBean;
import com.bawei.gujianlong2020218.bean.ShowBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {
    @GET("commodity/v1/findCommodityByKeyword")
    Observable<ShowBean> getShowData(@Query("keyword") String keyword, @Query("page") int page, @Query("count") int count);

    @GET("order/verify/v1/findOrderListByStatus")
    Observable<OrderBean> getOrderData(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("status") int status, @Query("page") int page, @Query("count") int count);
}
