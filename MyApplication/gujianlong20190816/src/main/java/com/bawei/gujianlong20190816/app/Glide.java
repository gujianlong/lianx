package com.bawei.gujianlong20190816.app;
/*
 *@auther:谷建龙
 *@Date: 2019/12/16
 *@Time:11:35
 *@Description:
 * */


import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;

public class Glide implements GlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        builder.setMemoryCache(new LruResourceCache(10 * 1024 * 1024));
        builder.setBitmapPool(new LruBitmapPool(20 * 1024 * 1024));
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull com.bumptech.glide.Glide glide, @NonNull Registry registry) {

    }
}
