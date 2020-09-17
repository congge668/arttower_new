package com.example.arttower.activity;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.adapter.MineCollectionAdapter;
import com.example.arttower.bean.CollectBean;
import com.example.arttower.model.MineCollectionModel;

import java.util.List;

import butterknife.BindView;

/*
 * 他的收藏页面
 * */
public class ItCollectionActivity extends BaseMvpActivity<MineCollectionModel> {
    @BindView(R.id.it_rlv_collection)
    RecyclerView mIt_rlv_collection;
    private MineCollectionAdapter mineCollectionAdapter;
    private final int offset = 1;
    private final int rows = 10;
    private String userid;

    @Override
    public int getLayoutId() {
        return R.layout.activity_it_collection;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        userid = intent.getStringExtra("userid");
    }

    @Override
    public void initView() {

        //收藏数据
        mPresenter.getData(ApiConfig.ITSHOUCANG, offset, rows,userid);
        //mPresenter.getData(ApiConfig., offset, rows,userid);
        //集合
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mIt_rlv_collection.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void initData() {

    }

    @Override
    public MineCollectionModel getModel() {
        return new MineCollectionModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.ITSHOUCANG:
                CollectBean collectBean = (CollectBean) t[0];
                List<CollectBean.DataBean> data = collectBean.getData();
                //适配器
                mineCollectionAdapter = new MineCollectionAdapter(this, data);
                mIt_rlv_collection.setAdapter(mineCollectionAdapter);
                break;
        }
    }
}