package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.Cache;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.utils.EncryptUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str = null;
        try {
            str = EncryptUtil.encrypt("g123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("aa",str);
    }
}
