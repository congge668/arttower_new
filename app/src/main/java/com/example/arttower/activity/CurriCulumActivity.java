package com.example.arttower.activity;

import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;

import butterknife.BindView;

/*
 * 他人课程
 * */
public class CurriCulumActivity extends BaseMvpActivity {
    @BindView(R.id.kecheng_rlv)
    RecyclerView mkechengrlv;


    @Override
    public int getLayoutId() {
        return R.layout.activity_curriculum;
    }

    @Override
    public void initView() {


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

    }
}
