package com.example.a;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a.utils.NetUtils;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.button_image)
    Button buttonImage;
    @BindView(R.id.button_cr)
    Button buttonCr;
    @BindView(R.id.button_im)
    Button buttonIm;
    @BindView(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CodeUtils.init(this);
        image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(image, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(MainActivity.this, "成功:" + result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
        HashMap<String, String> map = new HashMap<>();
        map.put("phone","15751701319");
        map.put("pwd","123");
        NetUtils.getInstance().postInfo("http://172.17.8.100/small/user/v1/login", map, new NetUtils.MyCallBack() {
            @Override
            public void onSuccess(String url) {
                Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable throwable) {
                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
//        NetUtils.getInstance().getInfo("http://blog.zhaoliang5156.cn/api/student/clazzstudent.json", new NetUtils.MyCallBack() {
//            @Override
//            public void onSuccess(String url) {
//                Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @OnClick({R.id.button_image, R.id.button_cr, R.id.button_im})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_image:
                String string = edit.getText().toString();
                //BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)
                Bitmap bitmap = CodeUtils.createImage(string, 200, 200, null);
                image.setImageBitmap(bitmap);
                break;
            case R.id.button_cr:
                CodeUtils.analyzeByCamera(this);
                break;
            case R.id.button_im:
                CodeUtils.analyzeByPhotos(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CodeUtils.onActivityResult(this, requestCode, resultCode, data, new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Toast.makeText(MainActivity.this, "成功" + result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
