package com.example.arttower.fragment.MinePage.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.activity.SetpasswpodSucceedActivity;
import com.example.arttower.bean.AlterUserBean;
import com.example.arttower.bean.ZhanghuInitBean;
import com.example.arttower.model.MineModel;
import com.example.arttower.utils.CommonUtils;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 修改密码
 * */
public class AlterPasswordActivity extends BaseMvpActivity<MineModel> {
    @BindView(R.id.alter_password_subit)
    Button mSubit;

    @BindView(R.id.alter_password_eq_newPassword)
    EditText mEqNewPassword;

    @BindView(R.id.alter_password_newPassword)
    EditText mNewPassword;

    @BindView(R.id.alter_password_oldPassword)
    EditText mOldPassword;
    private String password;
    private String oldpassword;
    private String newPassword;
    private String eqnewpassword;


    @Override
    public int getLayoutId() {
        return R.layout.activity_alter_password;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        //获取到当前用户的密码
        mPresenter.getData(ApiConfig.ZHANGHU_CODE);
    }

    @OnClick({R.id.alter_password_subit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.alter_password_subit:
                oldpassword = mOldPassword.getText().toString();
                newPassword = mNewPassword.getText().toString();
                eqnewpassword = mEqNewPassword.getText().toString();
                //进行密码的逻辑判断
                if (isCheckoutOk()) {
                    mPresenter.getData(ApiConfig.SETALTERPASSWORD, oldpassword, newPassword);
                }
                break;
        }
    }

    /**
     * 密码两次文本格式校验
     */
    private Boolean isCheckoutOk() {
        if (oldpassword.equals("") && oldpassword != null) {
            Toast.makeText(this, "请输入旧密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (oldpassword.equals(password)) {
            Toast.makeText(this, "旧密码不正确", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(newPassword) && newPassword != null) {
            Toast.makeText(this, "请输入新密码(6-12为数字字母混排)", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(newPassword.length() >= 6) || !(newPassword.length() <= 12)) {
            Toast.makeText(this, "请输入6-12为数字字母混排", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(eqnewpassword) && eqnewpassword != null) {
            Toast.makeText(this, "请输入确认密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(eqnewpassword.length() >= 6) || !(eqnewpassword.length() <= 12)) {
            Toast.makeText(this, "请输入正确的确认密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!newPassword.equals(eqnewpassword)) {
            Toast.makeText(this, "两次密码输入不一致，请重新输入", Toast.LENGTH_SHORT).show();
            mNewPassword.setText("");
            mEqNewPassword.setText("");
            return false;
        }
        boolean identify = CommonUtils.identify(this, newPassword);
        if (!identify) {
            Toast.makeText(this, "密码应为6-12为数字字母混排", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (oldpassword.equals(eqnewpassword)) {
            Toast.makeText(this, "旧密码不能与新密码相同", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public MineModel getModel() {
        return new MineModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.SETALTERPASSWORD:
                Log.e("TAG", "onError: " + "修改密码失败");
                break;
            case ApiConfig.ZHANGHU_CODE:
                Log.e("TAG", "onError: " + "获取账户资料失败");
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.SETALTERPASSWORD:
                AlterUserBean alterUserBean = (AlterUserBean) t[0];
                Toast.makeText(mApplication, alterUserBean.getMsg(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SetpasswpodSucceedActivity.class));
                finish();
                break;
            case ApiConfig.ZHANGHU_CODE:
                ZhanghuInitBean zhanghuInitBean = (ZhanghuInitBean) t[0];
                password = (String) zhanghuInitBean.getData().getPassword();
                Log.e("当前账户密码", "onResponse: " + password);
                break;
        }
    }
}