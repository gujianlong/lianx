package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.Bean;
import com.example.myapplication.bean.UserBean;
import com.example.myapplication.mvp.Presenter;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends BaseActivity {


    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.image_sheng)
    ImageView imageSheng;
    @BindView(R.id.button_string)
    Button buttonString;
    @BindView(R.id.button_bean)
    Button buttonBean;

    @Override
    protected void startDing() {

    }

    @Override
    protected void initView() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = editName.getText().toString();
                Bitmap image = CodeUtils.createImage(string, 200, 200, null);
                imageSheng.setImageBitmap(image);
            }
        });
        imageSheng.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(imageSheng, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(Main2Activity.this, "成功:" + result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(Main2Activity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
        buttonString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post("啦啦啦啦");
            }
        });
        buttonBean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new Bean("谷建龙", 18));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getBean(Bean bean) {
        Toast.makeText(this, "传值成功:" + bean.getName(), Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void getString(String string) {
        Toast.makeText(this, "传值成功:" + string, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void onSuccess(String url) {

    }

    @Override
    public void onError(Throwable throwable) {

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

}
