package com.example.my;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my.bean.Bean;
import com.example.my.database.BeanDao;
import com.example.my.database.DaoMaster;
import com.example.my.database.DaoSession;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button query;
    private Button insert;
    private Button update;
    private Button delete;
    private BeanDao beanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        DaoSession daoSession = DaoMaster.newDevSession(this, "app.db");
        beanDao = daoSession.getBeanDao();

    }

    private void initView() {
        query = (Button) findViewById(R.id.query);
        insert = (Button) findViewById(R.id.insert);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);

        query.setOnClickListener(this);
        insert.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.query:

                break;
            case R.id.insert:
                Bean bean = new Bean(null, "王楚", 50);
                beanDao.insert(bean);
                break;
            case R.id.update:

                break;
            case R.id.delete:

                break;
        }
    }
}
