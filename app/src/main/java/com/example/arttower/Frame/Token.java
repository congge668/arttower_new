package com.example.arttower.Frame;

import com.example.arttower.Frame.BaseToken;
import com.example.arttower.local_utils.SharedPrefrenceUtils;

//存储信息
public class Token extends BaseToken {
    private static String cookie;
    private static String COOKIE = "Set-Cookie";

    public static String getCookie() {
        if (!"".equals(cookie) && cookie != null) {
            return cookie;
        } else {
            cookie = SharedPrefrenceUtils.getString(BaseToken.getContext(), Token.COOKIE, "");
            return cookie;
        }
    }

    public static void setCookie(String cookie) {
        Token.cookie = cookie;
        SharedPrefrenceUtils.saveString(BaseToken.getContext(),Token.COOKIE,cookie);
    }
}
