package com.example.week3.adapter;
/*
 *@auther:谷建龙
 *@Date: 2020/1/11
 *@Time:11:27
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.week3.R;
import com.example.week3.bean.CartBean;
import com.example.week3.utils.GlideUtils;

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
            convertView = View.inflate(context, R.layout.one_item, null);
            oneViewHolder = new OneViewHolder(convertView);
            convertView.setTag(oneViewHolder);
        } else {
            oneViewHolder = (OneViewHolder) convertView.getTag();
        }
        CartBean.ResultBean resultBean = list.get(groupPosition);
        oneViewHolder.oneName.setText(resultBean.getCategoryName());
        //拿到所有商品
        List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        //设置默认为true
        boolean isCheck = true;
        //遍历商品
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
                //拿到原始数据直返
                boolean check = finalIsCheck;
                check = !check;
                for (int i = 0; i < shoppingCartList.size(); i++) {
                    CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(i);
                    shoppingCartListBean.setCheck(check);
                }
                //刷新适配器
                notifyDataSetChanged();
                if (onItemClick != null) {
                    onItemClick.itemClick();
                }
            }
        });


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TwoViewHolder twoViewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.two_item, null);
            twoViewHolder = new TwoViewHolder(convertView);
            convertView.setTag(twoViewHolder);
        } else {
            twoViewHolder = (TwoViewHolder) convertView.getTag();
        }
        CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = list.get(groupPosition).getShoppingCartList().get(childPosition);
        twoViewHolder.twoName.setText(shoppingCartListBean.getCommodityName());
        GlideUtils.loadImage(shoppingCartListBean.getPic(), twoViewHolder.twoImage);
        twoViewHolder.twoPrice.setText(shoppingCartListBean.getPrice() + "");
        twoViewHolder.twoCheck.setChecked(shoppingCartListBean.isCheck());

        twoViewHolder.twoCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = shoppingCartListBean.isCheck();
                check = !check;
                shoppingCartListBean.setCheck(check);
                notifyDataSetChanged();
                if (onItemClick != null) {
                    onItemClick.itemClick();
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

        TwoViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    //总价
    public float calculateTouchPrice() {
        float touchPrice = 0;
        for (int i = 0; i < list.size(); i++) {
            CartBean.ResultBean resultBean = list.get(i);
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                if (shoppingCartListBean.isCheck()) {
                    touchPrice += shoppingCartListBean.getPrice() * shoppingCartListBean.getCount();
                }

            }
        }
        return touchPrice;
    }

    //全选
    public boolean calculateTouchIsChecked() {
        boolean touchPrice = true;
        for (int i = 0; i < list.size(); i++) {
            CartBean.ResultBean resultBean = list.get(i);
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                if (shoppingCartListBean.isCheck() == false) {
                    touchPrice = false;
                }

            }
        }
        return touchPrice;
    }

    public void IsChecked(boolean isCheck) {
        for (int i = 0; i < list.size(); i++) {
            CartBean.ResultBean resultBean = list.get(i);
            List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(j);
                shoppingCartListBean.setCheck(isCheck);
            }
        }
        notifyDataSetChanged();
    }

    public interface OnItemClick {
        void itemClick();
    }

    OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
