package com.example.gujianlong1230.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:8:53
 *@Description:
 * */


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.gujianlong1230.R;
import com.example.gujianlong1230.app.MyApp;
import com.example.gujianlong1230.bean.UserBean;

import java.util.List;

public class GlideUtils {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContext)
                .load(url)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
