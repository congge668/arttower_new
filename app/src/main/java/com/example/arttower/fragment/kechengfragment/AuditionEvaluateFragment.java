package com.example.arttower.fragment.kechengfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.R;
import com.example.arttower.adapter.CouserCommentAdaptet;
import com.example.arttower.bean.AlterUserBean;
import com.example.arttower.bean.CouserCommentBean;
import com.example.arttower.model.CoursedetailsModel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 课程评价
 * */
public class AuditionEvaluateFragment extends BaseMvpFragment {

    @BindView(R.id.audition_evaluate_rlv)
    RecyclerView mEvaluate_Rlv; //展示的评价数据

    @BindView(R.id.audition_evaluate_te)//发表评价
            EditText mEvaluate_Te;

    @BindView(R.id.audition_evaluate_false)//表情
            ImageView mFalse;

    @BindView(R.id.audition_evaluate_data)//发送
            ImageView mData;
    private String courseId;
    private String getCourseId="1080";
    private int offset = 100;

    private CouserCommentAdaptet couserCommentAdaptet;
    private String content;

    @Override
    public int getLayoutId() {
        return R.layout.auditionevaluate;
    }
    @Override
    public void initView() {
        Bundle bundle = getArguments();
        //课程id
        courseId = bundle.getString("courseId");
        //管理布局
        mEvaluate_Rlv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void initData() {
        //试听课程的评论
        mPresenter.getData(ApiConfig.COUSERCOMMENT, getCourseId, offset);

    }
    @OnClick({R.id.audition_evaluate_data})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //发布评论
            case R.id.audition_evaluate_data:
                content= mEvaluate_Te.getText().toString();
                mPresenter.getData(ApiConfig.COUSERUPCOMMENT, getCourseId, content);
                break;
        }
    }
    @Override
    public CoursedetailsModel getModel() {
        return new CoursedetailsModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.COUSERCOMMENT:
                Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_SHORT).show();
                break;
            case ApiConfig.COUSERUPCOMMENT:
                Toast.makeText(getContext(), "评论发布失败", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            //查寻课程评论
            case ApiConfig.COUSERCOMMENT:
                CouserCommentBean couserCommentBean = (CouserCommentBean) t[0];
                List<CouserCommentBean.DataBean> data = couserCommentBean.getData();
                couserCommentAdaptet = new CouserCommentAdaptet(getContext(), data);
                mEvaluate_Rlv.setAdapter(couserCommentAdaptet);
                Toast.makeText(getContext(), "获取数据成功", Toast.LENGTH_SHORT).show();
                //回复评论
                couserCommentAdaptet.setOnItemClickListener(new BaseRvAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        //课程视频的回复评论
                       // mPresenter.getData(ApiConfig.COUSERUPADDCOMMENT,"1080","123456789");
                    }
                });
                break;
                //课程视频    发布评论
            case ApiConfig.COUSERUPCOMMENT:
                AlterUserBean alterUserBean= (AlterUserBean) t[0];
                Toast.makeText(getContext(), alterUserBean.getMsg(), Toast.LENGTH_SHORT).show();
                //发布成功，输入框清零
                mEvaluate_Te.setText("");
                break;
                // 课程视频   回复 评论
            case ApiConfig.COUSERUPADDCOMMENT:

                break;

        }
    }
}
