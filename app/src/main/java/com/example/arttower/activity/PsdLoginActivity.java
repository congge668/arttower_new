package com.example.arttower.activity;


import android.content.Intent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arttower.BuildConfig;
import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.bean.LoginPasswordBean;
import com.example.arttower.model.PsdLoginModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/*
*
* 密码登录activity
* */
public class PsdLoginActivity extends BaseMvpActivity<PsdLoginModel> {

    @BindView(R.id.phone_num)
    AutoCompleteTextView phoneNum;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_phonenum)
    TextView tvPhoneNum;
    @BindView(R.id.tv_forgetpass)
    TextView tvForgetpass;
    @BindView(R.id.protocol)
    TextView protocol;
    @BindView(R.id.policy)
    TextView policy;
    private String mPhoneNum;
    private String mLoginPassword;

    @Override
    public int getLayoutId() {
        return R.layout.activity_psd_login;
    }

    @OnTextChanged({R.id.phone_num, R.id.login_password})
    void onTextChanged() {
        mPhoneNum = phoneNum.getText().toString();
        mLoginPassword = loginPassword.getText().toString();
        String str = stringFilter(mPhoneNum);
        if (!mPhoneNum.equals(str)) {
            phoneNum.setText(str);
            phoneNum.setSelection(str.length());
        }
        if (!"".equals(mPhoneNum) && !"".equals(mLoginPassword)) {
            //用户名和密码都不为空，提交按钮可点击
            btnLogin.setClickable(true);
        } else {
            //用户名和密码都为空，提交按钮不可点击
            btnLogin.setClickable(false);
        }
    }

    @OnClick({R.id.btn_login, R.id.tv_phonenum, R.id.tv_forgetpass, R.id.protocol, R.id.policy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
//                if (isCheckoutOk()) {
//                    stringFilter(mPhoneNum);
//                    mPresenter.getData(ApiConfig.LOGINPASSWORD_CODE, mPhoneNum, mLoginPassword);
//
//                }
                if (BuildConfig.DEBUG){
                    mPresenter.getData(ApiConfig.LOGINPASSWORD_CODE, "15670774349", "zhou9468");
                }
                break;
            case R.id.tv_phonenum:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
                //去找回密码
            case R.id.tv_forgetpass:
                startActivity(new Intent(this, ForgetPsdActivity.class));
                finish();
                break;
            case R.id.protocol:

                break;
            case R.id.policy:

                break;
        }
    }

    /**
     * 正则表达式
     */
    public static String stringFilter(String str) {
        String PHONE_PATTERN = "(((13[0-9])|(14[57])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|190|197|196|192)[0-9]{9})";
        Pattern compile = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = compile.matcher(str);
        return matcher.replaceAll("").trim();
    }

    /**
     * 用户名和密码检测
     * @return
     */
    private boolean isCheckoutOk() {
        if ("".equals(mPhoneNum) && mPhoneNum != null) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(mLoginPassword) && mLoginPassword != null) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(mLoginPassword.length() >= 6) || !(mLoginPassword.length() <= 12)) {
            Toast.makeText(this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public PsdLoginModel getModel() {
        return new PsdLoginModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        showToast("请求失败");
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.LOGINPASSWORD_CODE:
                LoginPasswordBean loginPasswordBean = (LoginPasswordBean) t[0];
                if (loginPasswordBean.getCode().equals("200000")) {
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    showToast("登录失败");
                }
                break;
        }
    }
}
