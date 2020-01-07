package com.example.lianxi2.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:18:51
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lianxi2.R;
import com.example.lianxi2.bean.UserBean;
import com.example.lianxi2.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private final List<UserBean.ResultBean> list;

    public MyAdapter(Context context, List<UserBean.ResultBean> list) {

        this.context = context;
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getShoppingCartList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        OneViewHolder oneViewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.oneitem, null);
            oneViewHolder = new OneViewHolder(convertView);
            convertView.setTag(oneViewHolder);
        } else {
            oneViewHolder = (OneViewHolder) convertView.getTag();
        }
        UserBean.ResultBean resultBean = list.get(groupPosition);
        oneViewHolder.oneName.setText(resultBean.getCategoryName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TwoViewHolder twoViewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.twoitem, null);
            twoViewHolder = new TwoViewHolder(convertView);
            convertView.setTag(twoViewHolder);
        } else {
            twoViewHolder = (TwoViewHolder) convertView.getTag();
        }
        UserBean.ResultBean.ShoppingCartListBean shoppingCartListBean = list.get(groupPosition).getShoppingCartList().get(childPosition);
        twoViewHolder.twoName.setText(shoppingCartListBean.getCommodityName());
        twoViewHolder.twoPrice.setText(shoppingCartListBean.getPrice() + "");
        GlideUtils.loadImage(shoppingCartListBean.getPic(), twoViewHolder.twoImage);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class OneViewHolder {
        @BindView(R.id.one_name)
        TextView oneName;

        OneViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class TwoViewHolder {
        @BindView(R.id.two_image)
        ImageView twoImage;
        @BindView(R.id.two_name)
        TextView twoName;
        @BindView(R.id.two_price)
        TextView twoPrice;

        TwoViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
