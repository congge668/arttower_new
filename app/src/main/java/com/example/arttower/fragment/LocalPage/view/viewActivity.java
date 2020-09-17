package com.example.arttower.fragment.LocalPage.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arttower.R;
import com.example.arttower.aliplayer.view.AliyunListPlayerView;

public class viewActivity extends AppCompatActivity {

    private AliyunListPlayerView mAliyunview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        initView();
    }

    private void initView() {
        mAliyunview = (AliyunListPlayerView) findViewById(R.id.aliyunview);

    }
}