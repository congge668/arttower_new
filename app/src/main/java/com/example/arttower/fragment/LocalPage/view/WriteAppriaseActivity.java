package com.example.arttower.fragment.LocalPage.view;

import android.view.View;
import android.widget.ImageView;

import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;

import butterknife.BindView;
import butterknife.OnClick;

public class WriteAppriaseActivity extends BaseMvpActivity {
    @BindView(R.id.write_return)
    ImageView mReturn;

    @Override
    public int getLayoutId() {
        return R.layout.write_appraise_teacher;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.write_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.write_return:
                finish();
                break;
        }
    }

    @Override
    public Object getModel() {
        return null;
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }
}
