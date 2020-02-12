package com.example.zuoye3.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/22
 *@Time:15:43
 *@Description:
 * */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.load.model.GlideUrl;
import com.example.zuoye3.R;
import com.example.zuoye3.bean.OrderBean;
import com.example.zuoye3.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.OneHolder> {
    private final Context context;
    private final List<OrderBean.OrderListBean> list;

    public MyAdapter(Context context, List<OrderBean.OrderListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.oneitem, parent, false);
        return new OneHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder holder, int position) {
        holder.oneDing.setText(list.get(position).getOrderId() + "");
        holder.oneTime.setText(list.get(position).getOrderTime() + "");
        TwoAdapter twoAdapter = new TwoAdapter(context, list.get(position).getDetailList());
        holder.oneRv.setAdapter(twoAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OneHolder extends ViewHolder {
        @BindView(R.id.one_ding)
        TextView oneDing;
        @BindView(R.id.one_rv)
        RecyclerView oneRv;
        @BindView(R.id.one_time)
        TextView oneTime;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            oneRv.setLayoutManager(new LinearLayoutManager(context));
        }
    }

    static class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.TwoHolder> {
        private Context context;
        private List<OrderBean.OrderListBean.DetailListBean> list;

        public TwoAdapter(Context context, List<OrderBean.OrderListBean.DetailListBean> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public TwoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.twoitem, parent, false);
            return new TwoHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TwoHolder holder, int position) {
            holder.twoName.setText(list.get(position).getCommodityName());
            holder.twoPrice.setText(list.get(position).getCommodityPrice() + "");
            OrderBean.OrderListBean.DetailListBean detailListBean = list.get(position);
            String commodityPic = detailListBean.getCommodityPic();
            String[] split = commodityPic.split(",");
            GlideUtils.loadImage(split[0], holder.twoImage);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class TwoHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.two_image)
            ImageView twoImage;
            @BindView(R.id.two_name)
            TextView twoName;
            @BindView(R.id.two_price)
            TextView twoPrice;

            public TwoHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }

}
