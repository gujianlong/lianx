package com.example.gujianlong20200106.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:9:34
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong20200106.R;
import com.example.gujianlong20200106.bean.ItemBean;
import com.example.gujianlong20200106.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.holder> {
    private final Context context;
    private final List<ItemBean.DataBean> twoList;

    public TwoAdapter(Context context, List<ItemBean.DataBean> twoList) {

        this.context = context;
        this.twoList = twoList;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.twoitem, null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.twoName.setText(twoList.get(position).getGoods_name());
        GlideUtils.loadImage(twoList.get(position).getGoods_thumb(), holder.twoImage);
    }

    @Override
    public int getItemCount() {
        return twoList.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        @BindView(R.id.two_image)
        ImageView twoImage;
        @BindView(R.id.two_name)
        TextView twoName;

        public holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
