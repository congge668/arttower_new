package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

/*
 * 首页视频
 * */
public class HomeModel implements ICommonModel {

    private int rows;
    private int offset;

    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager mManager = NetManager.getNetManager();
        switch (whichApi) {
            case ApiConfig.VIDEO_DATA:
                rows = (int) t[1];
                offset = (int) t[0];
                //首页视频
                mManager.method(mManager.getNetManager().getNetService().getVideoInfo(offset, rows), view, whichApi);
                break;
            case ApiConfig.COURSE_DATA:
                //课程推荐页
                mManager.method(mManager.getNetManager().getNetService().getCourseInfo(offset, rows), view, whichApi);
                break;
            case ApiConfig.NEWSREPLYMY:
                //消息通知——回复我的
                mManager.method(mManager.getNetManager().getNetService().getNewsReplyMyInfo(offset, rows), view, whichApi);
                break;
            case ApiConfig.LIKEMY:
                //消息通知——点赞我的
                mManager.method(mManager.getNetManager().getNetService().getNewsReplyMyInfo(offset, rows), view, whichApi);
                break;

            //开屏动画
            case ApiConfig.CARRYOUT:
                mManager.method(mManager.getNetManager().getNetService().getCarryoutAdvertisingInfo(), view, whichApi);
                break;
        }
    }
}
