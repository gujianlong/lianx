package com.example.myapplication2;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button xing;
    private Button jiao;
    private GenericDraweeHierarchyBuilder builder;
    private Uri uri;
    private RoundingParams roundingParams;
    private SimpleDraweeView sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        uri = Uri.parse("http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg");
        builder = new GenericDraweeHierarchyBuilder(getResources());

    }

    private void initView() {
        xing = (Button) findViewById(R.id.xing);
        jiao = (Button) findViewById(R.id.jiao);

        xing.setOnClickListener(this);
        jiao.setOnClickListener(this);
        sd = findViewById(R.id.sd);
        sd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xing:
                roundingParams = RoundingParams.asCircle();
                GenericDraweeHierarchy build = builder.setRoundingParams(roundingParams).build();
                sd.setHierarchy(build);
                sd.setImageURI(uri);
                break;
            case R.id.jiao:
                roundingParams=RoundingParams.fromCornersRadius(50f);
                GenericDraweeHierarchy hierarchy = builder.setRoundingParams(roundingParams).build();
                sd.setHierarchy(hierarchy);
                sd.setImageURI(uri);
                break;
        }
    }
}
