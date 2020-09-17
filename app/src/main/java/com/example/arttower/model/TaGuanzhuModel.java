package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class TaGuanzhuModel implements ICommonModel {
    NetManager manager = NetManager.getNetManager();
    private int offset;
    private int rows;

    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.GUANZHU:
                offset = (int) t[0];
                rows = (int) t[1];
                String someoneId= (String) t[2];
                manager.method(manager.getNetService().getTaGuanzhuInfo(offset, rows,someoneId), view, whichApi);
                break;
            case ApiConfig.FENSI:
                int offset2 = (int) t[0];
                int rows2= (int) t[1];
                String someoneId2 = (String) t[2];
                manager.method(manager.getNetService().getTafensiInfo(offset2, rows2,someoneId2), view, whichApi);
                break;
        }

    }
}
