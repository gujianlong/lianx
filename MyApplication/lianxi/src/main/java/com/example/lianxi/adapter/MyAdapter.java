package com.example.lianxi.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/15
 *@Time:16:24
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.model.GlideUrl;
import com.example.lianxi.Main2Activity;
import com.example.lianxi.R;
import com.example.lianxi.bean.UserBean;
import com.example.lianxi.utils.NetGlider;
import com.example.lianxi.utils.NetUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private final List<UserBean.OrderListBean> list;
    private final Context context;

    public MyAdapter(List<UserBean.OrderListBean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.a, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        UserBean.OrderListBean orderListBean = list.get(position);
        holder.a_name.setText(orderListBean.getOrderId() + "");
        if (orderListBean.getOrderStatus() == 1) {
            holder.a_delete.setText("取消订单");
            holder.a_status.setText("去支付");
        } else if (orderListBean.getOrderStatus() == 2) {
            holder.a_delete.setVisibility(View.GONE);
            holder.a_status.setText("已支付");
        }
        OneAdapter oneAdapter = new OneAdapter(orderListBean.getDetailList(), context);
        holder.a_recy.setAdapter(oneAdapter);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final TextView a_name;
        private final Button a_delete;
        private final Button a_status;
        private final RecyclerView a_recy;

        public Holder(@NonNull View itemView) {
            super(itemView);
            a_name = itemView.findViewById(R.id.a_name);
            a_delete = itemView.findViewById(R.id.a_Delete);
            a_status = itemView.findViewById(R.id.a_Status);
            a_recy = itemView.findViewById(R.id.a_recy);
            a_recy.setLayoutManager(new LinearLayoutManager(context));
        }
    }

    class OneAdapter extends RecyclerView.Adapter<OneAdapter.OneHolder> {
        private List<UserBean.OrderListBean.DetailListBean> list;
        private Context context;

        public OneAdapter(List<UserBean.OrderListBean.DetailListBean> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public OneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.b, null);
            OneHolder holder = new OneHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull OneHolder holder, int position) {
            UserBean.OrderListBean.DetailListBean detailListBean = list.get(position);
            holder.b_name.setText(detailListBean.getCommodityName() + "");
            holder.b_price.setText(detailListBean.getCommodityPrice() + "");
            String[] split = detailListBean.getCommodityPic().split(",");
            if (split != null && split.length > 0) {
                NetGlider.loadImage(split[0], holder.b_image);
            } else {
                NetGlider.loadImage(detailListBean.getCommodityPic(), holder.b_image);
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class OneHolder extends RecyclerView.ViewHolder {

            private final ImageView b_image;
            private final TextView b_name;
            private final TextView b_price;

            public OneHolder(@NonNull View itemView) {
                super(itemView);
                b_image = itemView.findViewById(R.id.b_Image);
                b_name = itemView.findViewById(R.id.b_Name);
                b_price = itemView.findViewById(R.id.b_Price);
            }
        }
    }
}
