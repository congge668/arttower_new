package com.example.arttower.activity;

import android.os.Bundle;

import com.androidkun.xtablayout.XTabLayout;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.fragment.HomePage.homeclass.OneVideoFragment;
import com.example.arttower.fragment.HomePage.homeclass.ThreeTestFragment;
import com.example.arttower.fragment.HomePage.homeclass.TwoCuserFragment;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

/*
* 搜索出来的用户，课程，和视频
* */
public class OneSeekFragment extends BaseMvpFragment {
    @BindView(R.id.one_seek_tab)
    XTabLayout mtab;
    private OneVideoFragment oneVideoFragment;
    private ThreeTestFragment threeTestFragment;
    private TwoCuserFragment twoCuserFragment;
    private String keyword;

    @Override
    public int getLayoutId() {
        return R.layout.oneseekfragment;
    }

    @Override
    public void initView() {

        Bundle bundle1 = getArguments();
        keyword = bundle1.getString("text");

        //首先设置几个fragment
        oneVideoFragment = new OneVideoFragment();
        twoCuserFragment = new TwoCuserFragment();
        threeTestFragment = new ThreeTestFragment();


        EventBus.getDefault().post(keyword);
        //给frame传数据
        Bundle bundle = new Bundle();
        bundle.putString("keyword", keyword);

        oneVideoFragment.setArguments(bundle);
        twoCuserFragment.setArguments(bundle);
        threeTestFragment.setArguments(bundle);

        mtab.addTab(mtab.newTab().setText("视频"));
        mtab.addTab(mtab.newTab().setText("用户"));
        mtab.addTab(mtab.newTab().setText("课程"));


        getChildFragmentManager().beginTransaction()
                .add(R.id.one_seek_frame, oneVideoFragment)
                .add(R.id.one_seek_frame, twoCuserFragment)
                .add(R.id.one_seek_frame, threeTestFragment)
                .show(oneVideoFragment)
                .hide(twoCuserFragment)
                .hide(threeTestFragment)
                .commit();
        intab();
    }

    private void intab() {
        mtab.addOnTabSelectedListener(new XTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(XTabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    getChildFragmentManager().beginTransaction()
                            .show(oneVideoFragment)
                            .hide(twoCuserFragment)
                            .hide(threeTestFragment)
                            .commit();
                } else if (position == 1) {
                    getChildFragmentManager().beginTransaction()
                            .hide(oneVideoFragment)
                            .show(twoCuserFragment)
                            .hide(threeTestFragment)
                            .commit();
                } else {
                    getChildFragmentManager().beginTransaction()
                            .hide(oneVideoFragment)
                            .hide(twoCuserFragment)
                            .show(threeTestFragment)
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
