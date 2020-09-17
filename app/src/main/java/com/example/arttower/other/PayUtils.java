package com.example.arttower.other;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.alipay.sdk.app.PayTask;


import java.util.SortedMap;
import java.util.TreeMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * author：congge
 * date: 2018/8/27 16:43
 * desc:支付工具类
 **/
public class PayUtils {




    /**
     * desc:支付宝支付
     * Created by congge on 2018/8/27 17:20
     * @param orderInfo 接口返回的订单
     **/
    public static void aliPay(final Activity activity, final String orderInfo, final OrderListener orderListener) {
        if (TextUtils.isEmpty(orderInfo)) return;
        Observable.just(orderInfo)
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String orderInfo) throws Exception {
                        //用户在商户app内部点击付款，是否需要一个loading做为在钱包唤起之前的过渡，这个值设置为true
                        return new PayTask(activity).pay(orderInfo, true);
                    }

                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String payResult) throws Exception {
                        orderListener.onPayResult(payResult);
                    }

                });
    }


    /**
     * @desc 调起微信支付
     * @author congge
     * @time 2019/2/18  16:59
     */
//    public static void wxPay(Context context, final String prepqyId, final String mchId) {
//        LogUtils.i("看看商户号是多少",mchId + "\t" + WxPayUtils.getWxAppId());
//        if (MyApplication.getWxapi().isWXAppInstalled()) {
//            Thread payThread = new Thread() {
//                @Override
//                public void run() {
//                    PayReq request = new PayReq();
//                    request.appId = WxPayUtils.getWxAppId();
//                    request.partnerId = mchId; // 商户号
//                    request.prepayId = prepqyId;
//                    request.packageValue = "Sign=WXPay";
//                    request.nonceStr = WxPayUtils.getNumSmallLetter();
//                    request.timeStamp = (System.currentTimeMillis() / 1000) + "";
//                    SortedMap<String, String> map = new TreeMap<>();
//                    map.put("appid", request.appId);
//                    map.put("partnerid", request.partnerId);
//                    map.put("prepayid", request.prepayId);
//                    map.put("package", request.packageValue);
//                    map.put("noncestr", request.nonceStr);
//                    map.put("timestamp", request.timeStamp);
//                    request.sign = WxPayUtils.createMD5Sign(map,mchId);
//                    MyApplication.getWxapi().sendReq(request);
//                }
//            };
//            payThread.start();
//        } else {
//            ToastUtils.show(context.getString(R.string.wx_unInstalled));
//        }
//
//
//    }

    public interface OrderListener {

        void onPayResult(String payResult);
    }


}
