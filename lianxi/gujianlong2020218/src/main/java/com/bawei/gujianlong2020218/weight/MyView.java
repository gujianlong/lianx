package com.bawei.gujianlong2020218.weight;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:11:59
 *@Description:
 * */


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.bawei.gujianlong2020218.R;

import butterknife.BindView;
import butterknife.OnClick;

public class MyView extends LinearLayout {
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.button)
    Button button;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.my_view, this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        String s = edit.getText().toString();
        itemClick.onClick(s);
    }

    public interface ItemClick {
        void onClick(String click);
    }

    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }
}
