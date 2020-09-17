package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class ForgetPsdModel implements ICommonModel {
    NetManager mManager = NetManager.getNetManager();
    private String mobile;
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi){
            case ApiConfig.ALTERFORPSDCODE:
                mobile = (String) t[0];
//                mManager.method(mManager.getNetService(NetConfig.BaseUrl).getCodeInfo(mobile),view,whichApi);
                mManager.method(mManager.getNetManager().getNetService().getAlterPhoneCode(mobile),view,whichApi);
                break;
            case ApiConfig.ALTERFORPSDCODEEQUST:
                mobile = (String) t[0];
                String mobileCode = (String) t[1];
                mManager.method(mManager.getNetManager().getNetService().getAlterForPsdCodeEqust(mobile,mobileCode),view,whichApi);
                break;
        }
    }
}