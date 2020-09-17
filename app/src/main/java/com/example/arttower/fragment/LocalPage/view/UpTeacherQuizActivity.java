package com.example.arttower.fragment.LocalPage.view;


import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.bean.AlterUserBean;
import com.example.arttower.model.UpTeacherQuizModel;

import java.io.FileNotFoundException;

import butterknife.BindView;
import butterknife.OnClick;

public class UpTeacherQuizActivity extends BaseMvpActivity<UpTeacherQuizModel> {
    @BindView(R.id.up_return)
    ImageView mReturn;
    @BindView(R.id.up_teacher_quiz_ed)
    EditText mUp_Quiz_ed;
    @BindView(R.id.up_switch_selector)
    Switch mUpSwitch_Selector;
    private String uid;
    @BindView(R.id.dy_paizhao)
    ImageView Dy_paizhao;

    @BindView(R.id.dy_image)
    ImageView dy_image;


    private int TAKE_PHOTO=1;   //拍照
    private int GET_PHOTO=2;    //取照片
    @Override
    public int getLayoutId() {
        return R.layout.up_tearcher_quiz;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        uid = intent.getStringExtra("uid");

        Dy_paizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View inflate = LayoutInflater.from(UpTeacherQuizActivity.this).inflate(R.layout.pupopw_item, null, false);

                PopupWindow popupWindow = new PopupWindow(inflate, GridView.MarginLayoutParams.MATCH_PARENT, GridView.MarginLayoutParams.WRAP_CONTENT);


                //拍照
                TextView paizhao = inflate.findViewById(R.id.paizhao);
                //相册
                TextView xiangce = inflate.findViewById(R.id.xiangce);
                //取消
                TextView quxiao = inflate.findViewById(R.id.quxiao);

                paizhao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, TAKE_PHOTO);
                    }

                });
                //相册
                xiangce.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*");
                        startActivityForResult(intent, GET_PHOTO);
                    }
                });
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

                // 设置背景
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.setFocusable(true);// 取得焦点
                // 点击空白的地方关闭PopupWindow
                popupWindow.setBackgroundDrawable(new BitmapDrawable());

                popupWindow.showAtLocation(inflate, Gravity.BOTTOM, 0, 0);



            }
        });

    }

    @Override
    public void initData() {


    }



    @OnClick({R.id.up_return, R.id.up_teacher_quiz_ed, R.id.up_teacher_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.up_return:
                finish();
                break;
                //发表
            case R.id.up_teacher_submit:
                //获取输入框文字
                String content = mUp_Quiz_ed.getText().toString().trim();
                //是否匿名
                int isAnonymity;
                if (mUpSwitch_Selector.isChecked()) {
                    isAnonymity = 1;
                } else {
                    isAnonymity = 0;
                }
                //向老师提问
                mPresenter.getData(ApiConfig.TOTEACHERQUERTION, uid, content, isAnonymity);
                break;

        }
    }

    @Override
    public UpTeacherQuizModel getModel() {
        return new UpTeacherQuizModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        Log.i("info", "UpTeacherQuizActivity------------------------------" + e.getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        Log.i("info", "UpTeacherQuizActivity------------------------------" + t[0].toString());
        switch (whichApi) {
            case ApiConfig.TOTEACHERQUERTION:
                AlterUserBean bean = (AlterUserBean) t[0];

                Toast.makeText(UpTeacherQuizActivity.this, bean.getMsg(), Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

    //接接收回传值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {  //回传值接受成功

            if (requestCode == TAKE_PHOTO) {    //拍照取图

                Bundle bundle = data.getExtras();   //获取data数据集合
                Bitmap bitmap = (Bitmap) bundle.get("data");        //获得data数据
                Log.i("TAG", "拍照回传bitmap："+bitmap);
                dy_image.setImageBitmap(bitmap);

            }

            if (requestCode == GET_PHOTO) {     //相册取图

                ContentResolver contentResolver = getContentResolver();
                try {

                    Bitmap bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(data.getData()));
                    Log.i("TAG", "从相册回传bitmap："+bitmap);
                    dy_image.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}