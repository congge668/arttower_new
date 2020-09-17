package com.example.arttower.activity;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.adapter.HotSearchAdapter;
import com.example.arttower.bean.HotSearchBena;
import com.example.arttower.model.HotSearchMolder;

import java.util.List;

import butterknife.BindView;

public class TwoSeekFragment extends BaseMvpFragment<HotSearchMolder> {

    @BindView(R.id.remen_Recycler)
    RecyclerView mRecyRemen;

    @Override
    public int getLayoutId() {
        return R.layout.resou_one;
    }

    @Override
    public void initView() {
        mRecyRemen.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.HOT_SEARCH);
    }

    @Override
    public HotSearchMolder getModel() {
        return new HotSearchMolder();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.HOT_SEARCH:
                Toast.makeText(getContext(), "请求失败", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.HOT_SEARCH:
                HotSearchBena hotSearchBena = (HotSearchBena) t[0];
                List<HotSearchBena.DataBean> data = hotSearchBena.getData();
                HotSearchAdapter adapter = new HotSearchAdapter(getContext(), data);
                mRecyRemen.setAdapter(adapter);
                break;
        }
    }
}
