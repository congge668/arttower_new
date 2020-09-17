package com.example.arttower.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.design.CommonTitle;
import com.example.arttower.model.ForgetPsdModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/*
 * 找回密码手机号验证
 * */
public class ForgetPsdActivity extends BaseMvpActivity<ForgetPsdModel> {
    @BindView(R.id.login_title)
    CommonTitle loginTitle;

    @BindView(R.id.zhaohui_phone_num)
    AutoCompleteTextView phoneNum;
    @BindView(R.id.zhaohui_auth_code)
    EditText authCode;
    @BindView(R.id.send_code)
    Button sendCode;
    @BindView(R.id.forgetpsd_next)
    Button submit;
    private String mPhoneNum;
    private String mAuthCode;

    @Override
    public int getLayoutId() {
        return R.layout.activity_forgetpsd;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public ForgetPsdModel getModel() {
        return new ForgetPsdModel();
    }

    @OnTextChanged({R.id.zhaohui_phone_num, R.id.zhaohui_auth_code})
    void onTextChanged() {
        mPhoneNum = phoneNum.getText().toString();
        mAuthCode = authCode.getText().toString();
        String str = stringFilter(mPhoneNum);
        if (!mPhoneNum.equals(str)) {
            phoneNum.setText(str);
            phoneNum.setSelection(str.length());
        }
        if (!"".equals(mPhoneNum) && !"".equals(mAuthCode)) {
            //手机号码和验证码都不为空，提交按钮可点击
            submit.setClickable(true);
        } else {
            //手机号码和验证码都为空，提交按钮不可点击
            submit.setClickable(false);
        }
    }

    @OnClick({R.id.send_code, R.id.forgetpsd_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.send_code:
                //发送验证码
                if (isCheckoutPhoneOk()) {
                    stringFilter(mPhoneNum);
                    //请求发送验证码的接口
                    mPresenter.getData(ApiConfig.ALTERFORPSDCODE, mPhoneNum);
                }
                break;
            case R.id.forgetpsd_next:
                if (isCheckoutOk()) {
                    //请求提交接口
                    mPresenter.getData(ApiConfig.ALTERFORPSDCODEEQUST, mPhoneNum, mAuthCode);
                }
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
     * 手机号码检测
     */
    private boolean isCheckoutPhoneOk() {
        if (phoneNum.length() != 11) {
            Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(phoneNum)) {
            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * 手机号和验证码检测
     */
    private boolean isCheckoutOk() {
        if (phoneNum.length() != 11) {
            Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(phoneNum)) {
            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(authCode)) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (authCode.length() != 6) {
            Toast.makeText(this, "请输入正确的验证码", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        Toast.makeText(this, "验证码发送失败", Toast.LENGTH_SHORT).show();
        sendCode.setClickable(true);
        sendCode.setEnabled(true);
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.ALTERFORPSDCODE:
                Toast.makeText(this, "验证码发送成功", Toast.LENGTH_SHORT).show();
                sendCode.setEnabled(false);
                MyCount mycount = new MyCount(120000, 2000);
                mycount.start();

                break;
            case ApiConfig.ALTERFORPSDCODEEQUST:
                Intent intent = new Intent(this, FindPsdAcitivity.class);
               intent.putExtra("mobile", mPhoneNum);
                //提交
                startActivity(intent);
                break;
        }
    }

    /**
     * 验证码计时器
     */
    public class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            sendCode.setText(millisUntilFinished / 1000 + "");
        }

        @Override
        public void onFinish() {
            sendCode.setText("发送验证码");
            sendCode.setEnabled(true);
            sendCode.setClickable(true);
        }
    }

}
