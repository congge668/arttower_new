package com.example.arttower.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 余额页面
 * */
public class MoneyChongActivity extends BaseMvpActivity {
    @BindView(R.id.up_lijirecharge)//立即充值
            Button mLiJiRecharge;

    @Override
    public int getLayoutId() {
        return R.layout.activity_money_chong;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.up_lijirecharge})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.up_lijirecharge:
                Intent intent = new Intent(this, ChongZhiWuBiActivity.class);
                startActivity(intent);
                break;
        }
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