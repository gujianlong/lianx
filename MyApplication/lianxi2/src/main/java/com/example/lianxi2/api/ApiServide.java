package com.example.lianxi2.api;
/*
 *@auther:谷建龙
 *@Date: 2019/12/18
 *@Time:14:33
 *@Description:
 * */


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiServide {
    @GET
    Observable<ResponseBody> getInfoNotParams(@Url String url);

    @POST
    Observable<ResponseBody> postInfoParams(@Url String url, @QueryMap Map<String, Object> map);
}
