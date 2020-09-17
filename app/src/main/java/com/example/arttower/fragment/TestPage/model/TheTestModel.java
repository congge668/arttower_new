package com.example.arttower.fragment.TestPage.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class TheTestModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager netManager = NetManager.getNetManager();
        switch (whichApi) {
            case ApiConfig.THETEST:
                netManager.method(netManager.getNetManager().getNetService().getTheTestInfo(), view, whichApi);
                break;
        }
    }
}
