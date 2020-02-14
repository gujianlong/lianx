package com.example.lianxi.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/12/15
 *@Time:14:26
 *@Description:
 * */


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.lianxi.R;
import com.example.lianxi.app.MyApp;

public class NetGlider {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContent)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
