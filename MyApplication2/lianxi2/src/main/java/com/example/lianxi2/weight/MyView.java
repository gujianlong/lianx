package com.example.lianxi2.weight;
/*
 *@auther:谷建龙
 *@Date: 2020/1/8
 *@Time:11:29
 *@Description:
 * */


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.lianxi2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyView extends LinearLayout {
    @BindView(R.id.rv_jian)
    TextView rvJian;
    @BindView(R.id.rv_sum)
    TextView rvSum;
    @BindView(R.id.rv_add)
    TextView rvAdd;
    private int sum = 1;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.my_view, this);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rv_jian, R.id.rv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rv_jian:
                if (sum > 1) {
                    sum--;
                    rvSum.setText("" + sum);
                    if (onItemClick != null) {
                        onItemClick.itemClick(sum);
                    }
                } else {
                    Toast.makeText(getContext(), "不能再减了", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.rv_add:
                sum++;
                rvSum.setText("" + sum);
                if (onItemClick != null) {
                    onItemClick.itemClick(sum);
                }
                break;
        }
    }
    OnItemClick onItemClick;
    public interface OnItemClick {
        void itemClick(int click);
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }



    public void setSum(int sum) {
        this.sum = sum;
        rvSum.setText(""+sum);
    }
}
