package com.bawei.gujianlong20190816.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/12/16
 *@Time:9:42
 *@Description:
 * */


import android.widget.ImageView;

import com.bawei.gujianlong20190816.R;
import com.bawei.gujianlong20190816.app.MyApp;
import com.bawei.gujianlong20190816.url.MyUrl;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtils {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContext)
                .load(url)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
