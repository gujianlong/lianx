package com.example.lianxi3.weight;
/*
 *@auther:谷建龙
 *@Date: 2019/12/20
 *@Time:15:48
 *@Description:
 * */


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.lianxi3.R;

public class MyView extends LinearLayout {
    private TextView jian;
    private TextView count;
    private TextView jia;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.item, this);
        jia = findViewById(R.id.jia);
        jian = findViewById(R.id.jian);
        count = findViewById(R.id.count);
        jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(count.getText().toString());
                i++;
                count.setText(i + "");
                if (itemCount != null) {
                    itemCount.setItemCount(i);
                }
            }
        });
        jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(count.getText().toString());
                if (i > 1) {
                    i--;
                    count.setText(i + "");
                    if (itemCount != null) {
                        itemCount.setItemCount(i);
                    }
                } else {
                    Toast.makeText(getContext(), "数量最少为1", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public interface ItemCount {
        void setItemCount(int unmber);
    }

    private static ItemCount itemCount;

    public static void setItemCount(ItemCount itemCount) {
        MyView.itemCount = itemCount;
    }
}
