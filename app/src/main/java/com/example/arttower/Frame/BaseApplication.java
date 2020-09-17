package com.example.arttower.Frame;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.example.arttower.local_utils.DeviceUuidFactory;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import java.util.UUID;

public class BaseApplication extends MultiDexApplication {
    public static BaseApplication baseApplication;
    public UUID mUuid;
    public String mToken = "";
    public String mUserPhoto = "";
    public boolean mImIsLogin = false;
    public boolean mPlayInWifi;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        mUuid = DeviceUuidFactory.getInstance(getApplicationContext()).getDeviceUuid();
        MultiDex.install(this);
        Log.e("uuid:", mUuid + "\n" + mUuid.toString());
        UMConfigure.init(this, "5ef9492cdbc2ec08212b5a4a"
                , "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        umeng();
    }

    private void umeng() {
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setSinaWeibo("1822829346", "351e42bdf274d353dfbf3451850d3a7c", "http://sns.whalecloud.com");
        PlatformConfig.setQQZone("101883897", "450f8eecb4fcb61e9f82a1187cd2ff29");
//        PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
//        PlatformConfig.setAlipay("2015111700822536");
//        PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
//        PlatformConfig.setPinterest("1439206");
//        PlatformConfig.setKakao("e4f60e065048eb031e235c806b31c70f");
//        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");
//        PlatformConfig.setVKontakte("5764965","5My6SNliAaLxEm3Lyd9J");
//        PlatformConfig.setDropbox("oz8v5apet3arcdy","h7p2pjbzkkxt02a");
//        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
//        PlatformConfig.setYnote("9c82bf470cba7bd2f1819b0ee26f86c6ce670e9b");
    }

    public static BaseApplication getInstance() {
        return baseApplication;
    }

    public static Context getAppContext() {
        return baseApplication.getApplicationContext();
    }


}
