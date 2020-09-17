package com.example.arttower.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.model.HomeModel;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;


public class StarUpActivity extends BaseMvpActivity {
    @BindView(R.id.starup_te)
    TextView starup_te;
    @BindView(R.id.carryout_img)
    ImageView mCarroutImg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_star_up;
    }

    @Override
    public void initView() {
        mPresenter.getData(ApiConfig.CARRYOUT);
    }

    @Override
    public void initData() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(StarUpActivity.this, LoginActivity.class));
                finish();
            }
        };
        timer.schedule(timerTask, 2000);


    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.CARRYOUT:
                Log.e("开平动画", "onResponse: " );
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.CARRYOUT:
              /*  CarryOutAdvertisingBean carryOutAdvertisingBean = (CarryOutAdvertisingBean) t[0];
                List<CarryOutAdvertisingBean.DataBean> data = carryOutAdvertisingBean.getData();
                Log.e("开平动画", "onResponse: "+data.get(0).getImgUrl() );
                Glide.with(this).load(data.get(0).getImgUrl()).into(mCarroutImg);*/
                break;
        }
    }
}
