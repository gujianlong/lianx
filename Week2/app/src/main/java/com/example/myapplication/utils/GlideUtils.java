package com.example.myapplication.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:14:01
 *@Description:
 * */


import android.util.Printer;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.app.MyApp;

public class GlideUtils {
    public static void loadImage(String url, ImageView imageView){
        Glide.with(MyApp.mContext)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(40)))
                .into(imageView);
    }
}
