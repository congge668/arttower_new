package com.example.arttower.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 修改支付密码获取手机号和验证码
 * */
public class AlterPayPasswordActivity extends BaseMvpActivity {
    @BindView(R.id.alterzhifu_next)
    Button mNext;

    @Override
    public int getLayoutId() {
        return R.layout.activity_alter_pay_password;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.alterzhifu_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.alterzhifu_next:
                Intent intent = new Intent(this,PaypasswordOneActivity.class );
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