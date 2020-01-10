package com.example.gujianlong1230.adabter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/10
 *@Time:9:03
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong1230.R;
import com.example.gujianlong1230.bean.OrderBean;
import com.example.gujianlong1230.utils.GlideUtils;

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
        View inflate = View.inflate(context, R.layout.one_order, null);
        return new OneHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder holder, int position) {
        holder.oneding.setText(list.get(position).getUserId() + "");
        holder.onephone.setText(list.get(position).getOrderTime() + "");
        TwoOrderAdapter twoOrderAdapter = new TwoOrderAdapter(list.get(position).getDetailList(), context);
        holder.onerv.setAdapter(twoOrderAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OneHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.oneding)
        TextView oneding;
        @BindView(R.id.onerv)
        RecyclerView onerv;
        @BindView(R.id.onephone)
        TextView onephone;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class TwoOrderAdapter extends RecyclerView.Adapter<TwoOrderAdapter.TwoHolder> {
        private List<OrderBean.OrderListBean.DetailListBean> list;
        private Context context;

        public TwoOrderAdapter(List<OrderBean.OrderListBean.DetailListBean> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public TwoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = View.inflate(context, R.layout.two_order, null);
            return new TwoHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull TwoHolder holder, int position) {
            holder.twoname.setText(list.get(position).getCommodityName());
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
