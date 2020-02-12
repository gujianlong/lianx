package com.example.zuoye5.api;
/*
 *@auther:谷建龙
 *@Date: 2020/1/15
 *@Time:10:26
 *@Description:
 * */



import com.example.zuoye5.bean.CartBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @GET("order/verify/v1/findShoppingCart")
    Observable<CartBean> getInfoCart(@Header("userId") String userId, @Header("sessionId") String sessionId);

}
