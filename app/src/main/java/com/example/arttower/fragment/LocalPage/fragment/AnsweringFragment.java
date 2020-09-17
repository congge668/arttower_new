package com.example.arttower.fragment.LocalPage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.bean.TeacherAppraiseBean;
import com.example.arttower.fragment.LocalPage.adapter.TeacherAppraiseAdapter;
import com.example.arttower.fragment.LocalPage.model.TeacherCouserModel;
import com.example.arttower.fragment.LocalPage.view.WriteAppriaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 评价
 * */
public class AnsweringFragment extends BaseMvpFragment<TeacherCouserModel> {
    @BindView(R.id.appraise_xie_pingjia)
    TextView mXie_pingjia;
    @BindView(R.id.teacher_apprise_rlv)
    RecyclerView mAppriseRlv;
    private String result;
    private int offset = 1;
    private int rows = 10;

    @Override
    public int getLayoutId() {
        return R.layout.write_appraise;
    }

    @Override
    public void initView() {
        //用户id
        Bundle bundle = getArguments();
        result = bundle.getString("uid");
        mAppriseRlv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


    }

    @Override
    public void initData() {
        //数据
        mPresenter.getData(ApiConfig.TEACHERAPPRAISERLV, offset, rows, result);
    }

    @OnClick({R.id.appraise_xie_pingjia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.appraise_xie_pingjia:
                startActivity(new Intent(getContext(), WriteAppriaseActivity.class));
                break;
        }
    }


    @Override
    public TeacherCouserModel getModel() {
        return new TeacherCouserModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEACHERAPPRAISERLV:
                TeacherAppraiseBean teacherAppraiseBean = (TeacherAppraiseBean) t[0];
                List<TeacherAppraiseBean.DataBean> data = teacherAppraiseBean.getData();
                TeacherAppraiseAdapter teacherAppraiseAdapter = new TeacherAppraiseAdapter(getContext(), data);
                mAppriseRlv.setAdapter(teacherAppraiseAdapter);
                break;
        }
    }
}
