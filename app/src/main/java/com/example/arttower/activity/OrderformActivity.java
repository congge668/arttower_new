package com.example.arttower.activity;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.bean.DataBean;
import com.example.arttower.model.MineModel;

import java.util.List;

import butterknife.BindView;

/*
 * 我的订单
 * */
public class OrderformActivity extends BaseMvpActivity<MineModel> {
    private int offset = 1;
    private int rows = 10;
    @BindView(R.id.rlv_order)
    RecyclerView rlvOrder;
    private List<DataBean> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_orderform;
    }

    @Override
    public void initView() {

        rlvOrder.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.MYDINGDANXINXI, offset, rows);
    }

    @Override
    public MineModel getModel() {
        return new MineModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {


        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.MYDINGDANXINXI:
              //  OrderformAdapter adapter = new OrderformAdapter(this, list);
                //rlvOrder.setAdapter(adapter);
                Toast.makeText(mApplication, "获取成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
