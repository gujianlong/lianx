package com.example.zuoye.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/2/23
 *@Time:13:28
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
import com.example.zuoye.bean.BeingBean;
import com.example.zuoye.bean.TwoBean;
import com.example.zuoye.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeingAdapter extends RecyclerView.Adapter<BeingAdapter.Holder> {


    private final List<BeingBean.SubjectsBean> list;
    private final Context context;

    public BeingAdapter(List<BeingBean.SubjectsBean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.being_one, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        BeingBean.SubjectsBean subjectsBean = list.get(position);
        holder.oneName.setText(subjectsBean.getTitle());
        holder.oneTime.setText("上映时间" + subjectsBean.getYear());
        holder.oneType.setText("类型"+subjectsBean.getSubtype());
        GlideUtils.loadImage(subjectsBean.getImages().getSmall(),holder.oneImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.one_image)
        ImageView oneImage;
        @BindView(R.id.one_name)
        TextView oneName;
        @BindView(R.id.one_type)
        TextView oneType;
        @BindView(R.id.one_time)
        TextView oneTime;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
