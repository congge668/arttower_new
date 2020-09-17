package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

/*
* 快速登录
* */
public class LoginModel implements ICommonModel {
    NetManager mManager = NetManager.getNetManager();
    private String mobile;

    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.MOBILECODE_DATA:
                mobile = (String) t[0];
//                mManager.method(mManager.getNetService(NetConfig.BaseUrl).getCodeInfo(mobile),view,whichApi);
                mManager.method(mManager.getNetManager().getNetService().getCodeInfo(mobile),view,whichApi);
                break;
            case ApiConfig.MOBILECODENEW_DATA:
                mobile = (String) t[0];
                String mobileCode = (String) t[1];
                String lastLoginAddress = (String) t[2];
                String longitude = (String) t[3];
                String latitude = (String) t[4];
                String deviceNumber = (String) t[5];
                String deviceType = (String) t[6];
                String version = (String) t[7];
                mManager.method(mManager.getNetManager().getNetService().getMobileCodeNewInfo(mobile,mobileCode,lastLoginAddress,longitude,latitude,deviceNumber,deviceType,version),view,whichApi);
                break;
        }
    }
}
