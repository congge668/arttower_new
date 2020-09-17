package com.example.arttower.fragment.HomePage.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.arttower.R;

/*
* 分享dialog
* */
public class Share_popDialog extends DialogFragment {
    private View view;
    private ImageView mShare_pop_friend;
    private ImageView mShare_pop_wx;
    private ImageView mShare_pop_qq;
    private ImageView mShare_pop_link;
    private Button mCancel_share;
    private Share_popDialog share_popDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pop_share, container);
        initview(view);
        return view;

    }

    private void initview(View view) {
        mShare_pop_friend = view.findViewById(R.id.share_pop_friend); //朋友圈
        mShare_pop_wx = view.findViewById(R.id.share_pop_wx);         //微信好友
        mShare_pop_qq = view.findViewById(R.id.share_pop_qq);         //QQ
        mShare_pop_link = view.findViewById(R.id.share_pop_link);     //链接分享
        mCancel_share = view.findViewById(R.id.cancel_share);         //取消分享


        mCancel_share.setOnClickListener(v -> {
            Toast.makeText(getContext(), "取消分享", Toast.LENGTH_SHORT).show();
            Share_popDialog.this.dismiss();
        });

        mShare_pop_friend.setOnClickListener(v -> {
            Toast.makeText(getContext(), "分享到朋友圈", Toast.LENGTH_SHORT).show();
            Share_popDialog.this.dismiss();
        });
        mShare_pop_wx.setOnClickListener(v -> {
            Toast.makeText(getContext(), "分享到微信好友", Toast.LENGTH_SHORT).show();
            Share_popDialog.this.dismiss();
        });
        mShare_pop_qq.setOnClickListener(v -> {
            Toast.makeText(getContext(), "分享到QQ", Toast.LENGTH_SHORT).show();
            Share_popDialog.this.dismiss();
        });
        mShare_pop_link.setOnClickListener(v -> {
            Toast.makeText(getContext(), "链接分享", Toast.LENGTH_SHORT).show();
            Share_popDialog.this.dismiss();
        });

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onResume() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
        Window window = getDialog().getWindow();
        window.setBackgroundDrawableResource(android.R.color.white);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(wlp);
        super.onResume();
    }


}
