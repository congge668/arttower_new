package com.example.arttower.Frame;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.example.arttower.local_utils.SharedPrefrenceUtils;
import com.example.arttower.okHttpLog.HttpLoggingInterceptorM;
import com.example.arttower.okHttpLog.LogInterceptor;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import rx.Observable;
import rx.functions.Action1;

import static com.example.arttower.local_utils.NetworkUtils.isNetworkConnected;


/**
 * Created by l on 2019/4/2.
 */
public class NetInterceptor {
    private static volatile NetInterceptor sNetInterceptor;

    private NetInterceptor() {
    }

    public static NetInterceptor getNetInterceptor() {
        if (sNetInterceptor == null) {//考虑效率问题
            synchronized (NetManager.class) {
                if (sNetInterceptor == null) {//考虑多个线程问题
                    sNetInterceptor = new NetInterceptor();
                }
            }
        }
        return sNetInterceptor;
    }

    /**
     * addInterceptor 添加拦截器
     * addNetworkInterceptor 添加网络拦截器，缓存拦截器需要在这个方法和addInterceptor这个里边同时添加
     * sslSocketFactory 信任所有ssl证书，相当于跳过证书
     *
     * @return
     */
    public OkHttpClient getClientWithoutCache() {

        //看log模式需要Verbose,Tag:OkHttp
        HttpLoggingInterceptorM interceptor = new HttpLoggingInterceptorM(new LogInterceptor("http_log"));
        //打印请求和返回值的头部和body信息
        interceptor.setLevel(HttpLoggingInterceptorM.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(6000, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                //.addInterceptor(getLogInterceptor())
                .addInterceptor(new CommonHeadersInterceptor())
                .addInterceptor(new CommonParamsInterceptor())
                .addInterceptor(interceptor)
//                .addInterceptor(new CommonParamsInterceptor())
//                .addInterceptor(new CommonParamsPostInterceptor())
                .sslSocketFactory(NetTrustManager.getNetTrustManager().createSSLSocketFactory()).hostnameVerifier(new NetTrustManager.TrustAllHostnameVerifier())
                .build();
    }

    public OkHttpClient getClientWithCache() {
        return new OkHttpClient.Builder()
                .cache(new Cache(new File(BaseApplication.baseApplication.getCacheDir(), "NetCache10"), 10 * 1024 * 1024))
                .connectTimeout(6000, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(getLogInterceptor())
                .addInterceptor(new CommonHeadersInterceptor())
                .addInterceptor(cacheInterceptor(BaseApplication.getAppContext()))
                .addNetworkInterceptor(cacheInterceptor(BaseApplication.getAppContext()))
                .sslSocketFactory(NetTrustManager.getNetTrustManager().createSSLSocketFactory()).hostnameVerifier(new NetTrustManager.TrustAllHostnameVerifier())
                .build();
    }

    static HttpLoggingInterceptor getLogInterceptor() {
        //设置log拦截器拦截内容
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        HttpLoggingInterceptor.Level leve2 = HttpLoggingInterceptor.Level.HEADERS;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("------retrofit-------", message);
            }
        });
        loggingInterceptor.setLevel(level);
        loggingInterceptor.setLevel(leve2);
        return loggingInterceptor;
    }

    static class CommonHeadersInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());

            //这里获取请求返回的cookie
            List<String> headers = originalResponse.headers("Set-Cookie");
            String newCookie = null;
            if (!headers.isEmpty()) {
                flag:
                for (String header : headers) {
                    String[] split = header.split(";");
                    for (String value : split) {
                        if (value.startsWith("SHAREJSESSIONID")) {
                            newCookie = value;
                            break flag;
                        }
                    }
                }
            }
            //先读出来cookie
            String oldCookie = Token.getCookie();
            if (newCookie != null && (oldCookie == null || !oldCookie.equals(newCookie))) {
                Log.i("cookie", "更新cookie：" + newCookie);
                Token.setCookie(newCookie);
            }
            return originalResponse;
        }
    }

    static class CommonParamsInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl httpUrl = request.url()
                    .newBuilder()
                    .scheme(request.url().scheme())
                    .host(request.url().host())
                    .addQueryParameter("token1", BaseApplication.getInstance().mToken)
                    .addQueryParameter("token2", "2")
                    .build();
            Request newRequest = request.newBuilder()
                    .method(request.method(), request.body())
                    .url(httpUrl)
                    //这里直接添加cookie  不需要拦截器
                    .headers(Headers.of(NetHeaders.getHeadMap()))
//                    .addHeader("Set-Cookie", Token.getCookie())
                    .build();
            return chain.proceed(newRequest);

        }
    }

    /*static class CommonParamsPostInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            FormBody.Builder formbodyBuilder = new FormBody.Builder();
            formbodyBuilder.add("state", "app");
            formbodyBuilder.add("__openid", "");//无加密-maybe  BaseApp.getInstance().aes.encrypt(userid)
            formbodyBuilder.add("__timestamp", "");
            formbodyBuilder.add("deviceType", "");
            formbodyBuilder.add("deviceToken", new AES().encrypt("ABC"));
            formbodyBuilder.add("currenVersion", "");
            formbodyBuilder.add("buztype", ""); //buztype
            formbodyBuilder.add("userIdType", "");
            formbodyBuilder.add("__para", "");
            String rsa = RSASignature.sign(EncryptionByMD5.getMD5(getSignValue("").getBytes()), RSASignature.RSA_PRIVATE);
            formbodyBuilder.add("__sign", rsa);
            //这个是公共参数的requestBody
            RequestBody formbody = formbodyBuilder.build();
            //这个普通的RequestBody
            RequestBody body = request.body();
            //将普通的requestbody转成了字符串
            String postBodyString = bodyToString(body);
            //（如果有非公共参数，总参数字符串等于非公共参数通过&符号连接公共参数，如果没有，则只有公共参数）
            postBodyString += (postBodyString.length() > 0 ? "&" : "") + bodyToString(formbody);
            Log.i("公共参---->", "postBodyString--->=" + postBodyString);
            Request newRequest = request.newBuilder().post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"), postBodyString)).build();
            return chain.proceed(newRequest);
        }
    }

    private static String getSignValue(String buztype) {
        return "__timestamp=" + timesign
                + "&deviceType=" + BaseApp.getInstance().aes.encrypt(BaseApp.getInstance().getDeviceType())
                + "&deviceToken=" + BaseApp.getInstance().aes.encrypt(BaseApp.getInstance().getDeviceToken())
                + "&currenVersion=" + BaseApp.getInstance().aes.encrypt(BaseApp.getInstance().getCurrenVersion())
                + "&userIdType=" + BaseApp.getInstance().aes.encrypt(BaseApp.getInstance().getUserIdType())
                + "&buztype=" + BaseApp.getInstance().aes.encrypt(buztype);
    }*/

    /**
     * 网络优先数据缓存拦截器
     *
     * @return 拦截器对象
     */
    public static Interceptor cacheInterceptor(final Context context) {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();//获取请求
                //没有网络的时候强制使用缓存
                if (!isNetworkConnected(context)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                    Log.e("睚眦", "没网读取缓存");
                }
                Response response = chain.proceed(request);
                if (isNetworkConnected(context)) {
                    return response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public,max-age" + 0)
                            .build();
                } else {
                    int maxTime = 4 * 24 * 60 * 30;
                    return response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public,only-if-cached,max-state=" + maxTime)
                            .build();
                }
            }
        };
        return interceptor;
    }
}
