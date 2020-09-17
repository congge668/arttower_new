package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class AlterZhanghuModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager manager = NetManager.getNetManager();
        switch (whichApi) {
            case ApiConfig.ALTER_ZHANGHU_NAME_CODE:
                String nickName = (String) t[0];
                manager.method(manager.getNetManager().getNetService().getAlterUserNameInfo(nickName), view, whichApi);
                break;
            case ApiConfig.ALTER_ZHANGHU_PSA_CODE:
                String content = (String) t[0];
                manager.method(manager.getNetManager().getNetService().getAlterUserPSAInfo( content), view, whichApi);
                break;
            case ApiConfig.ALTER_ZHANGHU_SHENGRI_CODE:
                String birthday = (String) t[0];
                manager.method(manager.getNetManager().getNetService().getAlterUserPSAInfo(birthday), view, whichApi);
                break;
        }
    }
}
