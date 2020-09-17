package com.example.arttower.fragment.LocalPage.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class TeacherDataModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager mManager = NetManager.getNetManager();
        switch (whichApi) {
            //个人介绍
            case ApiConfig.TEACHERDATARLV:
                String uid = (String) t[0];
                mManager.method(mManager.getNetManager().getNetService().getTeacherdataInfo(uid), view, whichApi);
                break;
            //获取用户id
            case ApiConfig.ZHANGHU_CODE:
                mManager.method(mManager.getNetManager().getNetService().getMyzhanghuInitInfo(), view, whichApi);
                break;
                //关注和取消关注
            case ApiConfig.GUANZHUANDCANCAL:
                String userId= (String) t[0];
                String someoneId= (String) t[1];
                mManager.method(mManager.getNetManager().getNetService().AttentionInfo(userId,someoneId), view, whichApi);
                break;
        }
    }
}
