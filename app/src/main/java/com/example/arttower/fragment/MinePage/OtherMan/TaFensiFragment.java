package com.example.arttower.fragment.MinePage.OtherMan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.model.HomeModel;


public class TaFensiFragment extends BaseMvpFragment<HomeModel> {


    @Override
    public int getLayoutId() {
        return R.layout.fragment_ta_fensi;
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
