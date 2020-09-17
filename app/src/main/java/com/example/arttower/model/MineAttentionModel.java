package com.example.arttower.model;

import android.util.Log;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class MineAttentionModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager netManager = NetManager.getNetManager();
        switch (whichApi) {
            case ApiConfig.MYATTENTIONCODE:
                Log.e("我的关注", "MineAttentionModel: " );
                int offset= (int) t[0];
                int rows= (int) t[1];
                String userId= (String) t[2];
                netManager.method(netManager.getNetManager().getNetService().getMyAttentiodInfo(offset,rows,userId), view, whichApi);
                break;
        }
    }
}
