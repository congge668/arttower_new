package com.example.arttower.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.design.CommonTitle;

import butterknife.BindView;
import butterknife.OnClick;

/*
* 修改手机号完成页面
* */
public class AlterSucceedActivity extends BaseMvpActivity {

    @BindView(R.id.alter_succeed)
    Button mAlterSucceed;

    @BindView(R.id.alter_title)
    CommonTitle commonTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_alter_succeed;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.alter_succeed})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.alter_succeed:
                startActivity(new Intent(this, MySecurityPrivacyActivity.class));
                finish();
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