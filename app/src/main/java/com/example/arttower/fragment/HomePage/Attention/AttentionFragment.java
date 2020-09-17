package com.example.arttower.fragment.HomePage.Attention;

import androidx.fragment.app.Fragment;

import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.model.HomeModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttentionFragment extends BaseMvpFragment<HomeModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_attention;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }
}
