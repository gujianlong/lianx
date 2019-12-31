package com.bawei.gujianlong20191231.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/12/31
 *@Time:8:58
 *@Description:
 * */


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
    private ConnectivityManager connectivityManager;

    private NetUtils() {
        handler = new Handler();
        //日志拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //OKHTTP
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    private static class net {
        private static NetUtils netUtils = new NetUtils();
    }

    public static NetUtils getInstance() {
        return net.netUtils;
    }

    public interface NetCallBack {
        void onSuccess(String url);

        void onError(Throwable throwable);
    }

    public void getJsonGet(String url, NetCallBack netCallBack) {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        netCallBack.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                if (response != null && response.isSuccessful()) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            netCallBack.onSuccess(string);
                        }
                    });
                } else {
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
    //封装网络判断的方法
    public boolean hasNet(Context context) {
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        } else {
            return false;
        }
    }

}
