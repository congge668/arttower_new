package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

/*
* 用户名密码登录
* */
public class FindPsdModel implements ICommonModel {
    NetManager mManager = NetManager.getNetManager();
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.EDIT_PASSWORDBYMOBILE:
                String mobile = (String) t[0];
                String password = (String) t[1];
                mManager.method(mManager.getNetManager().getNetService().getSetPasswordInfo(mobile, password), view, whichApi);
                break;
        }
    }
}