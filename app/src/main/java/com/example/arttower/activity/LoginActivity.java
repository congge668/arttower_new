package com.example.arttower.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.design.CommonTitle;
import com.example.arttower.model.LoginModel;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginActivity extends BaseMvpActivity<LoginModel> {


    @BindView(R.id.login_title)
    CommonTitle loginTitle;
    @BindView(R.id.phone_num)
    AutoCompleteTextView phoneNum;
    @BindView(R.id.auth_code)
    EditText authCode;
    @BindView(R.id.home_send_code)
    Button sendCode;
    @BindView(R.id.logphon_submit)
    Button submit;
    @BindView(R.id.psd_login)
    LinearLayout psdLogin;
    @BindView(R.id.vault)
    LinearLayout vault;
    @BindView(R.id.login_wechat)
    LinearLayout loginWechat;
    @BindView(R.id.login_qq)
    LinearLayout loginQq;
    @BindView(R.id.login_sina)
    LinearLayout loginSina;
    @BindView(R.id.protocol)
    TextView protocol;
    @BindView(R.id.policy)
    TextView policy;
    private UMShareAPI mShareAPI;
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();
    private String mPhoneNum;
    private String mAuthCode;
    private MyCount mycount;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        mShareAPI = UMShareAPI.get(LoginActivity.this);
        getPermissions();
        location();
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
        Toast.makeText(this, "验证码发送失败", Toast.LENGTH_SHORT).show();
        sendCode.setClickable(true);
        sendCode.setEnabled(true);
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.MOBILECODE_DATA:
                Toast.makeText(this, "验证码发送成功", Toast.LENGTH_SHORT).show();
                sendCode.setEnabled(false);
                mycount = new MyCount(120000, 1000);
                mycount.start();
                break;
            case ApiConfig.MOBILECODENEW_DATA:
                // 通过Bundle传递手机号
                Intent intent = new Intent(this, SetPsdActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("mobile", mPhoneNum);
                intent.putExtras(bundle);
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
            sendCode.setText(millisUntilFinished / 2000 + "");
        }

        @Override
        public void onFinish() {
            sendCode.setText("发送验证码");
            sendCode.setEnabled(true);
            sendCode.setClickable(true);
        }
    }

    @Override
    protected void setStatusBar() {
        super.setStatusBar();
    }

    private void location() {
        mLocationClient = new LocationClient(getApplicationContext());

        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);

        //注册监听函数
        LocationClientOption option = new LocationClientOption();

        option.setIsNeedAddress(true);

        //可选，是否需要地址信息，默认为不需要，即参数为false
        //如果开发者需要获得当前点的地址信息，此处必须为true
        option.setNeedNewVersionRgc(true);
        //可选，设置是否需要最新版本的地址信息。默认需要，即参数为true

        mLocationClient.setLocOption(option);
        //mLocationClient为第二步初始化过的LocationClient对象
        //需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
        //更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明
        mLocationClient.start();
    }


    @OnTextChanged({R.id.phone_num, R.id.auth_code})
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
    @OnClick({R.id.login_title,  R.id.home_send_code,
            R.id.logphon_submit, R.id.psd_login, R.id.vault, R.id.login_wechat,
            R.id.login_qq, R.id.login_sina, R.id.protocol, R.id.policy})
    public void onViewClicked(View view) {
                switch (view.getId()) {
                    case R.id.login_title:

                        break;

            case R.id.phone_num:

                break;
            case R.id.auth_code:

                break;
            case R.id.home_send_code:
                String string = phoneNum.getText().toString();
                if(string.equals("")){
                    Toast.makeText(mApplication, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    //发送验证码
                    if (isCheckoutPhoneOk()) {
                        //请求发送验证码的接口
                        stringFilter(mPhoneNum);
                        mPresenter.getData(ApiConfig.MOBILECODE_DATA, mPhoneNum);
                    }
                }
                break;
                //提交
            case R.id.logphon_submit:
                String s = phoneNum.getText().toString();
                String s1 = authCode.getText().toString();
                    if (isCheckoutOk()) {
                        //请求提交接口
                        mPresenter.getData(ApiConfig.MOBILECODENEW_DATA, mPhoneNum, mAuthCode, "", "", "", "", "ANDROID", "");
                    }
               break;
            case R.id.psd_login:
                startActivity(new Intent(this, PsdLoginActivity.class));
                break;
            case R.id.vault:
                //跳过登录
                //先逛逛
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
                /*微信
                * */
            case R.id.login_wechat:
                mShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.WEIXIN, authListener);
                //WxShareAndLoginUtils.WxLogin(LoginActivity.this);
                break;
                /*
                * QQ
                * */
            case R.id.login_qq:
                mShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, authListener);
                break;
                /*
                *微博
                **/
            case R.id.login_sina:
                mShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.SINA, authListener);
                break;
            case R.id.protocol:
                //用户协议
                break;
            case R.id.policy:
                //隐私政策
                break;
            default:

        }
    }

    /**
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
     * 正则表达式
     */
    public static String stringFilter(String str) {
        String PHONE_PATTERN = "(((13[0-9])|(14[57])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|190|197|196|192)[0-9]{9})";
        Pattern compile = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = compile.matcher(str);
        return matcher.replaceAll("").trim();
    }

    /**
     * 手机号和验证码检测
     */
    private boolean isCheckoutOk() {
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
    //危险权限请求
    private void getPermissions() {

        XXPermissions.with(this).permission(Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {

                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {

                    }
                });
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取地址相关的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明

            String addr = location.getAddrStr();    //获取详细地址信息
            String country = location.getCountry();    //获取国家
            String province = location.getProvince();    //获取省份
            String city = location.getCity();           //获取城市
            String district = location.getDistrict();    //获取区县
            String street = location.getStreet();    //获取街道信息
            String adcode = location.getAdCode();    //获取adcode
            String town = location.getTown();    //获取乡镇信息


            double latitude = location.getLatitude();    //获取纬度信息
            double longitude = location.getLongitude();    //获取经度信息
            float radius = location.getRadius();    //获取定位精度，默认值为0.0f

            String coorType = location.getCoorType();
            //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准
            Log.i("地址", "onReceiveLocation: 地址" + addr + "国家" + country + "省份" + province + "城市" + city + longitude + "          " + latitude);
        }
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

            Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_SHORT).show();
            String uid = data.get("uid");
            String name = data.get("name");
            String gender = data.get("gender");
            String iconurl = data.get("iconurl");
            Log.i("data", "onComplete: " + data.toString());
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_SHORT).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
