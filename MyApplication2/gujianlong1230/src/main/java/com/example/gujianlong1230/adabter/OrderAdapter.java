package com.example.gujianlong1230.adabter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/10
 *@Time:9:03
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.one_order, parent, false);

        return new OneHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder holder, int position) {
        holder.oneding.setText(list.get(position).getOrderTime() + "");
        holder.onephone.setText(list.get(position).getUserId() + "");
        TwoOrderAdapter twoOrderAdapter = new TwoOrderAdapter(list.get(position).getDetailList(), context);
        holder.onerv.setAdapter(twoOrderAdapter);
        if (list.get(position).getOrderStatus() == 1) {
            holder.onebutton.setText("代付款");
        } else if (list.get(position).getOrderStatus() == 2) {
            holder.onebutton.setText("待收货");
        } else if (list.get(position).getOrderStatus() == 3) {
            holder.onebutton.setText("待评价");
        } else {
            holder.onebutton.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.itemClick(position);
            }
        });
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
        @BindView(R.id.onebutton)
        Button onebutton;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            onerv.setLayoutManager(new LinearLayoutManager(context));
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.two_order, parent, false);
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


    public interface OnItemClick {
        void itemClick(int position);
    }

    OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
