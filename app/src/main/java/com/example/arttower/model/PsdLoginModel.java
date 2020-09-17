package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

/*
* 账号密码登录
* */
public class PsdLoginModel implements ICommonModel {
    NetManager mManager = NetManager.getNetManager();
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi){
            case ApiConfig.LOGINPASSWORD_CODE:
                String mobile = (String) t[0];
                String password = (String) t[1];
                mManager.method(mManager.getNetManager().getNetService().getLoginPassWordInfo(mobile,password),view,whichApi);
                break;
        }
    }
}