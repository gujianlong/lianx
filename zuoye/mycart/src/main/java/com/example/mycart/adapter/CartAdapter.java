package com.example.mycart.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/2/6
 *@Time:15:20
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycart.R;
import com.example.mycart.bean.CartBean;
import com.example.mycart.utils.GlideUtils;
import com.example.mycart.weight.MyView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartAdapter extends BaseExpandableListAdapter {
    private final List<CartBean.ResultBean> list;
    private final Context context;

    public CartAdapter(List<CartBean.ResultBean> list, Context context) {

        this.list = list;
        this.context = context;
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
            convertView = View.inflate(context, R.layout.one_cart, null);
            oneViewHolder = new OneViewHolder(convertView);
            convertView.setTag(oneViewHolder);
        } else {
            oneViewHolder = (OneViewHolder) convertView.getTag();
        }
        CartBean.ResultBean resultBean = list.get(groupPosition);
        oneViewHolder.oneName.setText(resultBean.getCategoryName());
        List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        boolean isCheck = true;
        for (int i = 0; i < shoppingCartList.size(); i++) {
            CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(i);
            if (shoppingCartListBean.isCheck() == false) {
                isCheck = false;
                break;
            }
        }
        oneViewHolder.oneCheck.setChecked(isCheck);
        boolean finalIsCheck = isCheck;
        oneViewHolder.oneCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = finalIsCheck;
                check = !check;
                for (int i = 0; i < shoppingCartList.size(); i++) {
                    CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(i);
                    shoppingCartListBean.setCheck(check);
                }
                notifyDataSetChanged();

                if (itemClick != null) {
                    itemClick.onClick();
                }
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TwoViewHolder twoViewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.two_cart, null);
            twoViewHolder = new TwoViewHolder(convertView);
            convertView.setTag(twoViewHolder);
        } else {
            twoViewHolder = (TwoViewHolder) convertView.getTag();
        }
        CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = list.get(groupPosition).getShoppingCartList().get(childPosition);
        twoViewHolder.twoName.setText(shoppingCartListBean.getCommodityName());
        twoViewHolder.twoPrice.setText(shoppingCartListBean.getPrice() + "");
        GlideUtils.loadImage(shoppingCartListBean.getPic(), twoViewHolder.twoImage);
        twoViewHolder.twoCheck.setChecked(shoppingCartListBean.isCheck());
        twoViewHolder.twoMv.setSum(shoppingCartListBean.getCount());
        twoViewHolder.twoMv.setItemView(new MyView.ItemView() {
            @Override
            public void onView(int number) {
                shoppingCartListBean.setCount(number);
                if (itemClick != null) {
                    itemClick.onClick();
                }
                notifyDataSetChanged();
            }
        });
        twoViewHolder.twoCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = shoppingCartListBean.isCheck();
                check = !check;
                shoppingCartListBean.setCheck(check);
                notifyDataSetChanged();
                if (itemClick != null) {
                    itemClick.onClick();
                }
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


    static class OneViewHolder {
        @BindView(R.id.one_check)
        CheckBox oneCheck;
        @BindView(R.id.one_name)
        TextView oneName;

        OneViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
    static class TwoViewHolder {
        @BindView(R.id.two_check)
        CheckBox twoCheck;
        @BindView(R.id.two_image)
        ImageView twoImage;
        @BindView(R.id.two_name)
        TextView twoName;
        @BindView(R.id.two_price)
        TextView twoPrice;
        @BindView(R.id.two_mv)
        MyView twoMv;

        TwoViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


    //计算总价
    public double toutalPrice() {
        double price = 0;

        for (int i = 0; i < list.size(); i++) {
            CartBean.ResultBean resultBean = list.get(i);
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                if (shoppingCartListBean.isCheck()) {
                    price += shoppingCartListBean.getCount() * shoppingCartListBean.getPrice();
                }
            }
        }
        return price;
    }

    //计算总数量
    public int toutalNumber() {
        int number = 0;
        for (int i = 0; i < list.size(); i++) {
            CartBean.ResultBean resultBean = list.get(i);
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                if (shoppingCartListBean.isCheck()) {
                    number += shoppingCartListBean.getCount();
                }
            }
        }
        return number;
    }

    //全选
    public boolean toutalChecked() {
        boolean checked = true;
        for (int i = 0; i < list.size(); i++) {
            CartBean.ResultBean resultBean = list.get(i);
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                if (shoppingCartListBean.isCheck() == false) {
                    checked = false;
                    break;
                }
            }
        }
        return checked;
    }

    public void toutalAllChecked(boolean b) {
        for (int i = 0; i < list.size(); i++) {
            CartBean.ResultBean resultBean = list.get(i);
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                //if (shoppingCartListBean.isCheck()) {
                shoppingCartListBean.setCheck(b);
                // }
            }
        }
        notifyDataSetChanged();
    }

    //接口回调
    public interface ItemClick {
        void onClick();
    }

    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }


}
