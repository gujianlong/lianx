package com.example.gujianlong221.weight;
/*
 *@auther:谷建龙
 *@Date: 2020/3/5
 *@Time:16:32
 *@Description:
 * */


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gujianlong221.R;

public class WeightView extends ListView {

    private TextView mName;

    public WeightView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View inflate = View.inflate(context, R.layout.list, this);
        initView(inflate);
    }

    private void initView(View inflate) {
        mName = inflate.findViewById(R.id.name);
    }


}
