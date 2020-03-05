package com.bawei.gujianlong20200224.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/2/24
 *@Time:14:15
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
import com.bawei.gujianlong20200224.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private final Context context;
    private final List<UserBean.ResultBean> list;

    public UserAdapter(Context context, List<UserBean.ResultBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.one_user, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserBean.ResultBean resultBean = list.get(position);
        holder.oneName.setText(resultBean.getNickName());
        GlideUtils.loadImage(resultBean.getGiftPic(), holder.oneImage1);
        GlideUtils.loadImage(resultBean.getHeadPic(), holder.oneImage2);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.one_image1)
        ImageView oneImage1;
        @BindView(R.id.one_name)
        TextView oneName;
        @BindView(R.id.one_image2)
        ImageView oneImage2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
