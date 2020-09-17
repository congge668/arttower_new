package com.example.arttower.activity;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.R;
import com.example.arttower.adapter.WuBiAdapter;
import com.example.arttower.bean.ToUpWuBiBean;
import com.example.arttower.model.BuyWubiModel;
import com.example.arttower.other.AliPayOrderInfoBean;
import com.example.arttower.other.PayAliResult;
import com.example.arttower.other.PayUtils;
import com.example.arttower.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

//import com.example.arttower.utils.PayResult;
//import com.example.arttower.utils.PayUtils;

/*
 * 充值页面
 * */
public class ChongZhiWuBiActivity extends BaseMvpActivity<BuyWubiModel> {
    @BindView(R.id.chongzhi_wubi_rlv)
    RecyclerView mChongzhi_wubi_rlv;
    @BindView(R.id.money_button)//立即充值
            Button mButton;

    private WuBiAdapter wuBiAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_chong_zhi_wu_bi;
    }
    @Override
    public void initView() {
        //管理器
        mChongzhi_wubi_rlv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.TOUPWUBICONTRAST, "ANDROID");
    }
    @SuppressLint("ResourceAsColor")
    @OnClick({R.id.money_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.money_button:
                String moneyId = "";
                if (wuBiAdapter != null){
                    for (int i = 0;i<wuBiAdapter.getDatas().size();i++){
                        if (wuBiAdapter.getDatas().get(i).isSelect()){
                            moneyId= wuBiAdapter.getDatas().get(i).getMoneyId();
                            break;
                        }

                    }
                }
                if (!TextUtils.isEmpty(moneyId)){
                    mPresenter.getData(ApiConfig.AliOrder, moneyId);
                } else {
                    Toast.makeText(mApplication, "请选择要充值发舞币", Toast.LENGTH_SHORT).show();
                }


            break;
        }
    }
    @Override
    public BuyWubiModel getModel() {
        return new BuyWubiModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.TOUPWUBICONTRAST:
                Toast.makeText(mApplication, "获取舞币金额失败", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.AliOrder:
                AliPayOrderInfoBean aliPayOrderInfoBean = (AliPayOrderInfoBean)t[0];
                //String orderInfo = "alipay_sdk=alipay-sdk-java-4.5.0.ALL&app_id=2017062007529139&biz_content=%7B%22body%22%3A%22%E8%B4%AD%E4%B9%B0%E4%BA%86%E9%87%91%E5%B8%81%E7%9A%84%E8%B4%B9%E7%94%A8%22%2C%22out_trade_no%22%3A%22524acafa140548a086386c72d4e2fd0f%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E9%87%91%E5%B8%81400%E4%B8%AA%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.03%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F118.178.238.32%3A7074%2FpayAsyncNotify%2FgoldAlipay&sign=AC%2BQtXEvOHar%2BIqWMQVzWi2PDUTFijCrc834U1zCx9SN85y3xoxQfLlWMCINi2%2BUBRilK1wRN43fpHJWuFHakvduZfPA%2FM7KaqIMctD18689CbDQFmoectczgG5ypaPZNdQR0mw%2Fl8ZIWa%2B6Cg187M6ERfVpiBS6tOorvpr4AT8U8ITllW7sAsBmxd9t38qnV%2FSpHo9f0SPEGqoB0h6Ae9TTPuMXF%2B3rMTr3%2FB7y%2F2JuuFulKvpCDs2NpwV41jycmNTDAct38Qj8aDcIRJP57iHj%2BiwN7eYeuyV5LBvuQn0IrjLsJw6E%2FOICiHO%2FO5eGR7uSwVzr5W1c8UrsXOnPEg%3D%3D&sign_type=RSA2&timestamp=2020-09-13+20%3A23%3A59&version=1.0";
                PayUtils.aliPay(this, aliPayOrderInfoBean.getData(), new PayUtils.OrderListener() {
                    @Override
                    public void onPayResult(String payResult) {
                        PayAliResult pr = new PayAliResult(payResult);
                        String rs = pr.getResultStatus();
                        String r = pr.getResult();
                        switch (rs) {
                            case "9000": //9000视为支付付款成功了，其他都是失败的
                                ToastUtils.show(ChongZhiWuBiActivity.this,"支付成功");
                                //通知接口支付成功
                                //getPresenter().alipayVerify(new VerifyBody(InfoUtils.getUserId(), rs, r, result.getExtraParam()));
                                break;

                            default:
                                ToastUtils.show(ChongZhiWuBiActivity.this,"支付失败");
                                //通知接口支付失败，取消订单
                                //getPresenter().orderCancel(new CancelBody(result.getExtraParam()));
                        }
                    }
                });
                //Log.i("aliPayOrderInfoBean1",aliPayOrderInfoBean.getMsg());
                break;
            case ApiConfig.TOUPWUBICONTRAST:
                ToUpWuBiBean toUpWuBiBean = (ToUpWuBiBean) t[0];
                ToUpWuBiBean.DataBean data = toUpWuBiBean.getData();
                List<ToUpWuBiBean.DataBean.MoneyListBean> moneyList = data.getMoneyList();
                wuBiAdapter = new WuBiAdapter(this, moneyList);
                mChongzhi_wubi_rlv.setAdapter(wuBiAdapter);
                wuBiAdapter.setOnItemClickListener(new BaseRvAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {

                        for (int i = 0;i<wuBiAdapter.getDatas().size();i++){
                            wuBiAdapter.getDatas().get(i).setSelect(i==position);
                        }
                        wuBiAdapter.notifyDataSetChanged();
                    }
                });
                break;
        }
    }
}