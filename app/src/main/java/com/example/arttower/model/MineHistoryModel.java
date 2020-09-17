package com.example.arttower.model;

import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class MineHistoryModel implements ICommonModel {
    NetManager mManager = NetManager.getNetManager();
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {

    }
}
