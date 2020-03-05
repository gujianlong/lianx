package com.bawei.gujianlong20200224.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/2/24
 *@Time:15:11
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.gujianlong20200224.R;
import com.bawei.gujianlong20200224.bean.UserBean;
import com.bawei.gujianlong20200224.bean.UserTwoBean;
import com.bawei.gujianlong20200224.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserTwoAdapter extends RecyclerView.Adapter<UserTwoAdapter.TwoHolder> {

    private final List<UserTwoBean.ResultBean> list;
    private final Context context;

    public UserTwoAdapter(List<UserTwoBean.ResultBean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TwoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.two_user, null);
        return new TwoHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TwoHolder holder, int position) {
        UserTwoBean.ResultBean resultBean = list.get(position);
        holder.twoName.setText(resultBean.getNickName());
        GlideUtils.loadImage(resultBean.getGiftPic(), holder.twoImage1);
        GlideUtils.loadImage(resultBean.getHeadPic(), holder.twoImage2);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TwoHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.two_image1)
        ImageView twoImage1;
        @BindView(R.id.two_image2)
        ImageView twoImage2;
        @BindView(R.id.two_name)
        TextView twoName;
        public TwoHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
