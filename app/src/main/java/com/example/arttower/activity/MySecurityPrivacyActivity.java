package com.example.arttower.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.fragment.MinePage.view.AlterPasswordActivity;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 安全隐私
 * */
public class MySecurityPrivacyActivity extends BaseMvpActivity {
    @BindView(R.id.security_pay_psd)
    LinearLayout securitypaypsd;
    @BindView(R.id.alter_password)
    LinearLayout mAlter_Password;

    @BindView(R.id.security_phone)
    ImageView securityphone;
    @BindView(R.id.security_wx)
    ImageView securitywx;


    @Override
    public int getLayoutId() {
        return R.layout.activity_my_security_privacy;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.security_phone, R.id.alter_password,
            R.id.security_wx, R.id.security_pay_psd,
    })

    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.security_phone:
                startActivity(new Intent(this, ModifyPhoneActivity.class));
                break;
            case R.id.security_wx:

                break;
            case R.id.alter_password:
                startActivity(new Intent(this, AlterPasswordActivity.class));
                break;
            case R.id.security_pay_psd:
                Intent intent = new Intent(this, AlterPayPasswordActivity.class);
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
