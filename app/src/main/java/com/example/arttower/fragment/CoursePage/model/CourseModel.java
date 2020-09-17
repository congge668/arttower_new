package com.example.arttower.fragment.CoursePage.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class CourseModel implements ICommonModel {
    NetManager mManager = NetManager.getNetManager();
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.COURSE_DATA:
                //传入参数的位置
                int offset = (int) t[0];
                int rows = (int) t[1];
                mManager.method(mManager.getNetManager().getNetService().getCourseInfo(offset, rows), view, whichApi);
                break;
        }
    }
}
