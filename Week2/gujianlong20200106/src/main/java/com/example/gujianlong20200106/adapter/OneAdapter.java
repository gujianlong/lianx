package com.example.gujianlong20200106.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:9:33
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong20200106.R;
import com.example.gujianlong20200106.bean.HomeBean;
import com.example.gujianlong20200106.bean.ItemBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.Holder> {
    private final Context context;
    private final List<String> oneList;

    public OneAdapter(Context context, List<String> oneList) {

        this.context = context;
        this.oneList = oneList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.oneitem, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.oneName.setText(oneList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onClick(position);
            }
        });
    }

    //点击事件
    public interface ItemClick {
        void onClick(int position);
    }

    private ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @Override
    public int getItemCount() {
        return oneList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.one_name)
        TextView oneName;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
