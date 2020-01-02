package com.example.lianxi.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/12/28
 *@Time:13:04
 *@Description:
 * */


import android.os.Handler;

import java.io.IOException;
import java.security.Key;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class NetUtils {

    private final OkHttpClient okHttpClient;
    private final Handler handler;

    private NetUtils() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        handler = new Handler();
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

    public void getInfo(String url, NetCallBack netCallBack) {
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
    }public void postInfo(String url,Map<String,String>map, NetCallBack netCallBack) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key: map.keySet()){
            builder.add(key,map.get(key));
        }
        FormBody build = builder.build();
        Request request = new Request.Builder()
                .post(build)
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
}
