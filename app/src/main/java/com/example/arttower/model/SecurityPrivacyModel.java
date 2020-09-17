package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class SecurityPrivacyModel implements ICommonModel {
    NetManager mManager = NetManager.getNetManager();
    private String mobile;

    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.ALTERPHONECODE:
                mobile = (String) t[0];
                mManager.method(mManager.getNetManager().getNetService().getAlterPhoneCode(mobile), view, whichApi);

                break;
                case ApiConfig.ALTERPHONE:
               String mobileCode = (String) t[1];
               String token= (String) t[2];
                mManager.method(mManager.getNetManager().getNetService().getAlterPhoneInfo(mobile,mobileCode,token), view, whichApi);

                break;
        }
    }
}
