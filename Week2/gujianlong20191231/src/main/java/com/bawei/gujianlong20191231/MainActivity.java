package com.bawei.gujianlong20191231;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.gujianlong20191231.adapter.MyAdapter;
import com.bawei.gujianlong20191231.base.BaseActivity;
import com.bawei.gujianlong20191231.base.BasePresenter;
import com.bawei.gujianlong20191231.bean.UserBean;
import com.bawei.gujianlong20191231.mvp.Presenter;
import com.bawei.gujianlong20191231.utils.NetUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.text_text)
    TextView textText;
    @BindView(R.id.rv)
    RecyclerView rv;
    private List<UserBean.RankingBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void startDing() {
        myAdapter = new MyAdapter(this, list);
        rv.setAdapter(myAdapter);
        myAdapter.setItemClick(new MyAdapter.ItemClick() {
            @Override
            public void onItem(int position) {
                Toast.makeText(MainActivity.this, "昵称" + position, Toast.LENGTH_SHORT).show();
            }
        });
        if (NetUtils.getInstance().hasNet(this)) {
            mPresenter.getInfo("http://blog.zhaoliang5156.cn/api/news/ranking.json");
        } else {
            Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        textText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
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
    public void onSuccess(String url) {
        Gson gson = new Gson();
        UserBean userBean = gson.fromJson(url, UserBean.class);
        list.addAll(userBean.getRanking());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Throwable throwable) {

    }

}
