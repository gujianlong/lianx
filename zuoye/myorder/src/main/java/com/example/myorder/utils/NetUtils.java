package com.example.myorder.utils;
/*
 *@auther:谷建龙
 *@Date: 2020/2/11
 *@Time:17:23
 *@Description:
 * */


import android.util.Printer;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myorder.api.ApiService;
import com.example.myorder.url.MyUrl;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetUtils {

    private final ApiService apiService;

    public NetUtils() {
        //日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //OKHTTP
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(MyUrl.BeanUrl)
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
