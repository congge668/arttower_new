package com.example.arttower.model;

import android.util.Log;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

/*
 * 课程详情model
 * */
public class CoursedetailsModel implements ICommonModel {

    private String courseId;
    private String courseVideoId;

    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager netManager = NetManager.getNetManager();
        switch (whichApi) {
            case ApiConfig.TEACHERCOUSERDETAILS:
                courseId = (String) t[0];
                netManager.method(netManager.getNetManager().getNetService().getouserDetails(courseId), view, whichApi);
                break;
            //点赞
            case ApiConfig.COUSERUPLIKE:
                netManager.method(netManager.getNetManager().getNetService().getUpLikeInfo(courseId), view, whichApi);
                break;
            //取消点赞
            case ApiConfig.COUSERUPLIKEDOWN:
                netManager.method(netManager.getNetManager().getNetService().getDownLikeInfo(courseId), view, whichApi);
                break;
            //视频收藏
            case ApiConfig.COUSERUPCOLLECT:
            String courseVideoId= (String) t[0];
                netManager.method(netManager.getNetManager().getNetService().getUpCollectInfo(courseVideoId), view, whichApi);
                break;
            //取消视频收藏
            case ApiConfig.COUSERCOLLECTDOWN:
                String courseVideoId1 = (String) t[0];
                netManager.method(netManager.getNetManager().getNetService().getDownCollectInfo(courseVideoId1), view, whichApi);
                break;

            //课程的评价查询
            case ApiConfig.COUSERCOMMENT:
                String courseId = (String) t[0];
                int offset = (int) t[1];
                netManager.method(netManager.getNetManager().getNetService().getCouserCommitInfo(courseId, offset), view, whichApi);
                break;
            //课程视频的发布评论
            case ApiConfig.COUSERUPCOMMENT:
                String courseId3 = (String) t[0];
                String content= (String) t[1];
                Log.e("发布内容", "getData: "+content );
                netManager.method(netManager.getNetManager().getNetService().getcouserUpcommentInfo(courseId3,content), view, whichApi);
                break;
        }
    }
}
