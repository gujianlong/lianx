package com.example.week2.api;
/*
 *@auther:谷建龙
 *@Date: 2020/1/4
 *@Time:9:35
 *@Description:
 * */


import com.example.week2.bean.ItemBean;
import com.example.week2.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("commodity/v1/findCategory")
    Observable<UserBean> getInfoNo();

    @GET("commodity/v1/findCommodityByCategory")
    Observable<ItemBean> getInfoParams(@Query("categoryId") String categoryId, @Query("page") int page, @Query("count") int count);

}
