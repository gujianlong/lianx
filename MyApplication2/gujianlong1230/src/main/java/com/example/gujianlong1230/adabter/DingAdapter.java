package com.example.gujianlong1230.adabter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/9
 *@Time:9:05
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong1230.R;
import com.example.gujianlong1230.bean.DingBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DingAdapter extends RecyclerView.Adapter<DingAdapter.Holder> {
    private final Context context;
    private final List<DingBean.ResultBean> list;

    public DingAdapter(Context context, List<DingBean.ResultBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.dingitem, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(list.get(position).getRealName());
        holder.phone.setText(list.get(position).getPhone());
        holder.dizhi.setText(list.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.phone)
        TextView phone;
        @BindView(R.id.dizhi)
        TextView dizhi;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
