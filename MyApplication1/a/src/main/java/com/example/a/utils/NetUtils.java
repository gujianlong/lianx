package com.example.a.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/12/27
 *@Time:18:52
 *@Description:
 * */


import android.os.Handler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetUtils {

    private final OkHttpClient okHttpClient;
    private final Handler handler;
    private static NetUtils netUtils;

    private NetUtils() {
        handler = new Handler();
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

    }

//    private static class net {
//        private static NetUtils netUtils = new NetUtils();
//    }

    public static NetUtils getInstance() {
        if (netUtils == null) {
            synchronized (NetUtils.class) {
                if (netUtils == null) {
                    netUtils = new NetUtils();
                }
            }
        }
        return netUtils;
    }

    public interface MyCallBack {
        void onSuccess(String url);

        void onError(Throwable throwable);
    }

    public void getInfo(String url, MyCallBack myCallBack) {
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
                        myCallBack.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null && response.isSuccessful()) {
                    String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallBack.onSuccess(string);
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallBack.onError(new Exception("请求失败"));
                        }
                    });
                }
            }
        });
    }

    public void postInfo(String url, Map<String, String> map, MyCallBack myCallBack) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : map.keySet()) {
            builder.add(key,map.get(key) );
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder()
                .post(formBody)
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallBack.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null && response.isSuccessful()) {
                    String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallBack.onSuccess(string);
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallBack.onError(new Exception("请求失败"));
                        }
                    });
                }
            }
        });
    }
}
