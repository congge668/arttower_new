package com.example.arttower.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arttower.R;

/*
 * 体态认证
 * */
public class PostureActivity extends AppCompatActivity {
    private String URI = "http://47.94.198.85:9000/physical/index.html";
    private WebView mWebTitai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posture);
        initView();
    }

    @SuppressLint("JavascriptInterface")
    private void initView() {
        mWebTitai = (WebView) findViewById(R.id.titai_web);

        WebSettings settings = mWebTitai.getSettings();
        //与js交互必须设置
        settings.setJavaScriptEnabled(true);

        //允许js弹窗
        settings.setJavaScriptCanOpenWindowsAutomatically(true);

        mWebTitai.addJavascriptInterface(PostureActivity.this, "android");

        //设置自适应屏幕，两者合用
        settings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        //设置网页支持缩放
        //缩放操作
        settings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        settings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        settings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        //加载地址
        mWebTitai.loadUrl(URI);

     /*   mWebTitai.evaluateJavascript(TITAI, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                Log.e("我的体态", "onReceiveValue: "+value );
            }
        });*/

        mWebTitai.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                //判断url拦截事件
                if (URI.equals("http://47.94.198.85:9000/physical/index.html")) {
                    Log.e("TAG", "shouldOverrideUrlLoading: " + URI);
                    return true;
                } else {
                    mWebTitai.loadUrl(URI);
                    return false;
                }

            }

            //开始载入页面调用的,
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

            }

            //在页面加载结束时调用.我们可以关闭loading条,切换程序动作
            @Override
            public void onPageFinished(final WebView view, String url) {

                //访问JS方法
                mWebTitai.post(new Runnable() {
                    @Override
                    public void run() {
                        mWebTitai.loadUrl("javascript:htmlCall( )");
                    }
                });
            }

        });

    }
    //Android调用有返回值js方法
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void onClick(View v) {

        mWebTitai.evaluateJavascript(URI, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {

            }
        });
    }
    public class JsInteration {

        @JavascriptInterface
        public String back() {
            return "hello world";
        }
    }
}