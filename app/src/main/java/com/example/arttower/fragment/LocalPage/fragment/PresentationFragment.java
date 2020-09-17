package com.example.arttower.fragment.LocalPage.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.fragment.LocalPage.bean.TeacherDataBean;
import com.example.arttower.fragment.LocalPage.model.TeacherDataModel;

import butterknife.BindView;

/*
 * 介绍
 * */
public class PresentationFragment extends BaseMvpFragment {

    private int offset = 1;
    private int rows = 10;
    private String uid;
    //教师编码
    @BindView(R.id.teacher_jieshao_code)
    TextView mCode;
    @BindView(R.id.teacher_jieshao_content)//教师介绍
            TextView mContent;
    @BindView(R.id.teacher_jieshao_undergo_one)//教师经历
            TextView mOne;
    @BindView(R.id.teacher_jieshao_undergo_two)//教师经历
            TextView mTwo;
    @BindView(R.id.teacher_jieshao_feature_content)//个人特色
            TextView mFeature_content;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_presentation;
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        uid = bundle.getString("uid");
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.TEACHERDATARLV, uid);
    }

    @Override
    public TeacherDataModel getModel() {
        return new TeacherDataModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.TEACHERDATARLV:

                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

        switch (whichApi) {
            case ApiConfig.TEACHERDATARLV:
                TeacherDataBean teacherDataBean = (TeacherDataBean) t[0];
                TeacherDataBean.DataBean data = teacherDataBean.getData();
                if (data!=null){

                    mCode.setText(data.getTqcNo());
                    mFeature_content.setText(data.getPersonalFeatures());
                    mContent.setText(data.getIntroduction());
                }
                break;
        }
    }
}
