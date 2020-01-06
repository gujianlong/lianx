package com.example.week2.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/4
 *@Time:10:18
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week2.MainActivity;
import com.example.week2.R;
import com.example.week2.bean.UserBean;

import java.util.List;

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.Holder> {
    private final Context context;
    private final List<UserBean.ResultBean.SecondCategoryVoBean> oneList;

    public OneAdapter(Context context, List<UserBean.ResultBean.SecondCategoryVoBean> oneList) {
        this.context = context;
        this.oneList = oneList;
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return oneList.size();
    }

    public interface ItemClick {
        void onItem(int position);
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
