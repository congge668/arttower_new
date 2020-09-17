package com.example.arttower.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;

import butterknife.BindView;

/*
 * 我的动态
 * */
public class MyDynamicActivity extends BaseMvpActivity {
    @BindView(R.id.dynamic_web)
    RecyclerView mRlv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_dynamic;
    }

    @Override
    public void initView() {
        mRlv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void initData() {

    }

    @Override
    public Object getModel() {
        return null;
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.MINEDYNAMICSTATE:

                break;
        }
    }
}