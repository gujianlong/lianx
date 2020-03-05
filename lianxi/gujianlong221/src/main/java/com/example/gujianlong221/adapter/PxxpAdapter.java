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

public class PxxpAdapter extends RecyclerView.Adapter<PxxpAdapter.ViewHodler> {
    private final Context context;
    private final List<UserBean.ResultBean.RxxpBean.CommodityListBean> mPxxp;

    public PxxpAdapter(Context context, List<UserBean.ResultBean.RxxpBean.CommodityListBean> pxxp) {

        this.context = context;
        mPxxp = pxxp;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.pxxp, null);
        return new ViewHodler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        UserBean.ResultBean.RxxpBean.CommodityListBean commodityListBean = mPxxp.get(position);
        holder.oneName.setText(commodityListBean.getCommodityName());
        holder.onePrice.setText("$" + commodityListBean.getPrice());
        GlideUtils.loadImage(commodityListBean.getMasterPic(), holder.oneImage);
    }

    @Override
    public int getItemCount() {
        return mPxxp.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        @BindView(R.id.one_image)
        ImageView oneImage;
        @BindView(R.id.one_name)
        TextView oneName;
        @BindView(R.id.one_price)
        TextView onePrice;

        public ViewHodler(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

}
