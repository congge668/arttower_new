package com.example.arttower.fragment.LocalPage.fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.fragment.LocalPage.adapter.TeacherCouserAdapter;
import com.example.arttower.fragment.LocalPage.bean.TeacherCouserBean;
import com.example.arttower.fragment.LocalPage.model.TeacherCouserModel;

import java.util.List;

import butterknife.BindView;

/**
 * 课程
 */
public class TeacherCourseFragment extends BaseMvpFragment<TeacherCouserModel> {
    @BindView(R.id.teacher_couser_rlv)
    RecyclerView mTeacher_Couser_Rlv;
    private int offset = 1;
    private int rows = 10;
    private String result;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_course_teacher;
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        result = bundle.getString("uid");
        mTeacher_Couser_Rlv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.TEACHERCOUSERRLV, offset, rows,result);
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
            case ApiConfig.TEACHERCOUSERRLV:
                TeacherCouserBean teacherCouserBean= (TeacherCouserBean) t[0];
                List<TeacherCouserBean.DataBean> list = teacherCouserBean.getData();
                TeacherCouserAdapter adapter = new TeacherCouserAdapter(getContext(), list);
                mTeacher_Couser_Rlv.setAdapter(adapter);

        }
    }
}
