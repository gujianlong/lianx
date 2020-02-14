package com.example.lianxi2.utils;
/*
 *@auther:谷建龙
 *@Date: 2020/2/13
 *@Time:14:12
 *@Description:
 * */


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.lianxi2.R;
import com.example.lianxi2.app.MyApp;

public class GlideUtils {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
