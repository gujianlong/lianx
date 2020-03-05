package com.example.zuoye.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/2/23
 *@Time:17:03
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zuoye.R;
import com.example.zuoye.bean.TwoBean;
import com.example.zuoye.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SoonAdapter extends RecyclerView.Adapter<SoonAdapter.ViewHolder> {
    private final List<TwoBean.SubjectsBean> list;
    private final Context context;

    public SoonAdapter(List<TwoBean.SubjectsBean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.soon_two_one, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TwoBean.SubjectsBean subjectsBean = list.get(position);
        holder.twoName.setText(subjectsBean.getTitle());
        holder.twoTime.setText(subjectsBean.getYear());
        GlideUtils.loadImage(subjectsBean.getImages().getSmall(),holder.twoImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.two_image)
        ImageView twoImage;
        @BindView(R.id.two_name)
        TextView twoName;
        @BindView(R.id.two_time)
        TextView twoTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
