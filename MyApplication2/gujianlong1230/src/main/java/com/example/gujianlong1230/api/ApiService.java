package com.example.gujianlong1230.api;
/*
 *@auther:谷建龙
 *@Date: 2020/1/3
 *@Time:8:50
 *@Description:
 * */


import com.example.gujianlong1230.adabter.HomeAdapter;
import com.example.gujianlong1230.bean.BannerBean;
import com.example.gujianlong1230.bean.CartBean;
import com.example.gujianlong1230.bean.DingBean;
import com.example.gujianlong1230.bean.OrderBean;
import com.example.gujianlong1230.bean.UserBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {
    @GET("commodity/v1/bannerShow")
    Observable<BannerBean> getInfoBanner();

    @GET("commodity/v1/commodityList")
    Observable<UserBean> getInfoNot();


    @GET("verify/v1/findShoppingCart")
    Observable<CartBean> getInfoParam(@Header("userId") String userId, @Header("sessionId") String sessionId);

    @GET("user/verify/v1/receiveAddressList")
    Observable<DingBean> getInfoParamDing(@Header("userId") String userId, @Header("sessionId") String sessionId);

    @GET("order/verify/v1/findOrderListByStatus")
    Observable<OrderBean> getInfoParamOrder(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("status") int status, @Query("page") int page, @Query("count") int count);

}
