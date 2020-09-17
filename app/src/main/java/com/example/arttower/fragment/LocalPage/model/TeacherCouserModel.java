package com.example.arttower.fragment.LocalPage.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class TeacherCouserModel implements ICommonModel {

    private int offset;
    private int rows;
    private String uid;

    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager mManager = NetManager.getNetManager();
        switch (whichApi) {
            //课程
            case ApiConfig.TEACHERCOUSERRLV:
                offset = (int) t[0];
                rows = (int) t[1];
                uid = (String) t[2];
                mManager.method(mManager.getNetManager().getNetService().getTeacherCouserInfo(offset, rows, uid), view, whichApi);
                break;
            //教师评价
            case ApiConfig.TEACHERAPPRAISERLV:
                mManager.method(mManager.getNetManager().getNetService().getTeacherAppraiseInfo(offset, rows, uid), view, whichApi);
                break;
            //教师答疑数据
            case ApiConfig.TEACHERANSWERRLV:
                String uid = (String) t[2];
                mManager.method(mManager.getNetManager().getNetService().getTeacherAnswerInfo(offset, rows, uid), view, whichApi);
                break;
            //课程详情
            case ApiConfig.TEACHERCOUSERDETAILS:
                String courseId = (String) t[0];
                mManager.method(mManager.getNetManager().getNetService().getouserDetails(courseId), view, whichApi);
                break;

                //支付的公钥
            case ApiConfig.UPPAYPASSWORDKEY:
                mManager.method(mManager.getNetManager().getNetService().getRSApasswordInfo(), view, whichApi);
                break;

                //检查支付密码是否正确
            case ApiConfig.EXAMINEPAYPASSWORD:
                String payPassword= (String) t[0];
                mManager.method(mManager.getNetManager().getNetService().ExaminepassowrdInfo(payPassword), view, whichApi);
                break;

                //预支付订单
            case ApiConfig.PREPAYMENTDINGDAN:

                break;
        }
    }
}
