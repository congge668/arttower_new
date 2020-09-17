package com.example.arttower.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.R;

/*
* 修改性别
* */
public class SexDialog extends DialogFragment implements ICommonView, ICommonModel {

    private View view;
    private LinearLayout mAlter_sex;
    private LinearLayout mAlterGirl;
    private LinearLayout mAlterBoy;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sex, container);
        initview(view);
        return view;
    }

    private void initview(View view) {
        mAlterBoy = view.findViewById(R.id.alter_boy);
        mAlterGirl = view.findViewById(R.id.alter_girl);
        mAlter_sex = view.findViewById(R.id.alter_sex);

        //保密
        mAlter_sex.setOnClickListener(v -> {
            Toast.makeText(getContext(), "你选择了保密", Toast.LENGTH_SHORT).show();
            SexDialog.this.dismiss();
        });
        //男
        mAlterBoy.setOnClickListener(v -> {
            Toast.makeText(getContext(), "性别男", Toast.LENGTH_SHORT).show();
            SexDialog.this.dismiss();
        });
        //女
        mAlterGirl.setOnClickListener(v -> {
            Toast.makeText(getContext(), "性别女", Toast.LENGTH_SHORT).show();
            SexDialog.this.dismiss();
        });

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

    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {

    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }
}
