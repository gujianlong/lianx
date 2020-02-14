package com.example.lianxi2.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/19
 *@Time:14:39
 *@Description:
 * */


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lianxi2.R;
import com.example.lianxi2.bean.UserBean;

import java.util.List;

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.Holder> {
    private final List<UserBean.ResultBean> oneList;
    private final Context context;
    private int mColor = 0;

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
        holder.one_text.setText(oneList.get(position).getName());
        if (mColor == position) {
            holder.one_text.setTextColor(Color.BLUE);
        } else{
            holder.one_text.setTextColor(Color.RED);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onItemClick(position);
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

    public ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final TextView one_text;

        public Holder(@NonNull View itemView) {
            super(itemView);
            one_text = itemView.findViewById(R.id.one_text);
        }
    }

    public void setColoePosition(int position) {
        this.mColor = position;
        notifyDataSetChanged();
    }
}
