package com.bawei.zhangsan20191224.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/24
 *@Time:15:42
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.zhangsan20191224.HomeActivity;
import com.bawei.zhangsan20191224.R;
import com.bawei.zhangsan20191224.bean.UserBean;
import com.bawei.zhangsan20191224.utils.GlideUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.BigAdapter> {
    private final Context context;
    private final List<UserBean.OrderDataBean> list;

    public MyAdapter(Context context, List<UserBean.OrderDataBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BigAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vi = View.inflate(context, R.layout.big_item, null);
        BigAdapter holder = new BigAdapter(vi);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BigAdapter holder, final int position) {
        holder.big_name.setText(list.get(position).getShopName());
        holder.big_check.setChecked(bigIndex(position));
        SmallAdapter smallAdapter = new SmallAdapter(list.get(position).getCartlist(), position);
        holder.big_rv.setAdapter(smallAdapter);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.setBigIndex(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BigAdapter extends RecyclerView.ViewHolder {

        private final TextView big_name;
        private final RecyclerView big_rv;
        private final CheckBox big_check;

        public BigAdapter(@NonNull View itemView) {
            super(itemView);
            big_name = itemView.findViewById(R.id.big_name);
            big_rv = itemView.findViewById(R.id.big_rv);
            big_rv.setLayoutManager(new LinearLayoutManager(context));
            big_check = itemView.findViewById(R.id.big_check);
        }
    }

    class SmallAdapter extends RecyclerView.Adapter<SmallAdapter.SmallHolder> {
        private List<UserBean.OrderDataBean.CartlistBean> list;
        private int bigIndex;

        public SmallAdapter(List<UserBean.OrderDataBean.CartlistBean> list, int bigIndex) {
            this.list = list;
            this.bigIndex = bigIndex;
        }

        @NonNull
        @Override
        public SmallHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.small_item, null);
            SmallHolder holder = new SmallHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull SmallHolder holder, int position) {
            holder.small_check.setChecked(list.get(position).isStatus());
            holder.small_color.setText(list.get(position).getColor());
            holder.small_name.setText(list.get(position).getProductName());
            holder.small_price.setText(list.get(position).getPrice() + "");
            GlideUtils.loadImage(list.get(position).getDefaultPic(), holder.small_image);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class SmallHolder extends RecyclerView.ViewHolder {

            private final CheckBox small_check;
            private final TextView small_color;
            private final TextView small_name;
            private final TextView small_price;
            private final ImageView small_image;

            public SmallHolder(@NonNull View itemView) {
                super(itemView);
                small_check = itemView.findViewById(R.id.small_check);
                small_color = itemView.findViewById(R.id.small_color);
                small_name = itemView.findViewById(R.id.small_name);
                small_price = itemView.findViewById(R.id.small_price);
                small_image = itemView.findViewById(R.id.small_image);
            }
        }
    }
    //点击事件
    public interface ItemClick{
        void setBigIndex(int setIndex);
    }
    private ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public boolean bigIndex(int Bigindex) {
        boolean frag = true;
        UserBean.OrderDataBean orderDataBean = list.get(Bigindex);
        for (int i = 0; i < orderDataBean.getCartlist().size(); i++) {
            frag = false;
            return frag;
        }
        return frag;
    }

    public void setBigIndex(int Bigindex, boolean isStutas) {
        List<UserBean.OrderDataBean.CartlistBean> cartlist = list.get(Bigindex).getCartlist();
        for (UserBean.OrderDataBean.CartlistBean cartlistBean : cartlist) {
            cartlistBean.setStatus(isStutas);
        }
    }
}
