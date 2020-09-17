package com.example.arttower.fragment.TestPage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.fragment.TestPage.adapter.TheTestAdapter;
import com.example.arttower.fragment.TestPage.model.TheTestModel;
import com.example.arttower.fragment.TestPage.view.OrganizationActivity;
import com.example.arttower.fragment.TestPage.view.TestFragmentBean;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

//考级
public class TestFragment extends BaseMvpFragment<TheTestModel> {
    static TestFragment fragment;
    @BindView(R.id.sign_one)
    LinearLayout mOne;
    @BindView(R.id.sign_three)
    LinearLayout mThree;
    @BindView(R.id.sign_four)
    LinearLayout mFour;
    @BindView(R.id.jiaxie_lv)
    RecyclerView mjiaxielv;
    @BindView(R.id.query_dance)
    Button mdance;

    @BindView(R.id.test_xy_img)
    ImageView mImage;
    @BindView(R.id.test_xy_name)
    TextView mName;


    public static TestFragment newInstance() {
        if (fragment == null) fragment = new TestFragment();
        return fragment;
    }

    private int index = 0;
    final int bai = R.color.white;

    //状态栏设置
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarColor(int statusColor, Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            //取消设置Window半透明的Flag
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //添加Flag把状态栏设为可绘制模式
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏为透明
            window.setStatusBarColor(Color.TRANSPARENT);

        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_test;
    }



    @Override
    public void initView() {
        //recycler的布局管理器
        mjiaxielv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @OnClick({R.id.sign_four, R.id.sign_three, R.id.sign_one,R.id.query_dance})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sign_four:
                index = 2;
                initData();
                break;

            case R.id.sign_three:
                index = 1;
                initData();
                break;

            case R.id.sign_one:
                index = 0;
                initData();
                break;

            case R.id.query_dance:
                startActivity(new Intent(getContext(), OrganizationActivity.class));
                break;

        }
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.THETEST);
    }

    @Override
    public TheTestModel getModel() {
        return new TheTestModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.THETEST:
                TestFragmentBean testFragmentBean = (TestFragmentBean) t[0];
                List<TestFragmentBean.DataBean> data = testFragmentBean.getData();
                //学院图片
                String gradeImgUrl = data.get(index).getGradeImgUrl();
                //学院名字
                String gradeName = data.get(index).getGradeName();
                mName.setText(gradeName);
                //  Glide.with(getContext()).load(gradeImgUrl).into(mImage);
                List<TestFragmentBean.DataBean.GradeTagListBean.GradeLevelListBean> list = data.get(index).getGradeTagList().get(0).getGradeLevelList();
                TheTestAdapter adapter = new TheTestAdapter(getContext(), list);
                mjiaxielv.setAdapter(adapter);
                break;
        }
    }
}
