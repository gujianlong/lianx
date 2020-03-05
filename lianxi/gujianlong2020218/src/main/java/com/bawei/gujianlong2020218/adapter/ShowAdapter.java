package com.bawei.gujianlong2020218.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:10:39
 *@Description:
 * */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.gujianlong2020218.R;
import com.bawei.gujianlong2020218.bean.OrderBean;
import com.bawei.gujianlong2020218.bean.ShowBean;
import com.bawei.gujianlong2020218.utils.GlideUtlis;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {


    private final Context context;
    private final List<ShowBean.ResultBean> list;

    public ShowAdapter(Context context, List<ShowBean.ResultBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.shou, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GlideUtlis.loadImage(list.get(position).getMasterPic(), holder.shouImage);
        holder.showName.setText(list.get(position).getCommodityName());
        holder.showPrice.setText(list.get(position).getPrice() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.shou_image)
        ImageView shouImage;
        @BindView(R.id.show_name)
        TextView showName;
        @BindView(R.id.show_price)
        TextView showPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
