package com.example.week.api;
/*
 *@auther:谷建龙
 *@Date: 2020/1/3
 *@Time:8:50
 *@Description:
 * */


import com.example.week.bean.ItemBean;
import com.example.week.bean.UserBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {
    @GET("commodity/v1/findCategory")
    Observable<UserBean> getInfoNo();

    @GET("commodity/v1/findCommodityByCategory")
    Observable<ItemBean> getInfoParams(@Query("categoryId") String categoryId, @Query("page") int page, @Query("count") int count);
}
