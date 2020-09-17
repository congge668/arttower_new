package com.example.arttower.okHttpLog;



/**
 * author: baiiu
 * date: on 16/8/31 19:40
 * description:
 */
public class LogInterceptor implements HttpLoggingInterceptorM.Logger {

    public static String INTERCEPTOR_TAG_STR = "OkHttp";

    public LogInterceptor() {
    }

    public LogInterceptor(String tag) {
        INTERCEPTOR_TAG_STR = tag;
    }

    @Override
    public void log(String message, @HttpLogUtil.LogType int type) {
        HttpLogUtil.printLog(false, type, INTERCEPTOR_TAG_STR, message);
    }
}
