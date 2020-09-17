package com.example.arttower.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.adapter.MyAttentionAdapter;
import com.example.arttower.bean.MyAttentionBean;
import com.example.arttower.model.MineAttentionModel;

import java.util.List;

import butterknife.BindView;

/*
 * 我的关注
 * */
public class MineAttentionActivity extends BaseMvpActivity<MineAttentionModel> {
    private static final int offset = 1;
    private static final int rows = 10;
    private String userid;

    @BindView(R.id.attention_rlv)
    RecyclerView mAttention_Rlv;
    @BindView(R.id.guanzhu_te)
    TextView mTE;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_attention;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        userid = intent.getStringExtra("userid");

        mAttention_Rlv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void initData() {
        //进行请求
        mPresenter.getData(ApiConfig.MYATTENTIONCODE, offset, rows, userid);
    }

    @Override
    public MineAttentionModel getModel() {
        return new MineAttentionModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        Log.e("我的关注", "onError: " + e.getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.MYATTENTIONCODE:

                MyAttentionBean myAttentionBean = (MyAttentionBean) t[0];
                List<MyAttentionBean.DataBean> data = myAttentionBean.getData();
                if (data.size() != 0) {
                    MyAttentionAdapter adapter = new MyAttentionAdapter(this, data);
                    mAttention_Rlv.setAdapter(adapter);
                } else {
                    mTE.setText("暂时您还没有关注有趣的小伙伴");
                }

                break;
        }
    }
}
