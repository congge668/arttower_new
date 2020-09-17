package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class SeekModel implements ICommonModel {

    private String keyword;
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager netManager = NetManager.getNetManager();
        switch (whichApi) {
            //搜索视频
            case ApiConfig.VIDEOMOHUSOUSUO:
                keyword = (String) t[0];
                netManager.method(netManager.getNetManager().getNetService().getVideoReteievalInfo(keyword), view, whichApi);
                break;
            //搜索用户
            case ApiConfig.UCERMOHUSUOSUO:
                netManager.method(netManager.getNetManager().getNetService().getUserDimSeekInfo(keyword), view, whichApi);
                break;
            //搜索课程
            case ApiConfig.TESTMOHUSOUSUO:
                netManager.method(netManager.getNetManager().getNetService().getTestDimSeekInfo(keyword), view, whichApi);
                break;
        }
    }
}
