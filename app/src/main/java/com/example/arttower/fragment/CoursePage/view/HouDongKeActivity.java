package com.example.arttower.fragment.CoursePage.view;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.bean.HuoDongBean;
import com.example.arttower.fragment.CoursePage.adapter.HDRecyclerAdapter;
import com.example.arttower.fragment.CoursePage.model.HuoDongMolder;

import java.util.List;

import butterknife.BindView;

public class HouDongKeActivity extends BaseMvpActivity {

    @BindView(R.id.recycler_hdkc)
    RecyclerView mRecycler;
    private int offset = 1;
    private int rows = 10;
    private HDRecyclerAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_hou_dong_ke;
    }

    @Override
    public void initView() {

        mRecycler.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.HUODONG_COUSER,offset,rows);
    }

    @Override
    public HuoDongMolder getModel() {
        return new HuoDongMolder();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        Log.e("TAGAAAA", "onError: " + e.getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.HUODONG_COUSER:
                HuoDongBean huoDongBean=(HuoDongBean) t[0];
                List<HuoDongBean.DataBean> data = huoDongBean.getData();
                adapter = new HDRecyclerAdapter(this, data);
                mRecycler.setAdapter(adapter);
                //list.addAll(data);

                Log.e("tag",data.get(0).toString() );
                //adapter.notifyDataSetChanged();
                break;
        }
    }


}