package com.bawei.gujianlong20191231;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.gujianlong20191231.base.BaseActivity;
import com.bawei.gujianlong20191231.base.BasePresenter;
import com.bawei.gujianlong20191231.mvp.Presenter;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends BaseActivity {

    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.image_name)
    ImageView imageName;
    @BindView(R.id.button_WeiXin)
    Button buttonWeiXin;
    @BindView(R.id.button_QQ)
    Button buttonQQ;

    @Override
    protected void startDing() {

    }

    @Override
    protected void initView() {
        textName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = textName.getText().toString();
                Bitmap image = CodeUtils.createImage(string, 400, 400, null);
                imageName.setImageBitmap(image);
            }
        });
        imageName.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(imageName, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(Main2Activity.this, "成功" + result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(Main2Activity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
        buttonWeiXin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post("微信");
            }
        });
        buttonQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post("QQ");
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getString(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void getJson(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
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

    //注册
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }
    //解绑

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
