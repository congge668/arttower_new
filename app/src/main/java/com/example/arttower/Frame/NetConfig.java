package com.example.arttower.Frame;

/**
 * Created by l on 2019/6/27.
 */
public class NetConfig {
    public static String BaseUrl;
    public static int API_TYPE = 1;//1:正式服务器 2：外测服务器 3：内测服务器
    public static String DQD_BASE1 = "http://47.94.198.85:9001/heartodance/";

    static {
        if (API_TYPE == 1) BaseUrl = "http://47.94.198.85:9001/heartodance/";
        else if (API_TYPE == 2) BaseUrl = "";
        else BaseUrl = "";
    }
}
