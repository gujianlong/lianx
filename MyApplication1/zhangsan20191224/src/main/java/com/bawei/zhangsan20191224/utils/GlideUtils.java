package com.bawei.zhangsan20191224.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/12/24
 *@Time:14:18
 *@Description:
 * */


import android.widget.ImageView;

import com.bawei.zhangsan20191224.R;
import com.bawei.zhangsan20191224.app.MyApp;
import com.bawei.zhangsan20191224.url.MyUrl;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtils {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContext)
                .load(url)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(40)))
                .into(imageView);
    }
}
