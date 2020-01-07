package com.example.myapplication.api;
/*
 *@auther:谷建龙
 *@Date: 2020/1/2
 *@Time:15:51
 *@Description:
 * */


import com.example.myapplication.bean.Bean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {

    @POST
    Observable<ResponseBody> postInfo(@Url String url, @QueryMap Map<String, Object> map);

    @GET
    Observable<ResponseBody> getInfo(@Url String url);
}
