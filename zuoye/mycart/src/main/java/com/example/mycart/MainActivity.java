package com.example.mycart;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.mycart.adapter.CartAdapter;
import com.example.mycart.base.BaseAcivity;
import com.example.mycart.base.BasePresenter;
import com.example.mycart.bean.CartBean;
import com.example.mycart.mvp.Presenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseAcivity {

    @BindView(R.id.lv)
    ExpandableListView lv;
    @BindView(R.id.check)
    CheckBox check;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.button)
    Button button;
    //private List<CartBean.ResultBean> list = new ArrayList<>();
    private CartAdapter cartAdapter;

    @Override
    protected void startDing() {
        mPresenter.getDataCart(27909, "158106149012327909");
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void mySuccessCart(CartBean cartBean) {
        List<CartBean.ResultBean> result = cartBean.getResult();
        cartAdapter = new CartAdapter(result, this);
        lv.setAdapter(cartAdapter);
        cartAdapter.setItemClick(new CartAdapter.ItemClick() {
            @Override
            public void onClick() {
                check.setChecked(cartAdapter.toutalChecked());
                price.setText("价格:$" + cartAdapter.toutalPrice());
                button.setText("数量(" + cartAdapter.toutalNumber() + ")");
            }
        });


        for (int i = 0; i < result.size(); i++) {
            lv.expandGroup(i);
        }
        cartAdapter.notifyDataSetChanged();

    }

    @Override
    public void myErrorCart(Throwable throwable) {

    }




    @OnClick(R.id.check)
    public void onViewClicked() {
        //拿到旧状态
        boolean b = cartAdapter.toutalChecked();
        //直返他
        b=!b;
        cartAdapter.toutalAllChecked(b);
        //cartAdapter.notifyDataSetChanged();
        price.setText("价格:$" + cartAdapter.toutalPrice());
        button.setText("数量(" + cartAdapter.toutalNumber() + ")");
    }
}
