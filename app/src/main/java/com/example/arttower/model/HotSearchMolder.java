package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class HotSearchMolder implements ICommonModel {
    NetManager mManager = NetManager.getNetManager();

    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.HOT_SEARCH:
                mManager.method(mManager.getNetManager().getNetService().getHotSearch(), view, whichApi);
                break;
        }
    }
}
