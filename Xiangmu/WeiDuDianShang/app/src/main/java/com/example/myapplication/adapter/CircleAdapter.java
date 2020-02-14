package com.example.myapplication.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/17
 *@Time:14:57
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.bean.CircleBean;
import com.example.myapplication.utils.GlideUtils;

import java.util.List;

public class CircleAdapter extends RecyclerView.Adapter<CircleAdapter.Holder> {

    private final List<CircleBean.ResultBean> list;
    private final Context context;

    public CircleAdapter(List<CircleBean.ResultBean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.circle,null);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        GlideUtils.loadImage(list.get(position).getImage(),holder.circle_image);
        GlideUtils.loadImage(list.get(position).getHeadPic(),holder.ciecle_image);
        holder.circle_name.setText(list.get(position).getContent());
        holder.ciecle_name.setText(list.get(position).getNickName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private final ImageView circle_image;
        private final ImageView ciecle_image;
        private final TextView circle_name;
        private final TextView ciecle_name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            circle_image = itemView.findViewById(R.id.circle_image);
            ciecle_image = itemView.findViewById(R.id.ciecle_image);
            circle_name = itemView.findViewById(R.id.circle_text);
            ciecle_name = itemView.findViewById(R.id.ciecle_name);
        }
    }
}
