package com.example.week.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/3
 *@Time:10:54
 *@Description:
 * */


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week.MainActivity;
import com.example.week.R;
import com.example.week.bean.ItemBean;
import com.example.week.bean.UserBean;

import java.util.List;

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.Holder> {
    private final List<UserBean.ResultBean.SecondCategoryVoBean> twoList;
    private final Context context;
    private int mColor = 0;

    public TwoAdapter(List<UserBean.ResultBean.SecondCategoryVoBean> twoList, Context context) {

        this.twoList = twoList;
        this.context = context;
    }

    public void setmColor(int position) {
        this.mColor = position;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.twoitem, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        holder.two_name.setText(twoList.get(position).getName());
        if (mColor == position) {
            holder.two_name.setTextColor(Color.BLUE);
        } else {
            holder.two_name.setTextColor(Color.RED);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClict.onClick(position);
            }
        });
    }

    public interface ItemClict {
        void onClick(int position);
    }

    private ItemClict itemClict;

    public void setItemClict(ItemClict itemClict) {
        this.itemClict = itemClict;
    }

    @Override
    public int getItemCount() {
        return twoList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final TextView two_name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            two_name = itemView.findViewById(R.id.two_name);
        }
    }
}
