package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Generate_Text)
    EditText GenerateText;
    @BindView(R.id.Generate_Btn)
    Button GenerateBtn;
    @BindView(R.id.Open_Camera)
    Button OpenCamera;
    @BindView(R.id.My_Image)
    ImageView MyImage;
    @BindView(R.id.Get_Text)
    TextView GetText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CodeUtils.init(this);
    }

    @OnClick({R.id.Generate_Btn, R.id.Open_Camera})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Generate_Btn:
                break;
            case R.id.Open_Camera:
                break;
        }
    }
}
