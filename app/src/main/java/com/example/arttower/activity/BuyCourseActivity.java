package com.example.arttower.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.bean.CouserDetailsBean;
import com.example.arttower.design.StarBar;
import com.example.arttower.fragment.LocalPage.model.TeacherCouserModel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 课程购买
 * */
public class BuyCourseActivity extends BaseMvpActivity<TeacherCouserModel> {
    @BindView(R.id.buyer_covermg) //封面img
            ImageView mCovermg;
    @BindView(R.id.buyer_idCard)//评价用户name
            TextView mIdCard;
    @BindView(R.id.buyer_idCardName)//教师 name
            TextView mIdCardName;
    @BindView(R.id.buyer_introduction) //教师介绍
            TextView mIntroduction;
    @BindView(R.id.buyer_price)//价格
            TextView mPrice;
    @BindView(R.id.buyer_remark) //评价内容
            TextView mRemark;

    @BindView(R.id.buyer_teacher_coucser_content)//课程简介
            TextView mCouserContent;
    @BindView(R.id.buyer_teacher_coucser_name) //课程name
            TextView mCouserName;

    @BindView(R.id.buyer_shiting)//试听课程
            Button mShiting;
    @BindView(R.id.buy_teacger_img)//教师的头像
            ImageView mBuy_teacher_img;
    @BindView(R.id.buy_return)
    ImageView mReturn;
    @BindView(R.id.buy_teacher_star)//教师的评分
            StarBar mStarBar;

    @BindView(R.id.buy_guanzhu)//关注
            TextView mGuanzhu;

    @BindView(R.id.buy_couser_headimg)//评价img
            ImageView mHeadimg;

    private String courseId;
    private int size;
    private CouserDetailsBean.DataBean data;
    private List<CouserDetailsBean.DataBean.YptCourseVideoDOListBean> yptCourseVideoDOList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_buy_course;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        courseId = intent.getStringExtra("id");
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.TEACHERCOUSERDETAILS, courseId);
    }

    @OnClick({R.id.buyer_shiting, R.id.promptly_buyer, R.id.buy_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buyer_shiting:

                if (size != 0) {
                    //讲课程id传过去
                    Intent intent = new Intent(this, AuditionCouserActivity.class);
                    intent.putExtra("couserid", courseId);
                    startActivity(intent);
                } else {
                    Toast.makeText(mApplication, "该课程暂时没有数据", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.promptly_buyer:
                //跳转到购买页面
                Intent puyIntent = new Intent(this, PaymentActivity.class);
                puyIntent.putExtra("headimg", data.getCoverImg()+"");
                puyIntent.putExtra("testname", data.getCourseName()+"");
                puyIntent.putExtra("username", data.getYptAuthenticationDO().getIdCardName()+"");
                puyIntent.putExtra("testprice", data.getPrice()+"");
                puyIntent.putExtra("originaltestprice", data.getOriginalPrice() + "");

                puyIntent.putExtra("indentTimer",data.getCreateTime());//订单创建时间
                startActivity(puyIntent);
                break;
            case R.id.buy_return:
                finish();
                break;
        }
    }


    @Override
    public TeacherCouserModel getModel() {
        return new TeacherCouserModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.TEACHERCOUSERDETAILS:
                Log.e("课程购买", "onError: ");
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEACHERCOUSERDETAILS:
                Log.e("课程购买", "onResponse: ");
                CouserDetailsBean couserDetailsBean = (CouserDetailsBean) t[0];
                data = couserDetailsBean.getData();
                //视频集合
                yptCourseVideoDOList = data.getYptCourseVideoDOList();
                if (yptCourseVideoDOList != null) {
                    size = yptCourseVideoDOList.size();
                    String isFocus = data.getIsFocus();
                    if (isFocus.equals("0")) {
                        mGuanzhu.setText("关注");
                    } else {
                        mGuanzhu.setTextSize(12);
                        mGuanzhu.setText("取消关注");
                    }
                    //课程对应消息
                    CouserDetailsBean.DataBean.YptAuthenticationDOBean bean = data.getYptAuthenticationDO();
                    mPrice.setText("" + data.getPrice());
                    mCouserName.setText(data.getCourseName());
                    mCouserContent.setText(data.getCourseRemark());
                    Glide.with(this).load(data.getCoverImg()).into(mCovermg);
                    //教师对应消息
                    mIdCardName.setText(bean.getIdCardName());
                    mIntroduction.setText(bean.getCreateUser());
                    Glide.with(this).load(bean.getDiplomaImgUrl()).into(mBuy_teacher_img);
                    //用户对应消息
                    //List<CouserDetailsBean.DataBean.CourseEvaluationsBean> courseEvaluations = data.getCourseEvaluations();
                    //课程评分
                    String score = bean.getScore();
                    mStarBar.setStarMark(Float.parseFloat(score));
                    break;
                }
                break;
        }
    }
}
