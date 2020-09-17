package com.example.arttower.fragment.MinePage.view;

import android.content.Intent;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.adapter.FensiAdapter;
import com.example.arttower.bean.FenSiBean;
import com.example.arttower.model.TaGuanzhuModel;

import java.util.List;

import butterknife.BindView;

public class MineFansActivity extends BaseMvpActivity {
    @BindView(R.id.fans_te)
    TextView mFansTe;

    @BindView(R.id.fans_rlv)
    RecyclerView mFansRlv;

    private final int offset = 1;
    private final int rows = 10;

    @Override
    public int getLayoutId() {
        return R.layout.fans_mine_activity;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");

        //获取数据
        mPresenter.getData(ApiConfig.FENSI, offset, rows,userid);
        mFansRlv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void initData() {

    }

    @Override
    public TaGuanzhuModel getModel() {
        return new TaGuanzhuModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.FENSI:
                FenSiBean fenSiBean= (FenSiBean) t[0];
                List<FenSiBean.DataBean.YptUserDOSBean> list = fenSiBean.getData().getYptUserDOS();
                FensiAdapter adapter = new FensiAdapter(this, list);
                mFansRlv.setAdapter(adapter);

                break;
        }
    }
}
