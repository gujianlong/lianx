package com.example.mycart.api;
/*
 *@auther:谷建龙
 *@Date: 2020/2/5
 *@Time:15:06
 *@Description:
 * */


import com.example.mycart.bean.CartBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiServier {
    @GET("order/verify/v1/findShoppingCart")
    Observable<CartBean> getDataCart(@Header("userId") int userId, @Header("sessionId") String sessionId);

}
