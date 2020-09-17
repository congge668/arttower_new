package com.example.arttower.fragment.HomePage.model;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

public class CommentpopModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager manager = NetManager.getNetManager();

        switch (whichApi){
           case ApiConfig.HOMECOMMENT:
               int offset= (int) t[0];
               int rows= (int) t[1];
               String userId= (String) t[2];
               String videoId= (String) t[3];
               manager.method(manager.getNetManager().getNetService().getCommentInfo(offset,rows,userId,videoId), view, whichApi);
               break;
       }
    }

}
