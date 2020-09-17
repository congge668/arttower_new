package com.example.arttower.fragment.TestPage.view;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;

import butterknife.BindView;
import butterknife.OnClick;

/*
机构咨询
* */
public class OrganizationActivity extends BaseMvpActivity {
    @BindView(R.id.relationdata)
    RelativeLayout relativeLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_organization;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.relationdata})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relationdata:
                startActivity(new Intent(this, TestDataActivity.class));
               // finish();
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