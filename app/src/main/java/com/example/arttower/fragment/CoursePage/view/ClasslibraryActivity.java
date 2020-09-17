package com.example.arttower.fragment.CoursePage.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.activity.SearchActivity;
import com.example.arttower.fragment.CoursePage.view.adapter.FmPagerAdapter;
import com.example.arttower.fragment.CoursePage.view.tabfragmetn.ClassisfyActivity;
import com.example.arttower.fragment.CoursePage.view.tabfragmetn.TabFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ClasslibraryActivity extends BaseMvpActivity {

    @BindView(R.id.sousuo)
    ImageView mSousuo;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.fenlei)
    ImageView mClassify;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;


    private int offset = 1;
    private int rows = 10;
    private String[] titles = new String[]{"推荐", "古典舞", "芭蕾舞", "民族舞", "民间舞", "现代舞", "网红舞", "独舞"};
    private List<Fragment> fragments;
    private FmPagerAdapter fmPagerAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_classlibrary;
    }

    @Override
    public void initView() {
        fragments = new ArrayList<>();
        mTablayout.setupWithViewPager(mViewPager);
        FmPagerAdapter fmPagerAdapter = new FmPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(fmPagerAdapter);


        for (int i = 0; i < titles.length; i++) {
            fragments.add(new TabFragment());
            mTablayout.addTab(mTablayout.newTab());
        }

        mTablayout.setupWithViewPager(mViewPager);
        fmPagerAdapter = new FmPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(fmPagerAdapter);

        for (int i = 0; i < titles.length; i++) {
            mTablayout.getTabAt(i).setText(titles[i]);
        }
    }

    //监听事件
    @OnClick({R.id.sousuo, R.id.fenlei})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sousuo:
                startActivity(new Intent(ClasslibraryActivity.this, SearchActivity.class));
                break;
            case R.id.fenlei:
                startActivity(new Intent(ClasslibraryActivity.this, ClassisfyActivity.class));
                break;

        }
    }

    @Override
    public void initData() {
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