package com.example.lianxi;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lianxi.bean.Beanl;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.button_image)
    Button buttonImage;
    @BindView(R.id.image)
    ImageView image_a;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        CodeUtils.init(this);
        EventBus.getDefault().register(SecondActivity.this);
        image_a.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(image_a, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(SecondActivity.this, "成功:" + result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(SecondActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(SecondActivity.this);
    }

    @OnClick({R.id.button_image, R.id.button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_image:
                String string = edit.getText().toString();
                Bitmap image = CodeUtils.createImage(string, 200, 200, null);
                image_a.setImageBitmap(image);
                break;
            case R.id.button:
                EventBus.getDefault().post(new Beanl("冯英超",10));
                break;
        }
    }
    @Subscribe
    public void onBeanBean(Beanl beanl){
        Toast.makeText(this, "接收成功"+beanl.getName(), Toast.LENGTH_SHORT).show();
    }
    @Subscribe
    public void onGetBean(String string) {
        Toast.makeText(this, "接收成功" + string, Toast.LENGTH_SHORT).show();
    }
}
