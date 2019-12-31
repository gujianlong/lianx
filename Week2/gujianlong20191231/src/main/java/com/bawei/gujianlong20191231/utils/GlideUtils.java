package com.bawei.gujianlong20191231.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/12/31
 *@Time:9:10
 *@Description:
 * */


import android.widget.ImageView;

import com.bawei.gujianlong20191231.R;
import com.bawei.gujianlong20191231.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtils {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContent)
                .load(url)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
