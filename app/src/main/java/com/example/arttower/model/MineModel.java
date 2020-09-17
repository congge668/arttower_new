package com.example.arttower.model;

import android.util.Log;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;

/*
 * 用户信息
 * */
public class MineModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager mManager = NetManager.getNetManager();
        switch (whichApi) {
            case ApiConfig.GETMYINFO_CODE:
                mManager.method(mManager.getNetManager().getNetService().getMyInfo(), view, whichApi);
                break;
            //账户资料
            case ApiConfig.ZHANGHU_CODE:
                mManager.method(mManager.getNetManager().getNetService().getMyzhanghuInitInfo(), view, whichApi);
                break;
                //修改生日
            case ApiConfig.ALTER_ZHANGHU_SHENGRI_CODE:
                String birthday = (String) t[0];
                mManager.method(mManager.getNetManager().getNetService().getAlterUserBirthdayInfo(birthday), view, whichApi);
                Log.e("修改", "MineModel: " + "生日");
                break;
            //设置 --> 安全隐私 --> 修改密码
            case ApiConfig.SETALTERPASSWORD:
               String oldPassword= (String) t[0];
               String newPassword= (String) t[1];
                mManager.method(mManager.getNetManager().getNetService().getAlterPasswordInfo(oldPassword,newPassword), view, whichApi);

                break;
                //获取我的订单消息
                case ApiConfig.MYDINGDANXINXI:
              int offset= (int) t[0];
              int rows= (int) t[1];
                mManager.method(mManager.getNetManager().getNetService().getMyFormInfo(offset,rows), view, whichApi);

                break;

                //获取我的页面banner数据
                case ApiConfig.MYMINEBANNER:
                mManager.method(mManager.getNetManager().getNetService().getMyBanner(), view, whichApi);

                break;
        }
    }
}
