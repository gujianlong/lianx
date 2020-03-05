package com.bawei.gujianlong2020218.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:11:24
 *@Description:
 * */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.gujianlong2020218.R;
import com.bawei.gujianlong2020218.bean.OrderBean;
import com.bawei.gujianlong2020218.utils.GlideUtlis;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OneViewHolder> {
    private final Context context;
    private final List<OrderBean.OrderListBean> list;

    public OrderAdapter(Context context, List<OrderBean.OrderListBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.one_order, parent, false);
        return new OneViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OneViewHolder holder, int position) {
        OrderBean.OrderListBean orderListBean = list.get(position);
        holder.oneId.setText(orderListBean.getOrderId() + "");
        int orderStatus = orderListBean.getOrderStatus();
        if (orderStatus == 1) {
            holder.oneButton.setVisibility(View.VISIBLE);
            holder.oneButton.setText("去付款");
            holder.oneTime.setVisibility(View.GONE);
        } else if (orderStatus == 2) {
            holder.oneButton.setVisibility(View.VISIBLE);
            holder.oneButton.setText("确认收货");
            holder.oneTime.setVisibility(View.GONE);
        } else if (orderStatus == 3) {
            holder.oneTime.setText(orderListBean.getOrderTime() + "");
            holder.oneButton.setText("去评价");
        } else if (orderStatus == 9) {
            holder.oneTime.setText(orderListBean.getOrderTime() + "");
            holder.oneButton.setText("已完成");
        }
        TwoOrederAdapter twoOrederAdapter = new TwoOrederAdapter(context, list.get(position).getDetailList());
        holder.oneRv.setAdapter(twoOrederAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OneViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.one_id)
        TextView oneId;
        @BindView(R.id.one_rv)
        RecyclerView oneRv;
        @BindView(R.id.one_time)
        TextView oneTime;
        @BindView(R.id.one_button)
        Button oneButton;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            oneRv.setLayoutManager(new LinearLayoutManager(context));
        }
    }

    class TwoOrederAdapter extends RecyclerView.Adapter<TwoOrederAdapter.TwoHolder> {
        private Context context;
        private List<OrderBean.OrderListBean.DetailListBean> list;

        public TwoOrederAdapter(Context context, List<OrderBean.OrderListBean.DetailListBean> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public TwoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.two_order, parent, false);
            return new TwoHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull TwoHolder holder, int position) {
            OrderBean.OrderListBean.DetailListBean detailListBean = list.get(position);
            holder.twoName.setText(detailListBean.getCommodityName());
            holder.twoPrice.setText(detailListBean.getCommodityPrice() + "");
            String commodityPic = detailListBean.getCommodityPic();
            String[] split = commodityPic.split(",");
            GlideUtlis.loadImage(split[0], holder.twoImage);
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
