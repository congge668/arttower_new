package com.example.arttower.activity;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.design.CommonTitle;
import com.example.arttower.model.LoginModel;

import butterknife.BindView;
import butterknife.OnClick;

public class RetrievepsdActivity extends BaseMvpActivity<LoginModel> {

    @BindView(R.id.retrieveTitle)
    CommonTitle retrieveTitle;
    @BindView(R.id.ic_head)
    ImageView icHead;
    @BindView(R.id.phone_num)
    AutoCompleteTextView phoneNum;
    @BindView(R.id.auth_code)
    EditText authCode;
    @BindView(R.id.send_code)
    Button sendCode;
    @BindView(R.id.bt_next)
    Button btNext;

    @Override
    public int getLayoutId() {
        return R.layout.activity_retrievepsd;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.ic_head, R.id.phone_num, R.id.auth_code, R.id.send_code, R.id.bt_next})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.send_code:

                break;
            case R.id.bt_next:

                break;
        }
    }
}
