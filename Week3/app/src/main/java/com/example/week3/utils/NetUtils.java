package com.example.week3.utils;
/*
 *@auther:谷建龙
 *@Date: 2020/1/11
 *@Time:10:42
 *@Description:
 * */


import com.example.week3.api.ApiService;
import com.example.week3.app.MyApp;
import com.example.week3.url.Myurl;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetUtils {

    private final ApiService apiService;

    public NetUtils() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Myurl.BeanUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }
    private static class net{
        private static NetUtils netUtils=new NetUtils();
    }

    public static NetUtils getInstance() {
        return net.netUtils;
    }

    public ApiService getApiService() {
        return apiService;
    }
}
