package com.example.arttower.activity;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.adapter.CommPagerAdapter;
import com.example.arttower.design.CommonTitle;
import com.example.arttower.fragment.MinePage.Inform.ComposeMeFragment;
import com.example.arttower.fragment.MinePage.Inform.LikeMeFragment;
import com.example.arttower.fragment.MinePage.Inform.ReplyMeFragment;
import com.example.arttower.model.HomeModel;

import java.util.ArrayList;

import butterknife.BindView;

/*
* 消息通知
* */
public class WdInformActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.title_wdInform)
    CommonTitle titleWdInform;
    @BindView(R.id.tab_wdInform)
    XTabLayout tabWdInform;
    @BindView(R.id.vp_wdInform)
    ViewPager vpWdInform;
    private ArrayList<Fragment> fragments;
    private ReplyMeFragment replyMeFragment;
    private LikeMeFragment likeMeFragment;
    private ComposeMeFragment composeMeFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_wd_inform;
    }

    @Override
    public void initView() {
        replyMeFragment = new ReplyMeFragment();
        likeMeFragment = new LikeMeFragment();
        composeMeFragment = new ComposeMeFragment();
        fragments = new ArrayList<>();
        fragments.add(replyMeFragment);
        fragments.add(likeMeFragment);
        fragments.add(composeMeFragment);
        tabWdInform.addTab(tabWdInform.newTab().setText("回复我的"));
        tabWdInform.addTab(tabWdInform.newTab().setText("点赞我的"));
        tabWdInform.addTab(tabWdInform.newTab().setText("课程回复"));

        CommPagerAdapter commPagerAdapter = new CommPagerAdapter(getSupportFragmentManager(), fragments, new String[]{"回复我的", "点赞我的","课程回复"});
        vpWdInform.setAdapter(commPagerAdapter);
        tabWdInform.setupWithViewPager(vpWdInform);
    }

    @Override
    public void initData() {

    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }


    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

}
