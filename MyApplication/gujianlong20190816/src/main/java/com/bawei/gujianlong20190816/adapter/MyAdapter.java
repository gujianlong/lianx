package com.bawei.gujianlong20190816.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/16
 *@Time:10:23
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

import com.bawei.gujianlong20190816.ListActivity;
import com.bawei.gujianlong20190816.R;
import com.bawei.gujianlong20190816.bean.UserBean;
import com.bawei.gujianlong20190816.utils.GlideUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private final Context context;
    private final List<UserBean.OrderListBean> list;

    public MyAdapter(Context context, List<UserBean.OrderListBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_a, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        UserBean.OrderListBean orderListBean = list.get(position);
        holder.a_ding.setText(orderListBean.getOrderId());
        if (orderListBean.getOrderStatus() == 1) {
            holder.a_shou.setText("取消订单");
            holder.a_que.setText("付款");
        } else if (orderListBean.getOrderStatus() == 2) {
            holder.a_shou.setText("退货");
            holder.a_que.setText("确认收货");
        } else if (orderListBean.getOrderStatus() == 3) {
            holder.a_shou.setVisibility(View.GONE);
            holder.a_que.setText("去评价");
        }
        OneAdapter oneAdapter = new OneAdapter(list.get(position).getDetailList(), context);
        holder.a_recy.setAdapter(oneAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final Button a_shou;
        private final Button a_que;
        private final RecyclerView a_recy;
        private final TextView a_ding;

        public Holder(@NonNull View itemView) {
            super(itemView);
            a_shou = itemView.findViewById(R.id.a_shou);
            a_que = itemView.findViewById(R.id.a_que);
            a_recy = itemView.findViewById(R.id.a_recy);
            a_ding = itemView.findViewById(R.id.a_ding);
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
            View view = View.inflate(context, R.layout.item_b, null);
            OneHolder holder = new OneHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull OneHolder holder, int position) {
            UserBean.OrderListBean.DetailListBean detailListBean = list.get(position);
            holder.name.setText(detailListBean.getCommodityName());
            String[] split = detailListBean.getCommodityPic().split(",");
            if (split != null && split.length > 0) {
                GlideUtils.loadImage(split[0], holder.image);
            } else {
                GlideUtils.loadImage(detailListBean.getCommodityPic(), holder.image);
            }

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class OneHolder extends RecyclerView.ViewHolder {

            private final TextView name;
            private final ImageView image;

            public OneHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.b_name);
                image = itemView.findViewById(R.id.b_image);
            }
        }
    }
}
