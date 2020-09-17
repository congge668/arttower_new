package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class QueryLabelModel implements ICommonModel {
    NetManager mManager = NetManager.getNetManager();
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.LABELQUERY:
                mManager.method(mManager.getNetManager().getNetService().getQueryLabelInfo(), view, whichApi);
                break;
                case ApiConfig.LABELHITORY:
                    int offset= (int) t[0];
                    int rows= (int) t[0];
                mManager.method(mManager.getNetManager().getNetService().getHistoryLabelInfo(offset,rows), view, whichApi);
                break;
        }
    }
}
