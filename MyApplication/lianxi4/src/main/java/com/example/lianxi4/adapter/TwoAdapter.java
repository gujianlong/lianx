package com.example.lianxi4.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/23
 *@Time:10:50
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lianxi4.MainActivity;
import com.example.lianxi4.R;
import com.example.lianxi4.bean.UserBean;

import java.util.List;

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.Holder> {
    private final List<UserBean.ResultBean.SecondCategoryVoBean> twoList;
    private final Context context;

    public TwoAdapter(List<UserBean.ResultBean.SecondCategoryVoBean> twoList, Context context) {

        this.twoList = twoList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.two_item, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.two_name.setText(twoList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return twoList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final TextView two_name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            two_name = itemView.findViewById(R.id.two_name);
        }
    }
}
