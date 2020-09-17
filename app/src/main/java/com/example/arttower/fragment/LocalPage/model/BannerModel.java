package com.example.arttower.fragment.LocalPage.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class BannerModel implements ICommonModel {
    NetManager mManager = NetManager.getNetManager();
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.COUSERBANNER:
                mManager.method(mManager.getNetManager().getNetService().getCourseBannerInfo(), view, whichApi);
                break;

        }
    }
}
