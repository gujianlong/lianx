package com.example.week2.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/4
 *@Time:10:18
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week2.MainActivity;
import com.example.week2.R;
import com.example.week2.bean.ItemBean;
import com.example.week2.utils.GlideUtils;

import java.util.List;

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.Holder> {
    private final Context context;
    private final List<ItemBean.ResultBean> twoList;

    public TwoAdapter(Context context, List<ItemBean.ResultBean> twoList) {

        this.context = context;
        this.twoList = twoList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.twoitem, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.two_name.setText(twoList.get(position).getCommodityName());
        GlideUtils.loadImage(twoList.get(position).getMasterPic(), holder.two_image);
    }

    @Override
    public int getItemCount() {
        return twoList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final ImageView two_image;
        private final TextView two_name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            two_image = itemView.findViewById(R.id.two_image);
            two_name = itemView.findViewById(R.id.two_name);
        }
    }
}
