package com.example.gujianlong221.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/3/4
 *@Time:16:40
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong221.R;
import com.example.gujianlong221.bean.UserBean;
import com.example.gujianlong221.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PzshAdapter extends RecyclerView.Adapter<PzshAdapter.ViewHolder> {
    private final Context context;
    private final List<UserBean.ResultBean.PzshBean.CommodityListBeanX> mPzsh;

    public PzshAdapter(Context context, List<UserBean.ResultBean.PzshBean.CommodityListBeanX> pzsh) {

        this.context = context;
        mPzsh = pzsh;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.pzsh, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserBean.ResultBean.PzshBean.CommodityListBeanX commodityListBeanX = mPzsh.get(position);
        holder.threeName.setText(commodityListBeanX.getCommodityName());
        holder.threePrice.setText("$"+commodityListBeanX.getPrice());
        GlideUtils.loadImage(commodityListBeanX.getMasterPic(),holder.threeImage);
    }

    @Override
    public int getItemCount() {
        return mPzsh.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.three_image)
        ImageView threeImage;
        @BindView(R.id.three_name)
        TextView threeName;
        @BindView(R.id.three_price)
        TextView threePrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);ButterKnife.bind(this, itemView);

        }
    }


}
