package com.example.arttower.activity;

import android.content.Intent;
import android.widget.TextView;

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

//我的收藏
public class MineCollectionActivity extends BaseMvpActivity<MineCollectionModel> {
    @BindView(R.id.rlv_collection)
    RecyclerView rlvCollection;
    @BindView(R.id.buchong_te)
    TextView mTE;

    private List<CollectBean.DataBean> list;
    private MineCollectionAdapter mineCollectionAdapter;
    private final int offset = 1;
    private final int rows = 10;
    private String uid;
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_collection;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
         uid = intent.getStringExtra("uid");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rlvCollection.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void initData() {
        //收藏数据
        mPresenter.getData(ApiConfig.SHOUCANG, offset, rows,uid);
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
            case ApiConfig.SHOUCANG:
                CollectBean collectBean = (CollectBean) t[0];
                List<CollectBean.DataBean> data = collectBean.getData();
                if (data.size()!=0){
                    //适配器
                    mineCollectionAdapter = new MineCollectionAdapter(this, data);
                    rlvCollection.setAdapter(mineCollectionAdapter);
                }else {
                 mTE.setText("暂时没有收藏课程，快去找自己感兴趣的课程吧");

                }
                break;
        }

    }
}
