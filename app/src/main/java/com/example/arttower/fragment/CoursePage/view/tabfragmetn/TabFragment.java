package com.example.arttower.fragment.CoursePage.view.tabfragmetn;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.bean.ClassBean;
import com.example.arttower.fragment.CoursePage.adapter.RecyclerAdapter;
import com.example.arttower.fragment.CoursePage.model.AllCourseMolder;

import java.util.List;

import butterknife.BindView;

public  class TabFragment extends BaseMvpFragment<AllCourseMolder> {

    @BindView(R.id.recycler)
    RecyclerView mRecycler;

    private int offset = 1;
    private int rows = 10;
    private List<ClassBean> classBeans;

    @Override
    public int getLayoutId() {
        return R.layout.tab_fragment;
    }

    @Override
    public void initView() {

        //布局管理器
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.ALL_COURSE,offset,rows);
    }

    @Override
    public AllCourseMolder getModel() {
        return new AllCourseMolder();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object... t) {
        switch (whichApi) {
            case ApiConfig.ALL_COURSE:
                ClassBean classBean = (ClassBean) t[0];
                List<ClassBean.DataBean.YptCourseDOListBean> data = classBean.getData().getYptCourseDOList();
                RecyclerAdapter adapter = new RecyclerAdapter(getContext(), data);
                mRecycler.setAdapter(adapter);
                Log.e("tag", data.get(0).toString());

                break;
        }
    }
}
