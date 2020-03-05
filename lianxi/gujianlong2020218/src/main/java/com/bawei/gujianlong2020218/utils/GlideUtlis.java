package com.bawei.gujianlong2020218.utils;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:9:46
 *@Description:
 * */


import android.widget.ImageButton;
import android.widget.ImageView;

import com.bawei.gujianlong2020218.R;
import com.bawei.gujianlong2020218.app.MyApp;
import com.bawei.gujianlong2020218.url.MyUrl;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtlis {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .priority(Priority.HIGH)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);

    }
}
