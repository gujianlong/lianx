package com.example.gujianlong1230.adabter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/7
 *@Time:9:01
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gujianlong1230.R;
import com.example.gujianlong1230.bean.CartBean;
import com.example.gujianlong1230.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private final List<CartBean.ResultBean> list;

    public CartAdapter(Context context, List<CartBean.ResultBean> list) {

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
            convertView = View.inflate(context, R.layout.itemone, null);
            oneViewHolder = new OneViewHolder(convertView);
            convertView.setTag(oneViewHolder);
        } else {
            oneViewHolder = (OneViewHolder) convertView.getTag();
        }
        CartBean.ResultBean resultBean = list.get(groupPosition);
        oneViewHolder.itemNameOne.setText(resultBean.getCategoryName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TwoViewHolder twoViewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.itemtwo, null);
            twoViewHolder = new TwoViewHolder(convertView);
            convertView.setTag(twoViewHolder);
        } else {
            twoViewHolder = (TwoViewHolder) convertView.getTag();
        }
        CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = list.get(groupPosition).getShoppingCartList().get(childPosition);
        twoViewHolder.itemNameTwo.setText(shoppingCartListBean.getCommodityName());
        twoViewHolder.itemPriceTwo.setText(shoppingCartListBean.getPrice() + "");
        GlideUtils.loadImage(shoppingCartListBean.getPic(), twoViewHolder.itemImageTwo);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class OneViewHolder {
        @BindView(R.id.item_name_one)
        TextView itemNameOne;

        OneViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class TwoViewHolder {
        @BindView(R.id.item_image_two)
        ImageView itemImageTwo;
        @BindView(R.id.item_name_two)
        TextView itemNameTwo;
        @BindView(R.id.item_price_two)
        TextView itemPriceTwo;

        TwoViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
