package com.example.week.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/3
 *@Time:11:40
 *@Description:
 * */


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week.MainActivity;
import com.example.week.R;
import com.example.week.bean.ItemBean;
import com.example.week.utils.GlideUtils;

import java.util.List;

public class ThreeAdapter extends RecyclerView.Adapter<ThreeAdapter.Holder> {
    private final List<ItemBean.ResultBean> threeList;
    private final Context context;

    public ThreeAdapter(List<ItemBean.ResultBean> threeList, Context context) {

        this.threeList = threeList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.threeitem, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.three_name.setText(threeList.get(position).getCommodityName());
        GlideUtils.loadImage(threeList.get(position).getMasterPic(), holder.three_image);
    }

    @Override
    public int getItemCount() {
        return threeList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final ImageView three_image;
        private final TextView three_name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            three_image = itemView.findViewById(R.id.three_image);
            three_name = itemView.findViewById(R.id.three_name);
        }
    }
}
