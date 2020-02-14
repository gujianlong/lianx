package com.example.lianxi2.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/12/18
 *@Time:15:08
 *@Description:
 * */


import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.lianxi2.api.ApiServide;
import com.example.lianxi2.app.MyApp;
import com.example.lianxi2.url.MyUrl;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetUtils {

    private final ApiServide apiServide;

    //单例模式
    private NetUtils() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //okhttp
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        SharedPreferences gjl = MyApp.mContext.getSharedPreferences("gjl", Context.MODE_PRIVATE);
                        String userId = gjl.getString("userId", "");
                        String sessionId = gjl.getString("sessionId", "");
                        if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(sessionId)) {
                            return chain.proceed(chain.request());
                        } else {
                            Request build = chain.request().newBuilder()
                                    .addHeader("userId", userId)
                                    .addHeader("sessionId", sessionId)
                                    .build();
                            return chain.proceed(build);
                        }

                    }
                })
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyUrl.BASEURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiServide = retrofit.create(ApiServide.class);
    }

    private static class net {
        private static NetUtils netUtils = new NetUtils();
    }

    public static NetUtils getInstance() {
        return net.netUtils;
    }

    public interface NetCallBack<T> {
        void onSuccess(T t);

        void onError(String error);
    }

    public void getInfo(String url, final Class cls, final NetCallBack netCallBack) {
        apiServide.getInfoNotParams(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            if (netCallBack != null) {
                                netCallBack.onSuccess(o);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (netCallBack != null) {
                            netCallBack.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void postInfo(String url, final Class cls, Map<String, Object> map, final NetCallBack netCallBack) {
        apiServide.postInfoParams(url, map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            Object o = gson.fromJson(responseBody.string(), cls);
                            if (netCallBack != null) {
                                netCallBack.onSuccess(o);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (netCallBack != null) {
                            netCallBack.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
