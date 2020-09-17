package com.example.arttower.fragment.CoursePage.view;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;

import butterknife.BindView;
import butterknife.OnClick;

public class SpecialtyCustomActivity extends BaseMvpActivity {

    @BindView(R.id.specialty_exam)
    LinearLayout mSpeialtyexam;
    @BindView(R.id.specialty_interest)
    LinearLayout mSpecialtyinterest;
    @BindView(R.id.specialty_next)
    Button mSpecialtynext;
    @BindView(R.id.kskj)
    CheckBox mkskj;
    @BindView(R.id.xqah)
    CheckBox mxqah;

    @Override
    public int getLayoutId() {
        return R.layout.activity_specialty_custom;
    }

    @Override
    public void initView() {

        //选中事件
        mkskj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    int cl_ff7b00 = R.color.cl_ff7b00;
                    mSpeialtyexam.setBackgroundColor(Color.parseColor("#ff7b00"));
                    mSpecialtynext.setBackgroundColor(Color.parseColor("#ff7b00"));
                    mSpecialtyinterest.setClickable(false);
                    mSpeialtyexam.setClickable(true);
                    mSpecialtynext.isClickable();

                } else {
                    int cl_ff7b00 = R.color.cl_f4f4f4;
                    mSpeialtyexam.setBackgroundColor(Color.parseColor("#F4F4F4"));
                    mSpecialtynext.setBackgroundColor(Color.parseColor("#F4F4F4"));
                    mSpecialtyinterest.setClickable(false);

                }
            }
        });

        //选中事件
        mxqah.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    int cl_ff7b00 = R.color.cl_ff7b00;
                    mSpecialtyinterest.setBackgroundColor(Color.parseColor("#ff7b00"));
                    mSpecialtynext.setBackgroundColor(Color.parseColor("#ff7b00"));
                    mSpeialtyexam.setClickable(false);
                    mSpecialtyinterest.setClickable(true);
                    mSpecialtynext.isClickable();
                } else {
                    int cl_ff7b00 = R.color.cl_f4f4f4;
                    mSpecialtyinterest.setBackgroundColor(Color.parseColor("#F4F4F4"));
                    mSpecialtynext.setBackgroundColor(Color.parseColor("#F4F4F4"));
                    mSpeialtyexam.setClickable(false);

                }
            }
        });
    }


    @Override
    public void initData() {

    }

    //监听事件
    @OnClick({R.id.specialty_next, R.id.specialty_interest, R.id.specialty_exam})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //下一步
            case R.id.specialty_next:

                break;
            //兴趣爱好
            case R.id.specialty_interest:

                break;
            //考试考级
            case R.id.specialty_exam:
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