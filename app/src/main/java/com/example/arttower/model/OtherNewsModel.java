package com.example.arttower.model;


import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class OtherNewsModel implements ICommonModel {
    NetManager mManager = NetManager.getNetManager();
    private String someoneId;

    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            //他人主页信息
            case ApiConfig.OTHERSNEWSCODE:
                someoneId = (String) t[0];
                mManager.method(mManager.getNetManager().getNetService().getOthersNewsInfo(someoneId), view, whichApi);
                break;
            //关注
            case ApiConfig.GUANZHUANDCANCAL:
                String userId= (String) t[0];
                String someoneId= (String) t[1];
                mManager.method(mManager.getNetManager().getNetService().AttentionInfo(userId,someoneId), view, whichApi);
                break;
                //个人账户资料，为了获取userid
            case ApiConfig.ZHANGHU_CODE:
                mManager.method(mManager.getNetManager().getNetService().getMyzhanghuInitInfo(), view, whichApi);
                break;
        }
    }
}
