package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

/*
 * 课程详情model
 * */
public class BuyWubiModel implements ICommonModel {

    private String moneyId;


    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager netManager = NetManager.getNetManager();
        switch (whichApi) {

            //支付宝订单
            case ApiConfig.AliOrder:
                moneyId = (String) t[0];
                netManager.method(netManager.getNetManager().getNetService().accountAliPay(moneyId), view, whichApi);
                break;
            case ApiConfig.TOUPWUBICONTRAST:

                netManager.method(netManager.getNetManager().getNetService().gettoupWubInfo("ANDROID"), view, whichApi);
                break;
        }
    }
}
