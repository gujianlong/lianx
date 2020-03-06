package com.example.mycart.weight;
/*
 *@auther:谷建龙
 *@Date: 2020/2/7
 *@Time:12:02
 *@Description:
 * */


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.mycart.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyView extends LinearLayout {


    @BindView(R.id.v_jian)
    TextView vJian;
    @BindView(R.id.v_sum)
    TextView vSum;
    @BindView(R.id.v_add)
    TextView vAdd;
    private int sum = 1;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View inflate = View.inflate(context, R.layout.view, this);
        ButterKnife.bind(this,inflate);

    }

    @OnClick({R.id.v_jian, R.id.v_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.v_jian:
                if (sum > 1) {
                    sum--;
                    vSum.setText("" + sum);
                    if (itemView != null) {
                        itemView.onView(sum);
                    }
                } else {
                    Toast.makeText(getContext(), "不能再减了", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.v_add:
                sum++;
                vSum.setText("" + sum);
                if (itemView != null) {
                    itemView.onView(sum);
                }
                break;
        }
    }

    public void setSum(int sum) {
        this.sum = sum;
        vSum.setText("" + sum);
    }

    //接口回调
    public interface ItemView {
        void onView(int number);
    }
    ItemView itemView;
    public void setItemView(ItemView itemView) {
        this.itemView = itemView;
    }
}
