package com.example.arttower.activity;

import android.view.View;
import android.widget.Button;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;

import butterknife.BindView;

/*
* 修改密码成功
* */
public class SetpasswpodSucceedActivity extends BaseMvpActivity {
    @BindView(R.id.alter_succeed)
    Button mSucceed;

    @Override
    public int getLayoutId() {
        return R.layout.setpasswpodsucceedactivity;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.alter_succeed:
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
