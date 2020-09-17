package com.example.arttower.activity;

import android.content.Intent;
import android.util.Log;
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

public class TaFensiActivity extends BaseMvpActivity<TaGuanzhuModel> {
    @BindView(R.id.textfensi)
    TextView mFensi;
    @BindView(R.id.rv_tafans)
    RecyclerView mRv_tafans;
    private FensiAdapter adapter;
    private final int offset = 1;
    private final int rows = 10;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_ta_fensi;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();

        String userid = intent.getStringExtra("userid");

        mPresenter.getData(ApiConfig.FENSI, offset, rows,userid);
        //布局管理
        mRv_tafans.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

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
        Log.e("TAG", "onError: " +e.getMessage());
    }

    //获取对应返回的数据
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.FENSI:
                FenSiBean fenSiBean = (FenSiBean) t[0];
                List<FenSiBean.DataBean.YptUserDOSBean> list = fenSiBean.getData().getYptUserDOS();
                adapter = new FensiAdapter(this, list);
                mRv_tafans.setAdapter(adapter);
                break;
        }
    }
}
