package com.example.gujianlong1230.adabter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:9:10
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong1230.MainActivity;
import com.example.gujianlong1230.R;
import com.example.gujianlong1230.bean.UserBean;
import com.example.gujianlong1230.utils.GlideUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    private final List<UserBean.ResultBean.MlssBean> list;
    private final Context context;

    public MyAdapter(List<UserBean.ResultBean.MlssBean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.oneitem,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(list.get(position).getName());
        GlideUtils.loadImage(list.get(position).getCommodityList(),holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private final ImageView image;
        private final TextView name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }
    }
}
