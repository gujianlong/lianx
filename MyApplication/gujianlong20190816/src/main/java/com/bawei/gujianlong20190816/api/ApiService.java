package com.bawei.gujianlong20190816.api;
/*
 *@auther:谷建龙
 *@Date: 2019/12/16
 *@Time:9:07
 *@Description:
 * */


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Observable<ResponseBody> getInfoParams(@Url String url, @QueryMap Map<String, Object> map);

    @POST
    Observable<ResponseBody> postInfoParams(@Url String url, @QueryMap Map<String, Object> map);
}
