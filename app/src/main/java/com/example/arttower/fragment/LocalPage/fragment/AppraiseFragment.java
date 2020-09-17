package com.example.arttower.fragment.LocalPage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.bean.TeacherAnswerBean;
import com.example.arttower.fragment.LocalPage.adapter.TeacherAnswerAdapter;
import com.example.arttower.fragment.LocalPage.model.TeacherCouserModel;
import com.example.arttower.fragment.LocalPage.view.UpTeacherQuizActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * 答疑
 * */
public class AppraiseFragment extends BaseMvpFragment {
    @BindView(R.id.ll_tiwen)
    LinearLayout mTiwen;
    @BindView(R.id.answer_Rlv)
    RecyclerView mRlvAnswer;


    private String uid;
private  int offset=1;
private  int rows=10;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_answering;
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        uid = bundle.getString("uid");

        mRlvAnswer.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));

    }

    @OnClick({R.id.ll_tiwen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_tiwen:
                startActivity(new Intent(getContext(), UpTeacherQuizActivity.class));
                break;
        }
    }

    @Override
    public void initData() {
       //获取数据
        mPresenter.getData(ApiConfig.TEACHERANSWERRLV,offset,rows, uid);
    }


    @Override
    public TeacherCouserModel getModel() {
        return new TeacherCouserModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEACHERANSWERRLV:
                TeacherAnswerBean teacherAnswerBean= (TeacherAnswerBean) t[0];

                List<TeacherAnswerBean.DataBean> data = teacherAnswerBean.getData();
                TeacherAnswerAdapter adapter = new TeacherAnswerAdapter(getContext(), data);

                mRlvAnswer.setAdapter(adapter);
                break;
        }
    }



}
