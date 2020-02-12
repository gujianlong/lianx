package com.example.gujianlongnetsample2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edit_content)
    EditText editContent;
    @BindView(R.id.button_create)
    Button buttonCreate;
    @BindView(R.id.button_camera)
    Button buttonCamera;
    @BindView(R.id.button_photos)
    Button buttonPhotos;
    @BindView(R.id.image_picture)
    ImageView imagePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CodeUtils.init(this);
        imagePicture.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(imagePicture, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(MainActivity.this, "长按识别成功"+result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(MainActivity.this, "长按识别失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
    }

    @OnClick({R.id.button_create, R.id.button_camera, R.id.button_photos})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_create:
                String s = editContent.getText().toString();
                Bitmap image = CodeUtils.createImage(s, 300, 300, null);
                imagePicture.setImageBitmap(image);
                break;
            case R.id.button_camera:
                CodeUtils.analyzeByCamera(this);
                break;
            case R.id.button_photos:
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
                Toast.makeText(MainActivity.this, "识别成功"+result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(MainActivity.this, "识别失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
