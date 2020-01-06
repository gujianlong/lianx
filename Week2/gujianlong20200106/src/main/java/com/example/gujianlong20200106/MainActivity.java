package com.example.gujianlong20200106;

import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong20200106.adapter.OneAdapter;
import com.example.gujianlong20200106.adapter.TwoAdapter;
import com.example.gujianlong20200106.base.BaseActivity;
import com.example.gujianlong20200106.base.BasePresenter;
import com.example.gujianlong20200106.bean.HomeBean;
import com.example.gujianlong20200106.bean.ItemBean;
import com.example.gujianlong20200106.database.DaoMaster;
import com.example.gujianlong20200106.database.DaoMaster.DevOpenHelper;
import com.example.gujianlong20200106.database.DaoSession;
import com.example.gujianlong20200106.database.JsonBeanDao;
import com.example.gujianlong20200106.mvp.Presenter;
import com.example.gujianlong20200106.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.one_rv)
    RecyclerView oneRv;
    @BindView(R.id.two_rv)
    RecyclerView twoRv;
    private List<String> oneList = new ArrayList<>();
    private List<ItemBean.DataBean> twoList = new ArrayList<>();
    private OneAdapter oneAdapter;
    private TwoAdapter twoAdapter;

    @Override
    protected void startDing() {
        DaoSession daoSession = DaoMaster.newDevSession(this, "app.db");
        JsonBeanDao jsonBeanDao = daoSession.getJsonBeanDao();
        if (NetUtils.getInstance().hasNet(this)) {
            mPresenter.getInfoNo();
        }else {
            Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();
        }

        oneAdapter = new OneAdapter(this, oneList);
        oneRv.setAdapter(oneAdapter);
        twoAdapter = new TwoAdapter(this, twoList);
        twoRv.setAdapter(twoAdapter);
        oneAdapter.setItemClick(new OneAdapter.ItemClick() {
            @Override
            public void onClick(int position) {
                EventBus.getDefault().post(oneList.get(position));
            }
        });
    }

    @Override
    protected void initView() {
        oneRv = findViewById(R.id.one_rv);
        oneRv.setLayoutManager(new LinearLayoutManager(this));
        twoRv = findViewById(R.id.two_rv);
        twoRv.setLayoutManager(new GridLayoutManager(this, 2));
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
    public void onClassSuccess(HomeBean homeBean) {
        List<String> beanCategory = homeBean.getCategory();
        oneList.addAll(beanCategory);
        oneAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClassError(Throwable throwable) {

    }

    @Override
    public void onCommitSuccess(ItemBean itemBean) {
        twoList.clear();
        twoList.addAll(itemBean.getData());
        twoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCommitError(Throwable throwable) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void getJson(String string){
        mPresenter.getInfoParams(string);
    }
}
