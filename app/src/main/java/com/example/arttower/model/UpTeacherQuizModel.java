package com.example.arttower.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class UpTeacherQuizModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TOTEACHERQUERTION:
                NetManager mManager = NetManager.getNetManager();
                String uid = (String) t[0];
                String content = (String) t[1];
                int isAnonymity = (int) t[2];
                mManager.method(mManager.getNetService().insertCourseAnonymous(uid, content, isAnonymity), view, whichApi);
                break;
        }

    }
}
