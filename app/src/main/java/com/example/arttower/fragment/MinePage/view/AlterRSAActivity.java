package com.example.arttower.fragment.MinePage.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.bean.AlterUserBean;
import com.example.arttower.model.AlterZhanghuModel;

import butterknife.BindView;
import butterknife.OnClick;

public class AlterRSAActivity extends BaseMvpActivity<AlterZhanghuModel> {

    @BindView(R.id.alter_ed_rsa)
    EditText mAltered;

    @BindView(R.id.save_alter_qianming)
    Button mQianming;
    private String rsa;

    @Override
    public int getLayoutId() {
        return R.layout.activity_alter_r_s_a;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String md = intent.getStringExtra("name");
        mAltered.setText(md);

    }

    @Override
    public void initData() {

    }



    @OnClick({R.id.save_alter_qianming})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.save_alter_qianming:
                rsa = mAltered.getText().toString();
                mPresenter.getData(ApiConfig.ALTER_ZHANGHU_PSA_CODE, rsa);
                finish();
                break;
        }
    }

    @Override
    public AlterZhanghuModel getModel() {
        return new AlterZhanghuModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.ALTER_ZHANGHU_PSA_CODE:
                AlterUserBean alterUserBean= (AlterUserBean) t[0];
                String msg = alterUserBean.getMsg();
                break;
        }
    }
}