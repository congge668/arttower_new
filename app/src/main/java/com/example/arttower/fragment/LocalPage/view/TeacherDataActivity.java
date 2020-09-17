package com.example.arttower.fragment.LocalPage.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.androidkun.xtablayout.XTabLayout;
import com.bumptech.glide.Glide;
import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.bean.AlterUserBean;
import com.example.arttower.bean.ZhanghuInitBean;
import com.example.arttower.design.StarBar;
import com.example.arttower.fragment.LocalPage.bean.TeacherDataBean;
import com.example.arttower.fragment.LocalPage.fragment.AnsweringFragment;
import com.example.arttower.fragment.LocalPage.fragment.AppraiseFragment;
import com.example.arttower.fragment.LocalPage.fragment.PresentationFragment;
import com.example.arttower.fragment.LocalPage.fragment.TeacherCourseFragment;
import com.example.arttower.fragment.LocalPage.model.TeacherDataModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 教师的个人介绍，答疑，评价和课程
 * */
public class TeacherDataActivity extends BaseMvpActivity<TeacherDataModel> {
    @BindView(R.id.tab_teacher)
    XTabLayout tabTeacher;
    @BindView(R.id.teacher_frame)
    FrameLayout mFrame;
    @BindView(R.id.bitmap_teacher)
    ImageView mBitmap_teacher;
    @BindView(R.id.teacger_guanzhu)
    Button mGuanzhu;
    @BindView(R.id.data_academy)
    TextView mAcademy;
    @BindView(R.id.data_degree)
    TextView mDegree;
    @BindView(R.id.data_name)
    TextView mName;
    @BindView(R.id.return_left)
    ImageView returnleft;

    @BindView(R.id.data_teacher_star)
    StarBar mStar;

    private PresentationFragment presentationFragment;
    private AnsweringFragment answeringFragment;
    private AppraiseFragment appraiseFragment;
    private TeacherCourseFragment courseFragment;
    private ArrayList<Fragment> fragments;
    private String uid;
    private Bundle bundle;
    private TeacherDataBean dataBean;
    private TeacherDataBean.DataBean data;
private  int index=0;
    private String score;

    @Override
    public int getLayoutId() {
        return R.layout.activity_teacher_data;
    }

    @Override
    public void initView() {

        Intent intent = getIntent();
        uid = intent.getStringExtra("uid");
        Log.e("TAG", "initView: "+uid );
        String img = intent.getStringExtra("img");
        score = intent.getStringExtra("fenshu");//教师的评分
        Glide.with(this).load(img).into(mBitmap_teacher);
        mPresenter.getData(ApiConfig.TEACHERDATARLV, uid);
        //给Fragment发送当前id
        bundle = new Bundle();
        bundle.putString("uid", uid);

    }

    @OnClick({R.id.return_left, R.id.teacger_guanzhu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.return_left:
                finish();
                break;
            case R.id.teacger_guanzhu:
                mPresenter.getData(ApiConfig.ZHANGHU_CODE);


                break;
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public TeacherDataModel getModel() {
        return new TeacherDataModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            //查询教师介绍
            case ApiConfig.TEACHERDATARLV:
                TeacherDataBean dataBean= (TeacherDataBean) t[0];
                dataBean = (TeacherDataBean) t[0];
                data = dataBean.getData();
                String isFocus = data.getIsFocus();
                if (isFocus.equals("0"))
                    mGuanzhu.setText("关注");
                else mGuanzhu.setText("已关注");
                mName.setText(data.getIdCardName());
                mDegree.setText(data.getDegree());
                mAcademy.setText(data.getDiploma());
                mStar.setStarMark(Float.parseFloat(score));
                if (index==0){
                    initTab();
                    index++;
                }
                break;
            //获取用户id
            case ApiConfig.ZHANGHU_CODE:
                ZhanghuInitBean zhanghuInitBean = (ZhanghuInitBean) t[0];
                String userid = zhanghuInitBean.getData().getId();
                Log.e("用户的id", "onResponse: " + userid);
                mPresenter.getData(ApiConfig.GUANZHUANDCANCAL, userid, uid);
                break;
            // 关注和取消关注
            case ApiConfig.GUANZHUANDCANCAL:
                AlterUserBean alterUserBean= (AlterUserBean) t[0];
                Toast.makeText(this, alterUserBean.getMsg(), Toast.LENGTH_SHORT).show();
                initView();
                break;
        }
    }

    private void initTab() {
        //介绍
        presentationFragment = new PresentationFragment();
        //课程
        courseFragment = new TeacherCourseFragment();
        //答疑
        appraiseFragment = new AppraiseFragment();
        //评价
        answeringFragment = new AnsweringFragment();
        //集合
        fragments = new ArrayList<>();
        //添加进集合
        fragments.add(presentationFragment);
        fragments.add(courseFragment);
        fragments.add(appraiseFragment);
        fragments.add(answeringFragment);

        tabTeacher.addTab(tabTeacher.newTab().setText("介绍"));
        tabTeacher.addTab(tabTeacher.newTab().setText("课程"));
        tabTeacher.addTab(tabTeacher.newTab().setText("答疑"));
        tabTeacher.addTab(tabTeacher.newTab().setText("评价"));


        presentationFragment.setArguments(bundle);
        courseFragment.setArguments(bundle);
        appraiseFragment.setArguments(bundle);
        answeringFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.teacher_frame, presentationFragment)
                .add(R.id.teacher_frame, courseFragment)
                .add(R.id.teacher_frame, appraiseFragment)
                .add(R.id.teacher_frame, answeringFragment)
                .show(presentationFragment)
                .hide(courseFragment)
                .hide(appraiseFragment)
                .hide(answeringFragment)
                .commit();

        tabTeacher.addOnTabSelectedListener(new XTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(XTabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    getSupportFragmentManager().beginTransaction()
                            .show(presentationFragment)
                            .hide(courseFragment)
                            .hide(appraiseFragment)
                            .hide(answeringFragment)
                            .commit();

                } else if (position == 1) {
                    getSupportFragmentManager().beginTransaction()
                            .hide(presentationFragment)
                            .show(courseFragment)
                            .hide(appraiseFragment)
                            .hide(answeringFragment)
                            .commit();

                } else if (position == 2) {
                    getSupportFragmentManager().beginTransaction()
                            .hide(presentationFragment)
                            .hide(courseFragment)
                            .show(appraiseFragment)
                            .hide(answeringFragment)
                            .commit();

                } else {
                    getSupportFragmentManager().beginTransaction()
                            .hide(presentationFragment)
                            .hide(courseFragment)
                            .hide(appraiseFragment)
                            .show(answeringFragment)
                            .commit();

                }
            }

            @Override
            public void onTabUnselected(XTabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(XTabLayout.Tab tab) {

            }
        });
    }
}