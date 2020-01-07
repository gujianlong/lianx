package com.example.myapplication.adabter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:9:10
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.bean.BannerBean;
import com.example.myapplication.utils.GlideUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {


    private final Context context;
    private final List<BannerBean.ResultBean> list;

    public MyAdapter(Context context, List<BannerBean.ResultBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        GlideUtils.loadImage(list.get(position).getImageUrl(), holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final ImageView image;

        public Holder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
