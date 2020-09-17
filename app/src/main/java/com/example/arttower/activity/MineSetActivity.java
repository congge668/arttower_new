package com.example.arttower.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;

import butterknife.BindView;
import butterknife.OnClick;

/*
*
* 我的设置页面
* */

public class MineSetActivity extends BaseMvpActivity {

    @BindView(R.id.ll_data)
    LinearLayout llData;
    @BindView(R.id.ll_safe)
    LinearLayout llSafe;
    @BindView(R.id.switch_slecter)
    Switch switchSlecter;
    @BindView(R.id.ll_clear)
    LinearLayout llClear;
    @BindView(R.id.ll_about)
    LinearLayout llAbout;
    @BindView(R.id.ll_agreement)
    LinearLayout llAgreement;
    @BindView(R.id.ll_question)
    LinearLayout llQuestion;
    @BindView(R.id.ll_update)
    LinearLayout llUpdate;
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_set;
    }

    @OnClick({R.id.ll_data, R.id.ll_safe, R.id.switch_slecter, R.id.ll_clear, R.id.ll_about, R.id.ll_agreement, R.id.ll_question, R.id.ll_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_data:
              startActivity(new Intent(this, MainZhanghuActivity.class));
                break;
            case R.id.ll_safe:
               startActivity(new Intent(this, MySecurityPrivacyActivity.class));
                break;
                //自动更新
            case R.id.switch_slecter:

                break;
                //清除缓存
            case R.id.ll_clear:

                break;
                //关于
            case R.id.ll_about:

                break;
                //用户协议
            case R.id.ll_agreement:

                break;
                //问题反馈
            case R.id.ll_question:

                break;
                //检查更新
            case R.id.ll_update:

                break;
        }
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
