package com.example.arttower.activity;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.fragment.MinePage.model.FankuiModel;

/*
 * 问题反馈界面
 * */
public class FeedbackActivity extends BaseMvpActivity<FankuiModel> {
    @Override
    public int getLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public FankuiModel getModel() {
        return new FankuiModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.WENTIFANKUI:

                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.WENTIFANKUI:

                break;
        }
    }
}