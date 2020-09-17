package com.example.arttower.fragment.MinePage.Inform;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.model.HomeModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComposeMeFragment extends BaseMvpFragment<HomeModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_compose_me;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public HomeModel getModel() {
        return null;
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }
}
