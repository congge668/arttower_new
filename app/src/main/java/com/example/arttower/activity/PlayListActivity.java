package com.example.arttower.activity;


import com.example.arttower.Frame.BaseVideoActivity;
import com.example.arttower.R;

/**
 * create by libo
 * create on 2020-05-24
 * description 视频全屏播放页
 */
public class PlayListActivity extends BaseVideoActivity {
    public static int initPos;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_play_list;
    }

    @Override
    protected void init() {
      /// getSupportFragmentManager().beginTransaction().add(R.id.framelayout, new RecommendFragment()).commit();
    }
}
