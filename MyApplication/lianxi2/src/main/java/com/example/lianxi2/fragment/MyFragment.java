package com.example.lianxi2.fragment;
/*
 *@auther:谷建龙
 *@Date: 2019/12/18
 *@Time:20:23
 *@Description:
 * */


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.lianxi2.R;
import com.example.lianxi2.Signin;
import com.example.lianxi2.base.BaseFragment;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.mvp.Presenter;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class MyFragment extends BaseFragment {

    private ImageView imageView;
    private TextView deng;

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View inflate) {
        imageView = inflate.findViewById(R.id.image);
        deng = inflate.findViewById(R.id.text_deng);
    }

    @Override
    protected int layputId() {
        return R.layout.my_fragment;
    }

    @Override
    protected void startDing() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 100);
            }
        });
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Signin.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Uri data1 = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data1);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }
}
