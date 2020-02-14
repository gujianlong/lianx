package com.example.week3.utils;
/*
 *@auther:谷建龙
 *@Date: 2020/1/11
 *@Time:10:46
 *@Description:
 * */


import android.provider.ContactsContract;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.week3.R;
import com.example.week3.app.MyApp;

public class GlideUtils {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContext)
                .load(url)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }
}
