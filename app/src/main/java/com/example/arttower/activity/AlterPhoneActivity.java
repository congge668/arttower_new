package com.example.arttower.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;

import butterknife.BindView;
import butterknife.OnClick;

public class AlterPhoneActivity extends BaseMvpActivity {
    @BindView(R.id.alter_return)
    ImageView mAlterReturn;
    @BindView(R.id.alter_gain_code)
    Button mAlterGainCode;

    @BindView(R.id.alter_button_next)
    Button mAlterButtonNext;
    //手机号
    @BindView(R.id.alter_ed_phone)
    EditText mAlterEdPhone;
    //验证码
    @BindView(R.id.alter_ed_code)
    EditText mAlterEdCode;

    @Override
    public int getLayoutId() {
        return R.layout.activity_alter_phone;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.alter_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.alter_return:
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