package com.example.arttower.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;

import butterknife.BindView;
import butterknife.OnClick;

/*
* TODO 转发
* */
public class MyTransmitActivity extends BaseMvpActivity {
    @BindView(R.id.zhuanfa_ed)
    EditText mZhuanfaEd;
    @BindView(R.id.zhuanfa_fasong)
    TextView mZhuanfaFaSong;

    @BindView(R.id.zhuanfa_image)
    ImageView mZhuanfaHead;

    @BindView(R.id.zhuanfa_name)
    TextView mZhuanfaName;

    @BindView(R.id.zhuanfa_conent)
    TextView mZhuanfaConent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_transmit;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.zhuanfa_fasong})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhuanfa_fasong:

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