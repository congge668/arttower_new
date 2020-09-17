package com.example.arttower.local_utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.arttower.Frame.BaseApplication;


/**
 * Created by l on 2019/5/10.
 */
public class VersionUtils {
    public static int getVersionCode(){
        PackageInfo info = null;
        try {
            info = BaseApplication.baseApplication.getPackageManager().getPackageInfo(BaseApplication.baseApplication.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException pE) {
            pE.printStackTrace();
        }
        return info.versionCode;
    }
}
