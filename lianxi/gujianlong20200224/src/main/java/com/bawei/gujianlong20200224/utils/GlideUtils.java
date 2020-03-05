package com.bawei.gujianlong20200224.utils;
/*
 *@auther:谷建龙
 *@Date: 2020/2/24
 *@Time:13:29
 *@Description:
 * */


import android.widget.ImageView;

import com.bawei.gujianlong20200224.R;
import com.bawei.gujianlong20200224.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import retrofit2.http.Url;

public class GlideUtils {
    public static void loadImage(String str, ImageView imageView) {
        Glide.with(MyApp.context)
                .load(str)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
