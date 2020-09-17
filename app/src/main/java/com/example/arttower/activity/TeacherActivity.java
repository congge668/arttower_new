package com.example.arttower.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;

import butterknife.BindView;
import butterknife.OnClick;

/*
* 教师认证
* */
public class TeacherActivity extends BaseMvpActivity {
    @BindView(R.id.teacher_Authentication)
    Button teacherAuthentication;

    @Override
    public int getLayoutId() {
        return R.layout.activity_teacher;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.teacher_Authentication})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.teacher_Authentication:
                startActivity(new Intent(this, DataIncludedActivity.class));
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
