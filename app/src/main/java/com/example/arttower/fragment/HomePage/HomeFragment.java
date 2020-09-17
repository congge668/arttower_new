package com.example.arttower.fragment.HomePage;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.activity.SearchActivity;
import com.example.arttower.adapter.CommPagerAdapter;
import com.example.arttower.fragment.HomePage.Attention.AttentionFragment;
import com.example.arttower.fragment.HomePage.Recommend.VideoListFragment;
import com.example.arttower.model.HomeModel;
import com.example.arttower.utils.PauseVideoEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseMvpFragment<HomeModel> {
    static HomeFragment fragment;
    @BindView(R.id.vp_home)
    ViewPager vpHome;
    @BindView(R.id.home_tab)
    XTabLayout homeTab;
    @BindView(R.id.home_search)
    ImageView homeSearch;
    @BindView(R.id.home_cream)
    ImageView homeJiahao;

    private ArrayList<Fragment> fragments;
    private CommPagerAdapter pagerAdapter;
    /**
     * 默认显示第一页推荐页
     */
    public static int curPage = 1;
    private VideoListFragment recommendFragment;
    private AttentionFragment attentionFragment;
    private CommPagerAdapter commPagerAdapter;

    public static HomeFragment newInstance() {
        if (fragment == null) fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        fragments = new ArrayList<>();
        recommendFragment = new VideoListFragment();
        attentionFragment = new AttentionFragment();
        fragments.add(recommendFragment);
        fragments.add(attentionFragment);
        homeTab.addTab(homeTab.newTab().setText("推荐"));
        homeTab.addTab(homeTab.newTab().setText("关注"));

        commPagerAdapter = new CommPagerAdapter(getChildFragmentManager(), fragments, new String[]{"推荐", "关注"});
        vpHome.setAdapter(commPagerAdapter);
        homeTab.setupWithViewPager(vpHome);
        vpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                curPage = position;

                if (position == 0) {
                    //继续播放
                    EventBus.getDefault().post(new PauseVideoEvent(true));
                    //RxBus.getDefault().post(new PauseVideoEvent(true));
                } else {
                    //切换到其他页面，需要暂停视频
                    //RxBus.getDefault().post(new PauseVideoEvent(false));
                    EventBus.getDefault().post(new PauseVideoEvent(false));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.home_cream, R.id.home_search, R.id.home_tab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //录制
            case R.id.home_cream:

                break;
            //搜索
            case R.id.home_search:
                startActivity(new Intent(getContext(), SearchActivity.class));
                break;
            case R.id.home_tab:

                break;
        }
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
        showLog(e.getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

}
