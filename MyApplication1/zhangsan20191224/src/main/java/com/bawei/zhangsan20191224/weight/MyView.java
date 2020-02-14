package com.bawei.zhangsan20191224.weight;
/*
 *@auther:谷建龙
 *@Date: 2019/12/24
 *@Time:17:17
 *@Description:
 * */


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bawei.zhangsan20191224.R;

public class MyView extends LinearLayout {

    private final TextView jia;
    private final TextView jian;
    private final TextView count;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View inflate = View.inflate(context, R.layout.item, this);
        jia = findViewById(R.id.jia);
        jian = findViewById(R.id.jian);
        count = findViewById(R.id.count);
        jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(count.getText().toString());
                i++;
                count.setText(i + "");
                if (itemClick != null) {
                    itemClick.onItem(i);
                }
            }
        });
        jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(count.getText().toString());
                if (i > 0) {
                    i--;
                    count.setText(i + "");
                    if (itemClick != null) {
                        itemClick.onItem(i);
                    }
                } else {
                    Toast.makeText(getContext(), "商品最小为1", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public interface ItemClick {
        void onItem(int position);
    }

    private ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }
}
