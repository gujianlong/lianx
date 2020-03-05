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

public class MlssAdapter extends RecyclerView.Adapter<MlssAdapter.ViewHodler> {
    private final Context context;
    private final List<UserBean.ResultBean.MlssBean.CommodityListBeanXX> mMlss;

    public MlssAdapter(Context context, List<UserBean.ResultBean.MlssBean.CommodityListBeanXX> mlss) {

        this.context = context;
        mMlss = mlss;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.mlss, null);
        return new ViewHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        UserBean.ResultBean.MlssBean.CommodityListBeanXX commodityListBeanXX = mMlss.get(position);
        holder.twoName.setText(commodityListBeanXX.getCommodityName());
        holder.twoPrice.setText("$"+commodityListBeanXX.getPrice());
        GlideUtils.loadImage(commodityListBeanXX.getMasterPic(),holder.twoImage);
    }

    @Override
    public int getItemCount() {
        return mMlss.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        @BindView(R.id.two_image)
        ImageView twoImage;
        @BindView(R.id.two_name)
        TextView twoName;
        @BindView(R.id.two_price)
        TextView twoPrice;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
