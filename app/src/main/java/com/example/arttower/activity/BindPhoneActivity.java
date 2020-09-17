package com.example.arttower.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.model.BindPhoneModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;

/*
*
* */
public class BindPhoneActivity extends BaseMvpActivity<BindPhoneModel> {

    @BindView(R.id.bind_phone)
    AutoCompleteTextView bindPhone;
    @BindView(R.id.bind_auth_code)
    EditText bindAuthCode;
    @BindView(R.id.bind_send_code)
    Button bindSendCode;
  /*@BindView(R.id.submit)
    Button submit;*/

    private String mPhoneNum;
    private String mAuthCode;

    @Override
    public int getLayoutId() {
        return R.layout.activity_bind_phone;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public BindPhoneModel getModel() {
        return new BindPhoneModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        Toast.makeText(this,"验证码发送失败", Toast.LENGTH_SHORT).show();
        bindSendCode.setClickable(true);
        bindSendCode.setEnabled(true);
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.MOBILECODE_DATA:
                Toast.makeText(this, "验证码发送成功", Toast.LENGTH_SHORT).show();
                bindSendCode.setEnabled(false);
                MyCount mycount = new MyCount(120000, 1000);
/*
                * 启动验证码计时器
                * */

                mycount.start();

                break;
            case ApiConfig.LOGINMOBILE_CODE:
                //提交
                Intent intent = new Intent(this, SetPsdActivity.class);
                startActivity(intent);
                break;
        }
    }

/*
     * 验证码计时器*/


    public class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            bindSendCode.setText(millisUntilFinished / 1000 + "");
        }

        @Override
        public void onFinish() {
            bindSendCode.setText("发送验证码");
            bindSendCode.setEnabled(true);
            bindSendCode.setClickable(true);
        }
    }

   /* @OnTextChanged({R.id.phone_num,R.id.auth_code}) void onTextChanged() {
        mPhoneNum = bindPhone.getText().toString();
        mAuthCode = bindAuthCode.getText().toString();
        String str = stringFilter(mPhoneNum);
        if(!mPhoneNum.equals(str)){
            bindPhone.setText(str);
            bindPhone.setSelection(str.length());
        }
        if(!"".equals(mPhoneNum) && !"".equals(mAuthCode)){
            //手机号码和验证码都不为空，提交按钮可点击
            submit.setClickable(true);
        }else{
            //手机号码和验证码都为空，提交按钮不可点击
            submit.setClickable(false);
        }
    }
    @OnClick({R.id.bind_send_code, R.id.submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bind_send_code:
                //发送验证码
                if(isCheckoutPhoneOk()){
                    //请求发送验证码的接口
                    mPresenter.getData(ApiConfig.MOBILECODE_DATA,mPhoneNum);
                }
                break;
            case R.id.submit:
                if(isCheckoutOk()){
                    //请求提交接口
                    mPresenter.getData(ApiConfig.LOGINMOBILE_CODE,mPhoneNum,mAuthCode);
                }
                break;
        }
    }
*/
    /* * 手机号码检测*/


    private boolean isCheckoutPhoneOk(){
        if(mPhoneNum.length() != 11){
            Toast.makeText(this,"请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if("".equals(mPhoneNum)){
            Toast.makeText(this,"请输入手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

/*
     * 正则表达式*/


    public static String stringFilter(String str) {
        String PHONE_PATTERN = "(((13[0-9])|(14[57])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|190|197|196|192)[0-9]{9})";
        Pattern compile = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = compile.matcher(str);
        return matcher.replaceAll("").trim();
    }

   /*  * 手机号和验证码检测*/


    private boolean isCheckoutOk(){
        if(mPhoneNum.length() != 11){
            Toast.makeText(this,"请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if("".equals(mPhoneNum)){
            Toast.makeText(this,"请输入手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if("".equals(mAuthCode)){
            Toast.makeText(this,"请输入验证码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(mAuthCode.length() != 6){
            Toast.makeText(this,"请输入正确的验证码", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
