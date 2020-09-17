package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

import retrofit2.http.Query;

/*
 * 首页视频
 * */
public class HomeModel implements ICommonModel {

    private int rows;
    private int offset;

    private String userId;
    private String videoId;
    private String uid;
    private String content;

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
            case ApiConfig.home_comment_list:
                offset = (int) t[0];
                rows = (int) t[1];
                 userId= (String) t[2];
                 videoId= (String) t[3];
                uid= (String) t[4];
                content = (String) t[5];
                mManager.method(mManager.getNetManager().getNetService().queryCommentList(offset,rows,userId,videoId,uid,content), view, whichApi);
                break;

        }
    }
}
