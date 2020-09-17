package com.example.arttower.model;

import android.util.Log;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class MineCollectionModel implements ICommonModel {

    NetManager mManager = NetManager.getNetManager();
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.SHOUCANG:
                int offset = (int) t[0];
                int rows = (int) t[1];
                String userId= (String) t[2];
                mManager.method(mManager.getNetManager().getNetService().getCollectInfo(offset, rows,userId), view, whichApi);
                break;
            case ApiConfig.ITSHOUCANG:
                int offset1 = (int) t[0];
                int rows1 = (int) t[1];
                Log.e("他人收藏数据", "MineCollectionModel: ");
              //  String userid = (String) t[2];
               // mManager.method(mManager.getNetManager().getNetService().getItCollectInfo(offset1, rows1, userid), view, whichApi);
                mManager.method(mManager.getNetManager().getNetService().getItCollectInfo(offset1, rows1), view, whichApi);
                break;
        }
    }
}
