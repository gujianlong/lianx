package com.bawei.gujianlong20191231.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/31
 *@Time:9:29
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.gujianlong20191231.R;
import com.bawei.gujianlong20191231.bean.UserBean;
import com.bawei.gujianlong20191231.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private final Context context;
    private final List<UserBean.RankingBean> list;

    public MyAdapter(Context context, List<UserBean.RankingBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.pai.setText(list.get(position).getRank());
        GlideUtils.loadImage(list.get(position).getAvatar(), holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //点击事件
    public interface ItemClick {
        void onItem(int position);
    }

    private ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.pai)
        TextView pai;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
