package com.example.arttower.fragment.kechengfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.R;
import com.example.arttower.adapter.SynopsisNeiRongAdapter;
import com.example.arttower.bean.CouserDetailsBean;
import com.example.arttower.bean.UpLikeBean;
import com.example.arttower.model.CoursedetailsModel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 课程简介
 * */
public class AuditionSynopsisFragment extends BaseMvpFragment<CoursedetailsModel> {

    @BindView(R.id.audition_synopsis_neirong_rlv)//内容
            RecyclerView mNeirongRlv;
    @BindView(R.id.audition_synopsis_tuijian_rlv)//相关推荐
            RecyclerView mTuijianRlv;


    @BindView(R.id.audition_synopsis_attention)//关注
            TextView mAttention;

    @BindView(R.id.audition_synopsis_comment_num)//评论数量
            TextView mNum;

    @BindView(R.id.audition_synopsis_date)//日期
            TextView mDate;

    @BindView(R.id.audition_synopsis_play_num)//播放数量
            TextView mPlay_Num;

    @BindView(R.id.audition_synopsis_headimg)//用户头像
            ImageView mHeadImg;

    @BindView(R.id.audition_synopsis_like)//点赞
            ImageView mLike;

    @BindView(R.id.audition_synopsis_shoucang)//收藏
            ImageView mShoucang;

    @BindView(R.id.audition_synopsis_share)//分享
            ImageView mShare;

    @BindView(R.id.audition_synopsis_name)//教师name
            TextView mName;

    @BindView(R.id.synopsis_cuser_name)//课程name
            TextView mCuserName;

    private String courseId;

    private int index = 1;
    private String shipinid;
    private UpLikeBean upLikeBean;
    //点赞
    private boolean praiseCourse;
    private boolean bol;
    //收藏
    private boolean collectCourseVideo;




    @Override
    public int getLayoutId() {
        return R.layout.auditionsynopsis;
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        //课程id
        courseId = bundle.getString("couserid");
        Log.e("courseId", "initView: " + courseId);

        //设置布局管理器

        mNeirongRlv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        //内容名字
        mNeirongRlv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        //相关课程

        mTuijianRlv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.TEACHERCOUSERDETAILS, courseId);
    }


    @Override
    public CoursedetailsModel getModel() {
        return new CoursedetailsModel();
    }


    //点击事件
    @OnClick({R.id.audition_synopsis_share, R.id.audition_synopsis_shoucang,
            R.id.audition_synopsis_like, R.id.audition_synopsis_attention})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.audition_synopsis_shoucang:
                if (collectCourseVideo == bol) {
                    //收藏
                    mPresenter.getData(ApiConfig.COUSERUPCOLLECT, shipinid);
                    Log.e("praiseCourse", "onViewClicked: "+"调用收藏接口" +shipinid);
                } else {
                    //取消收藏
                    mPresenter.getData(ApiConfig.COUSERCOLLECTDOWN, shipinid);
                }


                break;

            case R.id.audition_synopsis_like:
                if (praiseCourse == bol) {
                    //点赞
                    mPresenter.getData(ApiConfig.COUSERUPLIKE, courseId);
                } else {
                    //取消点赞
                    mPresenter.getData(ApiConfig.COUSERUPLIKEDOWN, courseId);
                }


                break;
            case R.id.audition_synopsis_attention:

                break;
        }
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {

        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEACHERCOUSERDETAILS:
                CouserDetailsBean couserDetailsBean = (CouserDetailsBean) t[0];
                CouserDetailsBean.DataBean data = couserDetailsBean.getData();
                mPlay_Num.setText("" + data.getPlayCount());//播放数量
                mNum.setText("" + data.getEvaluateCount());//评论数量

                //判断是否点赞
                praiseCourse = (boolean) data.getPraiseCourse();
                if (praiseCourse != bol) {
                    mLike.setImageResource(R.mipmap.icon_synopsis_like_yes);
                } else {
                    mLike.setImageResource(R.mipmap.icon_synopsis_like);
                }

                String isFocus = data.getIsFocus();
                if (isFocus.equals(0)){
                    mAttention.setText("关注");
                }else {
                    mAttention.setTextSize(10);
                    mAttention.setText("取消关注");
                }
                //教师信息
                CouserDetailsBean.DataBean.YptAuthenticationDOBean yptAuthenticationDO = data.getYptAuthenticationDO();
                mName.setText(yptAuthenticationDO.getIdCardName());
                Glide.with(getContext()).load(yptAuthenticationDO.getDiplomaImgUrl()).into(mHeadImg);
                //视频集合
                List<CouserDetailsBean.DataBean.YptCourseVideoDOListBean> videlist = data.getYptCourseVideoDOList();

                // 是否收藏
                collectCourseVideo = (boolean) videlist.get(index).getCollectCourseVideo();
                Log.e("praiseCourse", "收藏bollean: " + collectCourseVideo +"测试bollean"+ bol);
                if (collectCourseVideo != bol) {
                    mShoucang.setImageResource(R.mipmap.icon_synopsis_shoucang_yes);
                } else {
                mShoucang.setImageResource(R.mipmap.icon_synopsis_);
                }

                mCuserName.setText(videlist.get(index).getVideoName());
                //视频集合视频id
                shipinid = videlist.get(index).getId();
                mDate.setText(videlist.get(index).getVideoTime());
                //创建内容的Adapter
                SynopsisNeiRongAdapter neiRongAdapter = new SynopsisNeiRongAdapter(getContext(), videlist);
                mNeirongRlv.setAdapter(neiRongAdapter);

                neiRongAdapter.setOnItemClickListener(new BaseRvAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        index = position;
                        String videoUrl = videlist.get(position).getVideoUrl();
                        String courseId = videlist.get(position).getId();
                        Log.e("课程详情", "onItemClick: "+courseId+"=============="+videoUrl );
                    }
                });
                break;
            //点赞
            case ApiConfig.COUSERUPLIKE:
                upLikeBean = (UpLikeBean) t[0];
                upLikeBean.getMsg();
                Toast.makeText(getContext(), "点赞成功", Toast.LENGTH_SHORT).show();
                int icon_synopsis_like_yes = R.mipmap.icon_synopsis_like_yes;
                mLike.setImageResource(icon_synopsis_like_yes);

                break;

            //取消点赞
            case ApiConfig.COUSERUPLIKEDOWN:
                upLikeBean = (UpLikeBean) t[0];
                upLikeBean.getMsg();
                Toast.makeText(getContext(), "取消点赞", Toast.LENGTH_SHORT).show();
                mLike.setImageResource(R.mipmap.icon_synopsis_like);


                break;
            //收藏
            case ApiConfig.COUSERUPCOLLECT:
                upLikeBean = (UpLikeBean) t[0];
                upLikeBean.getMsg();
                Toast.makeText(getContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                mShoucang.setImageResource(R.mipmap.icon_synopsis_shoucang_yes);
                break;
            //取消收藏
            case ApiConfig.COUSERCOLLECTDOWN:
                upLikeBean = (UpLikeBean) t[0];
                upLikeBean.getMsg();
                Toast.makeText(getContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                mShoucang.setImageResource(R.mipmap.icon_synopsis_);
                break;
        }
    }
}
