package com.example.lianxi4.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/23
 *@Time:10:48
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lianxi4.MainActivity;
import com.example.lianxi4.R;
import com.example.lianxi4.bean.UserBean;

import java.util.List;
import java.util.zip.Inflater;

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.Holder> {
    private final List<UserBean.ResultBean> oneList;
    private final Context context;

    public OneAdapter(List<UserBean.ResultBean> oneList, Context context) {

        this.oneList = oneList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.one_item, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        holder.one_name.setText(oneList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClick != null) {
                    itemClick.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return oneList.size();
    }

    public interface ItemClick {
        void onItemClick(int position);
    }

    private ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final TextView one_name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            one_name = itemView.findViewById(R.id.one_name);
        }
    }
}
