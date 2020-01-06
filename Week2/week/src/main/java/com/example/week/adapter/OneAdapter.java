package com.example.week.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/3
 *@Time:10:54
 *@Description:
 * */


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week.MainActivity;
import com.example.week.R;
import com.example.week.bean.UserBean;

import java.util.List;

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.Holder> {
    private final List<UserBean.ResultBean> oneList;
    private final Context context;
    private int mColor = 0;

    public OneAdapter(List<UserBean.ResultBean> oneList, Context context) {

        this.oneList = oneList;
        this.context = context;
    }

    public void setColorItem(int position) {
        this.mColor = position;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.oneitem, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        holder.one_name.setText(oneList.get(position).getName());
        if (mColor == position) {
            holder.one_name.setTextColor(Color.RED);
        } else {
            holder.one_name.setTextColor(Color.BLUE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return oneList.size();
    }

    public interface ItemClick {
        void onClick(int position);
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
