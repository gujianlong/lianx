package com.example.lianxi2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lianxi2.adapter.MyAdapter;
import com.example.lianxi2.base.BaseActivity;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.UserBean;
import com.example.lianxi2.mvp.Presenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.eLv)
    ExpandableListView eLv;
    @BindView(R.id.check)
    CheckBox check;
    @BindView(R.id.TotalPrice)
    TextView TotalPrice;
    @BindView(R.id.TotalNum)
    Button TotalNum;
    private ExpandableListView expandableListView;
    private MyAdapter myAdapter;

    @Override
    protected void startDing() {
        mPresenter.getInfoParams();

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
    public void onClassSuccess(UserBean homeBean) {
        List<UserBean.ResultBean> result = homeBean.getResult();
        myAdapter = new MyAdapter(this, result);
        eLv.setAdapter(myAdapter);
        for (int i = 0; i < result.size(); i++) {
            eLv.expandGroup(i);
        }
        myAdapter.setOnCartClickListensr(new MyAdapter.OnCartClickListensr() {
            @Override
            public void onClickListener() {
                TotalPrice.setText("总价是:$" + myAdapter.calculateTotalPrice());
                TotalNum.setText("去结算(" + myAdapter.calculateTotalSum() + ")");
                check.setChecked(myAdapter.calculateTotalCheck());
                //Toast.makeText(MainActivity.this, "总价是" + myAdapter.calculateTotalPrice() + "总数量是" + myAdapter.calculateTotalSum(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClassError(Throwable throwable) {

    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {

    }

    @Override
    public void onOrderError(Throwable throwable) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.check, R.id.TotalNum})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.check:
                if (myAdapter != null) {
                    boolean b = myAdapter.calculateTotalCheck();
                    b = !b;
                    myAdapter.calculateTotalStart(b);
                    TotalPrice.setText("总价是:$" + myAdapter.calculateTotalPrice());
                    TotalNum.setText("去结算(" + myAdapter.calculateTotalSum() + ")");
                    check.setChecked(myAdapter.calculateTotalCheck());
                }
                break;
            case R.id.TotalNum:
                break;
        }
    }
}
