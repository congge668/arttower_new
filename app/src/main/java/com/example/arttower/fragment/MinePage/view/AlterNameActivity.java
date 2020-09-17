package com.example.arttower.fragment.MinePage.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.bean.AlterUserBean;
import com.example.arttower.model.AlterZhanghuModel;

import butterknife.BindView;
import butterknife.OnClick;

/*
* 修改用户昵称
* */
public class AlterNameActivity extends BaseMvpActivity {
    @BindView(R.id.alter_ed)
    EditText mAltered;
    @BindView(R.id.save_alter_baocun)
    Button mSaveAlter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_alter_name;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mAltered.setText(name);


    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.alter_ed, R.id.save_alter_baocun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.alter_ed:

                break;
            case R.id.save_alter_baocun:
                String name = mAltered.getText().toString();
                mPresenter.getData(ApiConfig.ALTER_ZHANGHU_NAME_CODE,  name);
                break;
        }
    }


    @Override
    public AlterZhanghuModel getModel() {
        return new AlterZhanghuModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        Log.e("修改", "onError: " );
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.ALTER_ZHANGHU_NAME_CODE:
                AlterUserBean alterUserBean= (AlterUserBean) t[0];
                String string = alterUserBean.getMsg();
                Toast.makeText(mApplication, "修改成功", Toast.LENGTH_SHORT).show();
                finish();

                break;
        }
    }
}