package com.example.gujianlong1230.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:8:46
 *@Description:
 * */


import android.os.Handler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class NetUtils {

    private final Handler handler;
    private final OkHttpClient okHttpClient;

    private NetUtils() {
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        handler = new Handler();
        okHttpClient= new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
    }
    private static class net{
        private static NetUtils netUtils=new NetUtils();
    }

    public static NetUtils getInstance() {
        return net.netUtils;
    }
    public interface NetCallBack{
        void onSuccess(String url);
        void onError(Throwable throwable);
    }
    public void getInfo(String url, final NetCallBack netCallBack){
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        netCallBack.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                if (response != null&&response.isSuccessful()) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            netCallBack.onSuccess(string);
                        }
                    });
                }else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            netCallBack.onError(new Exception("请求失败"));
                        }
                    });
                }
            }
        });
    }
}
