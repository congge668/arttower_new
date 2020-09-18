package com.example.arttower.other;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.R;
import com.example.arttower.adapter.HomeCommentAdapter;
import com.example.arttower.utils.ToastUtils;
import com.youth.banner.util.BannerUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


public class DialogUtils {



    public static HomeCommentAdapter homeCommentDialog(Context context, List<HomeCommentListBean.DataBean.RowsBean> datas,HomeCommentDialogEvent event) {
        AlertDialog dialog = getAlertDialog(context, true);
        dialog.show();
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setContentView(R.layout.dialog_home_comment);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        RecyclerView rvComment = window.findViewById(R.id.rv_home_comment);
        rvComment.setLayoutManager(new LinearLayoutManager(context));
        HomeCommentAdapter adapter = new HomeCommentAdapter(context,datas);
        rvComment.setAdapter(adapter);

        EditText et_comment = window.findViewById(R.id.et_comment);
        TextView tv_comment_send = window.findViewById(R.id.tv_comment_send);
        tv_comment_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(et_comment.getText().toString())){
                    ToastUtils.show(context,"请输入内容");
                } else {
                    event.setApiConfig(ApiConfig.add_home_comment);
                    event.setVideoContent(et_comment.getText().toString()); //评论内容
                    EventBus.getDefault().post(event);
                    et_comment.setText("");
                    hideKeyboard(et_comment);
                }

            }
        });

        return adapter;
    }

    private static void hideKeyboard(EditText editText) {
        if (editText != null) {
            //调用系统输入法
            InputMethodManager inputManager = (InputMethodManager) editText
                    .getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);

        }
    }


    public static AlertDialog getAlertDialog(Context context) {
        return new AlertDialog.Builder(context, R.style.mydialog).setCancelable(false).create();
    }

    public static AlertDialog getAlertDialog(Context context, boolean canBack) {
        return new AlertDialog.Builder(context, R.style.mydialog).setCancelable(canBack).create();
    }


}
