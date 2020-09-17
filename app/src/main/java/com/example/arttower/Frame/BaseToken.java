package com.example.arttower.Frame;

import android.content.Context;

public class BaseToken {
    private static Context context = null;

    /**
     * 获取上下文信息
     *
     * @return 上下文
     */
    public static Context getContext() {
        if (BaseToken.context != null) {
            return BaseToken.context;
        }
        return BaseApplication.getAppContext();
    }

    public static void setContext(Context cont) {
        if (BaseToken.getContext() == null && cont != null) {
            BaseToken.context = cont;
        }
    }
}
