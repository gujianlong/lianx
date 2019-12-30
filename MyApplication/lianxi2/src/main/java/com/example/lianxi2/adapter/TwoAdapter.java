package com.example.lianxi2.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/19
 *@Time:14:40
 *@Description:
 * */


import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lianxi2.R;
import com.example.lianxi2.bean.UserBean;

import java.util.List;

public class TwoAdapter extends RecyclerView.Adapter<OneAdapter.TwoAdapter.Holder> {
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
        holder.two_text.setText(twoList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return twoList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final TextView two_text;

        public Holder(@NonNull View itemView) {
            super(itemView);
            two_text = itemView.findViewById(R.id.two_text);
        }
    }
}
