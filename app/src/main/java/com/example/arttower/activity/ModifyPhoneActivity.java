package com.example.arttower.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.Frame.Token;
import com.example.arttower.R;
import com.example.arttower.bean.AlterUserBean;
import com.example.arttower.bean.AlterphoneBean;
import com.example.arttower.model.SecurityPrivacyModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/*
 * 修改手机号
 * */
public class ModifyPhoneActivity extends BaseMvpActivity<SecurityPrivacyModel> {
    @BindView(R.id.modify_bt_getcode)
    Button modifybtgetcode;

    @BindView(R.id.modify_ed_code)
    EditText modifyedcode;

    @BindView(R.id.modify_ed_phone)
    EditText modifyedphone;

    @BindView(R.id.modify_next)
    Button modifynext;


    private String mPhoneNum;
    private String mAuthCode;


    @Override

    public int getLayoutId() {
        return R.layout.activity_modify_phone;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }

    @OnTextChanged({R.id.modify_ed_code, R.id.modify_ed_phone})
    void onTextChanged() {
        mPhoneNum = modifyedphone.getText().toString();
        mAuthCode = modifyedcode.getText().toString();
        String str = stringFilter(mPhoneNum);
        if (!mPhoneNum.equals(str)) {
            modifyedphone.setText(str);
        }
        if (!"".equals(mPhoneNum) && !"".equals(mAuthCode)) {
            //手机号码和验证码都不为空，提交按钮可点击
            modifynext.setClickable(true);
        } else {
            //手机号码和验证码都为空，提交按钮不可点击
            modifynext.setClickable(false);
        }
        //手机号为空获取验证码不可点击
        if (mPhoneNum.equals("")){
        modifyedcode.setClickable(false);
        }
    }

    @OnClick({R.id.modify_next, R.id.modify_bt_getcode})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            //下一步
            case R.id.modify_next:
                if (isCheckoutOk()) {
                    String cookie = Token.getCookie();
                    mPresenter.getData(ApiConfig.ALTERPHONE, mPhoneNum, mAuthCode, cookie);

                }
                finish();
                break;
            case R.id.modify_bt_getcode:
                //发送验证码
                    if (isCheckoutPhoneOk()) {
                        //请求发送验证码的接口
                        stringFilter(mPhoneNum);
                        MyCount mycount = new MyCount(120000, 1000);
                        mycount.start();
                        mPresenter.getData(ApiConfig.ALTERPHONECODE, mPhoneNum);
                    }
                    break;


        }
    }

    @Override
    public SecurityPrivacyModel getModel() {
        return new SecurityPrivacyModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.ALTERPHONECODE:
                Toast.makeText(mApplication, "失败", Toast.LENGTH_SHORT).show();
                break;
            case ApiConfig.ALTERPHONE:
                Toast.makeText(mApplication, "失败", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.ALTERPHONECODE:
                AlterUserBean alterUserBean = (AlterUserBean) t[0];
                String string = alterUserBean.getMsg();
                Toast.makeText(mApplication, string, Toast.LENGTH_SHORT).show();
                break;
        }
        switch (whichApi) {
            case ApiConfig.ALTERPHONE:
                AlterphoneBean alterphoneBean = (AlterphoneBean) t[0];
                String msg = alterphoneBean.getMsg();
                Toast.makeText(mApplication, msg, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, AlterSucceedActivity.class);
                startActivity(intent);
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

    /*
     * 手机号码检测
     */
    private boolean isCheckoutPhoneOk() {

        if (mPhoneNum.length() != 11) {
            Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(mPhoneNum)) {
            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * 手机号和验证码检测
     */
    private boolean isCheckoutOk() {
        if ("".equals(mPhoneNum)) {
            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mPhoneNum.length() != 11) {
            Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(mAuthCode)) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mAuthCode.length() != 6) {
            Toast.makeText(this, "验证码不匹配", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
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
            modifybtgetcode.setText(millisUntilFinished / 2000 + "");
        }

        @Override
        public void onFinish() {
            modifybtgetcode.setText("发送验证码");
            modifybtgetcode.setEnabled(true);
            modifybtgetcode.setClickable(true);
        }
    }


}
