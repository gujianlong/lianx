package com.example.lianxi2.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/9
 *@Time:16:22
 *@Description:
 * */


import android.content.Context;
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
        View inflate = View.inflate(context, R.layout.one_item, null);
        return new OneHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder holder, int position) {
        holder.oneid.setText(list.get(position).getOrderId() + "");
        holder.onetime.setText(list.get(position).getOrderTime() + "");
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
            View inflate = View.inflate(context, R.layout.two_item, null);
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
