package com.example.gujianlong1230.api;
/*
 *@auther:谷建龙
 *@Date: 2020/1/3
 *@Time:8:50
 *@Description:
 * */


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Observable<ResponseBody> getInfoNo(@Url String url);

    @GET
    Observable<ResponseBody> getInfoParam(@Url String url, @QueryMap Map<String, Object> map);
}
