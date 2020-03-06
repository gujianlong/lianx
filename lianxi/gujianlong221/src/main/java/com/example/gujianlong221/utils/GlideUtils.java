package com.example.gujianlong221.utils;
/*
 *@auther:谷建龙
 *@Date: 2020/2/28
 *@Time:16:48
 *@Description:
 * */


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.gujianlong221.R;
import com.example.gujianlong221.app.MyApp;

public class GlideUtils {
    public static void loadImage(String url, ImageView imageView){
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                //圆形图片
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
