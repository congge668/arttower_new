package com.example.arttower.activity;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.model.MineModel;

import butterknife.BindView;

//我的历史记录
public class MineHistoryActivity extends BaseMvpActivity<MineModel> {

    private int offset = 1;
    private int rows = 10;
    @BindView(R.id.rlv_history)
    RecyclerView rlvHistory;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_history;
    }

    @Override
    public void initView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rlvHistory.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.MYHISTORYRECORD, offset, rows);
    }

    @Override
    public MineModel getModel() {
        return new MineModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.MYHISTORYRECORD:
                Toast.makeText(mApplication, "获取数据失败", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.MYHISTORYRECORD:
                //MineHistoryAdapter adapter = new MineHistoryAdapter(this, list);
                //rlvHistory.setAdapter(adapter);
                Toast.makeText(mApplication, "获取数据成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
