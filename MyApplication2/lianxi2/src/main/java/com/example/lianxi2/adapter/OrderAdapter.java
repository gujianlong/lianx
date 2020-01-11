package com.example.lianxi2.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/9
 *@Time:16:22
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

import com.example.lianxi2.R;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.utils.GlideUtils;

import java.nio.file.FileStore;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OneHolder> {
    private final Context context;
    private final List<OrderBean.OrderListBean> list;

    public OrderAdapter(Context context, List<OrderBean.OrderListBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.one_item, parent, false);
        return new OneHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder holder, int position) {
        OrderBean.OrderListBean orderListBean = list.get(position);
        holder.oneid.setText(orderListBean.getOrderId() + "");
        holder.onetime.setText(orderListBean.getOrderTime() + "");
        if (orderListBean.getOrderStatus() == 0) {
            holder.onebutton.setVisibility(View.VISIBLE);
        } else if (orderListBean.getOrderStatus() == 1) {
            holder.onebutton.setText("去支付");
        } else if (orderListBean.getOrderStatus() == 2) {
            holder.onebutton.setText("确认收货");
        } else if (orderListBean.getOrderStatus() == 3) {
            holder.onebutton.setText("去评价");
        } else {
            holder.onebutton.setVisibility(View.GONE);
        }
        TwoAdapter twoAdapter = new TwoAdapter(list.get(position).getDetailList(), context);
        holder.onerv.setAdapter(twoAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OneHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.oneid)
        TextView oneid;
        @BindView(R.id.onerv)
        RecyclerView onerv;
        @BindView(R.id.onetime)
        TextView onetime;
        @BindView(R.id.onebutton)
        TextView onebutton;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            onerv.setLayoutManager(new LinearLayoutManager(context));
        }
    }

    class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.TwoHolder> {
        private List<OrderBean.OrderListBean.DetailListBean> list;
        private Context context;

        public TwoAdapter(List<OrderBean.OrderListBean.DetailListBean> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public TwoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.two_item, parent, false);
            return new TwoHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull TwoHolder holder, int position) {
            holder.twoname.setText(list.get(position).getCommodityName() + "");
            holder.twoprice.setText(list.get(position).getCommodityPrice() + "");
            String commodityPic = list.get(position).getCommodityPic();
            String[] split = commodityPic.split(",");
            GlideUtils.loadImage(split[0], holder.twoimage);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class TwoHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.twoimage)
            ImageView twoimage;
            @BindView(R.id.twoname)
            TextView twoname;
            @BindView(R.id.twoprice)
            TextView twoprice;

            public TwoHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

    }


}
