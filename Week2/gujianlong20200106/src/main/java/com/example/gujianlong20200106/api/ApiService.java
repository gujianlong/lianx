package com.example.gujianlong20200106.api;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:8:58
 *@Description:
 * */


import com.example.gujianlong20200106.bean.HomeBean;
import com.example.gujianlong20200106.bean.ItemBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("category")
    Observable<HomeBean> getInfoNo();

    @GET("shopByCategory")
    Observable<ItemBean> getInfoParams(@Query("category") String category);
}
