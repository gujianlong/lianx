package com.example.zuoye.api;
/*
 *@auther:谷建龙
 *@Date: 2020/2/13
 *@Time:14:10
 *@Description:
 * */


import com.example.zuoye.bean.BeingBean;
import com.example.zuoye.bean.TwoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {


    @GET("movie/coming_soon.json")
    Observable<BeingBean> getDataOne();

    @GET("movie/in_theaters.json")
    Observable<TwoBean> getDataTwo();
}
