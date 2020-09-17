package com.example.arttower.activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.arttower.Frame.BaseApplication;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.design.MyBottomView;
import com.example.arttower.fragment.CoursePage.CourseFragment;
import com.example.arttower.fragment.HomePage.HomeFragment;
import com.example.arttower.fragment.LocalPage.LocalFragment;
import com.example.arttower.fragment.MinePage.MineFragment;
import com.example.arttower.fragment.TestPage.TestFragment;
import com.example.arttower.model.HomeModel;
import com.example.arttower.utils.PauseVideoEvent;
import com.example.arttower.utils.StatusBarUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;


public class MainActivity extends BaseMvpActivity<HomeModel> implements MyBottomView.OnBottomClick {

    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.bottom_view)
    MyBottomView bottomView;
    private FragmentManager mManager;
    private Fragment mHomeFragment, mLocalFragment, mTestFragment, mCourseFragment, mMineFragment;
    private final int HOME = 1, LOCAL = 2, TEST = 3, COURSE = 4, MINE = 5;
    public static int curMainPage;
    private RelativeLayout view;
    private String mToken;


    @Override
    protected void setStatusBar() {
        super.setStatusBar();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mToken = BaseApplication.getInstance().mToken;
        Log.e("mToken", "initView: "+ mToken);

        StatusBarUtil.setTranslucentStatus(this);
        bottomView.setBottomBg(Color.BLACK);
        bottomView.setBottomTextSize(this, 10f);
        bottomView.setOnBottomClickListener(this);
        mManager = getSupportFragmentManager();
        showFragment(HOME);
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
        switch (whichApi) {

        }
    }

    private int currentIndex = 6;

    private void showFragment(int index) {
        if (currentIndex == index) return;
        else currentIndex = index;

        FragmentTransaction fragmentTransaction = mManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (index) {
            case HOME:
                curMainPage = 0;
                if (mHomeFragment != null) {
                    //继续播放
                    EventBus.getDefault().post(new PauseVideoEvent(true));
                    fragmentTransaction.show(mHomeFragment);
                } else {
                    mHomeFragment = HomeFragment.newInstance();
                    fragmentTransaction.add(R.id.frame_layout, mHomeFragment);
                }
                break;
            case LOCAL:
                if (mToken.equals("SHAREJSESSIONID=9b424119-6b17-45b2-a6c4-52a88df4f94d")){
                        UpPopwind();
                }else {
                    curMainPage = 1;
                    if (mLocalFragment != null) fragmentTransaction.show(mLocalFragment);
                    else {
                        mLocalFragment = LocalFragment.newInstance();
                        fragmentTransaction.add(R.id.frame_layout, mLocalFragment);
                    }
                    // RxBus.getDefault().post(new PauseVideoEvent(false));
                    //切换到其他页面，需要暂停视频
                    EventBus.getDefault().post(new PauseVideoEvent(false));
                }

                break;
            case TEST:
                //判断是否登录
                if (mToken.equals("SHAREJSESSIONID=9b424119-6b17-45b2-a6c4-52a88df4f94d")){
                    UpPopwind();
                }else {
                    curMainPage = 2;

                    if (mTestFragment != null) fragmentTransaction.show(mTestFragment);
                    else {
                        mTestFragment = TestFragment.newInstance();
                        fragmentTransaction.add(R.id.frame_layout, mTestFragment);
                    }
                    // RxBus.getDefault().post(new PauseVideoEvent(false));
                    //切换到其他页面，需要暂停视频
                    EventBus.getDefault().post(new PauseVideoEvent(false));
                }


                break;
            case COURSE:
                //判断是否登录
                if (mToken.equals("SHAREJSESSIONID=9b424119-6b17-45b2-a6c4-52a88df4f94d")){
                    UpPopwind();
                }else {
                    curMainPage = 3;
                    if (mCourseFragment != null) fragmentTransaction.show(mCourseFragment);
                    else {
                        mCourseFragment = CourseFragment.newInstance();
                        fragmentTransaction.add(R.id.frame_layout, mCourseFragment);
                    }
                    // RxBus.getDefault().post(new PauseVideoEvent(false));
                    //切换到其他页面，需要暂停视频
                    EventBus.getDefault().post(new PauseVideoEvent(false));
                }

                break;
            case MINE:
                //判断是否登录
                if (mToken.equals("SHAREJSESSIONID=9b424119-6b17-45b2-a6c4-52a88df4f94d")){
                    UpPopwind();
                }else {
                    curMainPage = 4;
                    if (mMineFragment != null) fragmentTransaction.show(mMineFragment);
                    else {
                        mMineFragment = MineFragment.newInstance();
                        fragmentTransaction.add(R.id.frame_layout, mMineFragment);
                    }
                    // RxBus.getDefault().post(new PauseVideoEvent(false));
                    //切换到其他页面，需要暂停视频
                    EventBus.getDefault().post(new PauseVideoEvent(false));
                }

                break;
        }
        fragmentTransaction.commit();
    }

    private void UpPopwind() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.up_login, null);
        PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setContentView(inflate);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(810);
        //获取焦点
        popupWindow.setFocusable(true);
        //点击弹窗以外的弹窗关闭
        popupWindow.setOutsideTouchable(true);
        //弹窗位置
        popupWindow.showAsDropDown(inflate);

        //popupwindow的点击事件
        View view = popupWindow.getContentView();
        ImageView down = view.findViewById(R.id.return_fanhui);
        Button login = view.findViewById(R.id.up_login);

        down.setOnClickListener(v -> {
            popupWindow.dismiss();
        });

        login.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }

    private void hideFragment(FragmentTransaction pFragmentTransaction) {
        if (mHomeFragment != null) pFragmentTransaction.hide(mHomeFragment);
        if (mLocalFragment != null) pFragmentTransaction.hide(mLocalFragment);
        if (mTestFragment != null) pFragmentTransaction.hide(mTestFragment);
        if (mCourseFragment != null) pFragmentTransaction.hide(mCourseFragment);
        if (mMineFragment != null) pFragmentTransaction.hide(mMineFragment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (curMainPage == 0) {
            //继续播放
            EventBus.getDefault().post(new PauseVideoEvent(true));
        }
    }

    @Override
    public void onFirstClick() {
        bottomView.setBottomBg(Color.BLACK);
        showFragment(HOME);
    }

    @Override
    public void onSecondClick() {
        bottomView.setBottomBg(Color.WHITE);
        showFragment(LOCAL);
    }

    @Override
    public void onThirdClick() {
        bottomView.setBottomBg(Color.WHITE);
        showFragment(TEST);
    }

    @Override
    public void onFourthClick() {
        bottomView.setBottomBg(Color.WHITE);
        showFragment(COURSE);
    }

    @Override
    public void onFifthClick() {
        bottomView.setBottomBg(Color.WHITE);
        showFragment(MINE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onAppExit();
            return true;
        }
        return false;
    }

    private long firstClick;

    public void onAppExit() {
        if (System.currentTimeMillis() - this.firstClick > 2000L) {
            this.firstClick = System.currentTimeMillis();
            Toast toast = Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return;
        }
        finish();
    }
}
