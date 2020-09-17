package com.example.arttower.activity;


import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.os.EnvironmentCompat;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.bean.AlterUserBean;
import com.example.arttower.bean.ZhanghuInitBean;
import com.example.arttower.fragment.MinePage.view.AlterNameActivity;
import com.example.arttower.fragment.MinePage.view.AlterRSAActivity;
import com.example.arttower.model.MineModel;
import com.example.arttower.view.CalendarViewS;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

/*
* 账户资料
* */


public class MainZhanghuActivity extends BaseMvpActivity<MineModel> {
    /*  生日的日历数据
     * */
    //日期数据显示
    private Button data_base;//通过滑动日历选择

    private static CalendarViewS calendarView1, calendarView2, calendarView3;
    //没有选择时，将会显示的日期，也可以根据系统获取当前时间
    private String years = "2018", months = "3", days = "13";


    //名字
    @BindView(R.id.id_name)
    TextView mName;
    @BindView(R.id.llcc)
    LinearLayout llcc;
    //头像
    @BindView(R.id.touxiang)
    ImageView mTouxiang;
    //性别
    @BindView(R.id.id_select_sex)
    TextView mSex;
    //签名
    @BindView(R.id.data_md5)
    TextView mDatamd5;
    //生日
    @BindView(R.id.id_shengri)
    TextView mShengri;
    //邮箱
    @BindView(R.id.id_em)
    TextView mEm;


    private LinearLayout mPhoto;
    private LinearLayout mCamera;


    // 拍照的requestCode
    private static final int CAMERA_REQUEST_CODE = 0x00000010;
    // 申请相机权限的requestCode
    private static final int PERMISSION_CAMERA_REQUEST_CODE = 0x00000012;
    /**
     * 用于保存拍照图片的uri
     */
    private Uri mCameraUri;
    /**
     * 用于保存图片的文件路径，Android 10以下使用图片路径访问图片
     */
    private String mCameraImagePath;
    private File tempFile;

    /**
     * 是否是Android 10以上手机
     */
    //private boolean isAndroidQ = Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main_zhanghu;
    }

    @Override
    public void initView() {
        mPresenter.getData(ApiConfig.ZHANGHU_CODE);

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getData(ApiConfig.ZHANGHU_CODE);
    }

    @OnClick({R.id.id_name, R.id.touxiang, R.id.data_md5, R.id.id_select_sex, R.id.id_shengri, R.id.id_em})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //昵称
            case R.id.id_name:
                Intent intent = new Intent(this, AlterNameActivity.class);
                String name = mName.getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
                break;
            //头像
            case R.id.touxiang:
                popwind();
                break;
            //设置签名
            case R.id.data_md5:
                Intent intent2 = new Intent(this, AlterRSAActivity.class);
                String string2 = mDatamd5.getText().toString();
                intent2.putExtra("name", string2);
                startActivity(intent2);
                break;
            //选择性别
            case R.id.id_select_sex:
                SexDialog sexDialog = new SexDialog();
                sexDialog.show(getSupportFragmentManager(), "sex");

                break;
            //生日
            case R.id.id_shengri:

                myCalendar();
                break;
            //邮箱
            case R.id.id_em:


                break;
        }
    }

    private void myCalendar() {
        //初始化对话框             R.style.CalendarDialog 是自定义的弹框主题，在styles设置
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //初始化自定义布局参数
        LayoutInflater layoutInflater = getLayoutInflater();
        //绑定布局
        View customLayout = layoutInflater.inflate(R.layout.calendarview, (ViewGroup) findViewById(R.id.customDialog));
        //为对话框设置视图
        builder.setView(customLayout);

        //加载年月日的三个 CalendarView 的 id
        calendarView1 = (CalendarViewS) customLayout.findViewById(R.id.year);
        calendarView2 = (CalendarViewS) customLayout.findViewById(R.id.month);
        calendarView3 = (CalendarViewS) customLayout.findViewById(R.id.day);

        //定义滚动选择器的数据项（年月日的）
        ArrayList<String> gradeYear = new ArrayList<>();
        ArrayList<String> gradeMonth = new ArrayList<>();
        ArrayList<String> gradeDay = new ArrayList<>();

        //为数据项赋值
        int thisYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
        for (int i = 1980; i <= thisYear; i++) //从1980到今年
            gradeYear.add(i + "");
        for (int i = 1; i <= 12; i++)            // 1月到12月
            gradeMonth.add(i + "");
        for (int i = 1; i <= 31; i++)           // 1日到31日
            gradeDay.add(i + "");

        //为滚动选择器设置数据
        calendarView1.setData(gradeYear);
        calendarView2.setData(gradeMonth);
        calendarView3.setData(gradeDay);

        //滚动选择事件
        calendarView1.setOnSelectListener(new CalendarViewS.onSelectListener() {
            @Override
            public void onSelect(String data) {
                years = data;
            }
        });
        calendarView2.setOnSelectListener(new CalendarViewS.onSelectListener() {
            @Override
            public void onSelect(String data) {
                months = data;
            }
        });
        calendarView3.setOnSelectListener(new CalendarViewS.onSelectListener() {
            @Override
            public void onSelect(String data) {
                days = data;
            }
        });
        //对话框的确定按钮
        builder.setTitle("设置生日");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String birthday = years + " 年 " + months + " 月 " + days + " 日 ";
                Toast.makeText(mApplication, birthday, Toast.LENGTH_SHORT).show();

                mPresenter.getData(ApiConfig.ALTER_ZHANGHU_SHENGRI_CODE, birthday);
            }
        });
        //对话框的取消按钮
        builder.setNegativeButton("取消", null);
        //显示对话框
        builder.show();

    }


    //TODO 点击头像弹出pop
    private void popwind() {
       /* TakeAlbumDialog takeAlbumDialog=new TakeAlbumDialog();
        takeAlbumDialog.show(getSupportFragmentManager(),"takeAlbum");*/


        //弹出popupwindow
        View inflate = LayoutInflater.from(this).inflate(R.layout.camera_photo, null);
        PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setContentView(inflate);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(810);
        //获取焦点
        popupWindow.setFocusable(true);
        //点击弹窗以外的弹窗关闭
        popupWindow.setOutsideTouchable(true);
        //弹窗位置
        popupWindow.showAsDropDown(inflate);

        mPhoto = inflate.findViewById(R.id.photo);
        mCamera = inflate.findViewById(R.id.camera);

        //相册
        mPhoto.setOnClickListener(v -> {


            mPresenter.getData(ApiConfig.HEADTU, tempFile);
            popupWindow.dismiss();

        });

        //相机
        mCamera.setOnClickListener(v -> {
            checkPermissionAndCamera();
            mPresenter.getData(ApiConfig.HEADTU, tempFile);

        });

    }

    private void checkPermissionAndCamera() {
        int hasCameraPermission = ContextCompat.checkSelfPermission(getApplication(),
                Manifest.permission.CAMERA);
        if (hasCameraPermission == PackageManager.PERMISSION_GRANTED) {
            //有权限，调起相机拍照。
            openCamera();
        } else {
            //没有权限，申请权限。
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                    PERMISSION_CAMERA_REQUEST_CODE);
        }

    }

    private void openCamera() {
        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 判断是否有相机
        if (captureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            Uri photoUri = null;

           /* if (isAndroidQ) {
                // 适配android 10
                photoUri = createImageUri();
            } else {*/
            try {
                photoFile = createImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (photoFile != null) {
                mCameraImagePath = photoFile.getAbsolutePath();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    //适配Android 7.0文件权限，通过FileProvider创建一个content类型的Uri
                    photoUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", photoFile);
                } else {
                    photoUri = Uri.fromFile(photoFile);
                }
            }
            //  }

            mCameraUri = photoUri;
            if (photoUri != null) {
                captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                captureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                startActivityForResult(captureIntent, CAMERA_REQUEST_CODE);
            }
        }

    }

    /**
     * 创建图片地址uri,用于保存拍照后的照片 Android 10以后使用这种方法
     *
     * @return 图片的uri
     */
    private Uri createImageUri() {
        String status = Environment.getExternalStorageState();
        // 判断是否有SD卡,优先使用SD卡存储,当没有SD卡时使用手机存储
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            return getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());

        } else {
            return getContentResolver().insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, new ContentValues());
        }
    }

    /**
     * 创建保存图片的文件
     *
     * @return
     * @throws IOException
     */
    private File createImageFile() throws IOException {
        String imageName = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!storageDir.exists()) {
            storageDir.mkdir();
        }
        tempFile = new File(storageDir, imageName);

        if (!Environment.MEDIA_MOUNTED.equals(EnvironmentCompat.getStorageState(tempFile))) {
            return null;
        }
        return tempFile;
    }

    @Override
    public MineModel getModel() {
        return new MineModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        Log.e("账户信息", "onError: ");
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.ZHANGHU_CODE:
                ZhanghuInitBean zhanghuInitBean = (ZhanghuInitBean) t[0];
                ZhanghuInitBean.DataBean data = zhanghuInitBean.getData();
                if (data != null) {
                    Glide.with(this).load(data.getHeadUrl()).into(mTouxiang);
                    mName.setText(data.getNickName());//用户名
                    mDatamd5.setText(data.getContent());//签名
                    mEm.setText(data.getEmail());//邮箱

                    //性别
                    if (data.getSex().equals("MALE")) {
                        mSex.setText("男");
                    } else if (data.getSex().equals("FFMALE")) {
                        mSex.setText("女");
                    } else {
                        mSex.setText("保密");
                    }


                    mShengri.setText(data.getBirthday());//生日
                }
                break;
            case ApiConfig.ALTER_ZHANGHU_SHENGRI_CODE:
                AlterUserBean alterUserBean = (AlterUserBean) t[0];
                String msg = alterUserBean.getMsg();
                Log.e("修改", "onResponse: " + msg + "生日");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
               /* if (isAndroidQ) {
                    // Android 10 使用图片uri加载
                    mTouxiang.setImageURI(mCameraUri);
                } else {*/
                // 使用图片路径加载
                mTouxiang.setImageBitmap(BitmapFactory.decodeFile(mCameraImagePath));
                // }
            } else {
                Toast.makeText(this, "取消", Toast.LENGTH_LONG).show();
            }
        }
    }

}
