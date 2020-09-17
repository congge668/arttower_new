package com.example.arttower.activity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.bean.CouserDetailsBean;
import com.example.arttower.fragment.kechengfragment.AuditionEvaluateFragment;
import com.example.arttower.fragment.kechengfragment.AuditionSynopsisFragment;
import com.example.arttower.model.CoursedetailsModel;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;

/*
 * 课程播放
 * */
public class AuditionCouserActivity extends BaseMvpActivity<CoursedetailsModel> {
    @BindView(R.id.surface)
    VideoView mVideo;


    @BindView(R.id.andition_tab)
    TabLayout mTab;
    private AuditionSynopsisFragment auditionSynopsisFragment;
    private AuditionEvaluateFragment auditionEvaluateFragment;
    private String couserid;
    private Uri parse;
    private String videoUrl;
    private MediaPlayer player;
    private int mHeight;
    private int mWidth;

    @Override
    public int getLayoutId() {
        return R.layout.andition_couser_activity;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        //课程id
        couserid = intent.getStringExtra("couserid");
        Log.e("couserid", "initView: " + couserid);


        Bundle bundle = new Bundle();
        bundle.putString("couserid", couserid);

        //获取屏幕宽高
        getScreen();
        //简介
        auditionSynopsisFragment = new AuditionSynopsisFragment();
        //评价
        auditionEvaluateFragment = new AuditionEvaluateFragment();

        //传递课程id
        auditionSynopsisFragment.setArguments(bundle);
        auditionEvaluateFragment.setArguments(bundle);

        mTab.addTab(mTab.newTab().setText("简介"));
        mTab.addTab(mTab.newTab().setText("评价"));

        getSupportFragmentManager().beginTransaction()
                .add(R.id.audition_frame, auditionSynopsisFragment)
                .add(R.id.audition_frame, auditionEvaluateFragment)
                .show(auditionSynopsisFragment)
                .hide(auditionEvaluateFragment)
                .commit();


        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                if (position == 0) {
                    getSupportFragmentManager().beginTransaction()
                            .show(auditionSynopsisFragment)
                            .hide(auditionEvaluateFragment)
                            .commit();
                } else {
                    getSupportFragmentManager().beginTransaction()
                            .hide(auditionSynopsisFragment)
                            .show(auditionEvaluateFragment)
                            .commit();
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    private void getScreen() {
        WindowManager systemService = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = systemService.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        defaultDisplay.getMetrics(metrics);
        //宽
        mWidth = metrics.widthPixels;
        //高
        mHeight = metrics.heightPixels;
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.TEACHERCOUSERDETAILS, couserid);
    }

    @Override
    public CoursedetailsModel getModel() {
        return new CoursedetailsModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            //课程详情
            case ApiConfig.TEACHERCOUSERDETAILS:

                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            //课程详情
            case ApiConfig.TEACHERCOUSERDETAILS:
                CouserDetailsBean couserDetailsBean = (CouserDetailsBean) t[0];
                CouserDetailsBean.DataBean data = couserDetailsBean.getData();
                //视频
                List<CouserDetailsBean.DataBean.YptCourseVideoDOListBean> yptCourseVideoDOList = data.getYptCourseVideoDOList();
                videoUrl = yptCourseVideoDOList.get(0).getVideoUrl();
                Log.e("TAG", "onResponse: "+videoUrl );
                //Uri uri = Uri.parse(videoUrl);//将路径转换成uri
                Uri uri = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");//将路径转换成uri
               mVideo.setMediaController(new MediaController(this));//显示控制栏
                mVideo.setVideoURI(uri);//为视频播放器设置视频路径
                mVideo.start();
                mVideo.requestFocus();

               /* mVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mVideo.start();//开始播放视频
                    }
                });*/

              //  parse = Uri.parse(videoUrl);

              /*  MediaController mediaController = new MediaController(this);
                mediaController.show();
                //设置MediaController
                mVideo.setMediaController(mediaController);
                //设置Uri
                mVideo.setVideoURI(parse);
                mVideo.start();
                //设置获取焦点
                mVideo.requestFocus();*/
               // play();

                break;
        }
    }

    private void play() {
        //设置播放
        player = new MediaPlayer();
        //设置播放的视频路径
        try {
            player.setDataSource(videoUrl);
            //异步加载流媒体
            player.prepareAsync();
            //获取SurfaceHolder
            SurfaceHolder holder = mVideo.getHolder();
            player.setDisplay(holder);
//确保surfaceHolder已经准备好了。因此需要给surfaceHolder设置一个callback，
            //调用addCallback()方法。Callback 有三个回调函数

            holder.addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    //SurfaceHolder被创建的时候回调
                    player.setDisplay(holder);

                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    //SurfaceHolder被销毁的时候回调，在这里可以做一些释放资源的操作，防止内存泄漏

                }
            });
            //MediaPlayer加载流媒体完毕的监听
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                @Override
                public void onPrepared(MediaPlayer mp) {

                    //获取视频的宽高

                    int videoHeight = player.getVideoHeight();

                    int videoWidth = player.getVideoWidth();

                    if (videoHeight > mHeight || videoWidth> mWidth){

                        //如果视频的宽或者高超出屏幕,要缩放
                        float widthRatio = (float)videoWidth/(float)mWidth;
                        float heightRatio = (float)videoHeight/(float)mHeight;

                        //选择大的进行缩放
                        float max = Math.max(widthRatio,heightRatio);
                        videoWidth = (int) Math.ceil(videoWidth/max);
                        videoHeight = (int) Math.ceil(videoHeight/max);
                        //设置surfaceview的布局参数
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(videoWidth, videoHeight);
                        //设置垂直居中
                        layoutParams.gravity = Gravity.CENTER_VERTICAL;
                        mVideo.setLayoutParams(layoutParams);
                    }
                    player.start();
                    //mediaPlayer.setLooping(true);
                }
            });

            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    //播放完成监听
                    finish();
                }

            });

            player.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    //发生错误监听
                    return false;
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
            Log.e("视频地址", "play: "+"错误" );
        }


    }
}
