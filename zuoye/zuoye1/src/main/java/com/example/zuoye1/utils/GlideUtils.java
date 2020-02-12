package com.example.zuoye1.utils;
/*
 *@auther:谷建龙
 *@Date: 2020/1/15
 *@Time:11:03
 *@Description:
 * */


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.zuoye1.R;
import com.example.zuoye1.app.MyApp;

public class GlideUtils {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContent)
                .load(url)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
