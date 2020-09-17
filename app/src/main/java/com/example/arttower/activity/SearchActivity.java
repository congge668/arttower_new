package com.example.arttower.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.model.HotSearchMolder;

import butterknife.BindView;

/*
 * 搜索搜索
 * */
public class SearchActivity extends BaseMvpActivity<HotSearchMolder> {
    /**
     * 删除历史记录
     */

    @BindView(R.id.mSearchView)
    EditText mSrarchView;

    @BindView(R.id.sousuo_frame)
    FrameLayout mFrame;
    private OneSeekFragment oneSeekFragment;
    private TwoSeekFragment twoSeekFragment;
    private String text;
    private int index = 1;
    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        //热门搜索和历史搜索
        oneSeekFragment = new OneSeekFragment();
        //搜索出来的数据
        twoSeekFragment = new TwoSeekFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.sousuo_frame, twoSeekFragment)
                .commit();
    }


    @Override
    public void initData() {

    }

    //监听软键盘的回车键
    // @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            /*隐藏软键盘*/
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
                if (index==1){
                    text = mSrarchView.getText().toString();
                    bundle = new Bundle();
                    bundle.putString("text", text);
                    oneSeekFragment.setArguments(bundle);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.sousuo_frame, oneSeekFragment)
                            .commit();

                }else {

                   // oneSeekFragment.onCreate(bundle);
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public HotSearchMolder getModel() {
        return new HotSearchMolder();
    }


    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.HOT_SEARCH:
                break;
        }
    }
}