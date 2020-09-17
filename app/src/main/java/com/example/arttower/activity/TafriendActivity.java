package com.example.arttower.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.fragment.MinePage.OtherMan.TaFensiFragment;
import com.example.arttower.fragment.MinePage.OtherMan.TaGuanzhuFragment;
import com.example.arttower.model.MineCollectionModel;

import butterknife.BindView;

/*
 * 他的关注
 *
 * */
public class TafriendActivity extends BaseMvpActivity<MineCollectionModel> {
    @BindView(R.id.tx_ta)
    TextView txTa;
    @BindView(R.id.tab_tahaoyou)
    XTabLayout tabTahaoyou;
    private TaGuanzhuFragment taGuanzhuFragment;
    private TaFensiFragment taFensiFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_tafriend;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");

        Bundle bundle = new Bundle();
        bundle.putString("userid", userid);

        taGuanzhuFragment = new TaGuanzhuFragment();
        taFensiFragment = new TaFensiFragment();
        tabTahaoyou.addTab(tabTahaoyou.newTab().setText("TA的关注"));
        tabTahaoyou.addTab(tabTahaoyou.newTab().setText("TA的粉丝"));
        taFensiFragment.setArguments(bundle);
        taGuanzhuFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, taGuanzhuFragment)
                .add(R.id.frame, taFensiFragment)
                .show(taGuanzhuFragment)
                .hide(taFensiFragment)
                .commit();

        tabTahaoyou.addOnTabSelectedListener(new XTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(XTabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    getSupportFragmentManager().beginTransaction()
                            .show(taGuanzhuFragment)
                            .hide(taFensiFragment)
                            .commit();
                } else {
                    getSupportFragmentManager().beginTransaction()
                            .hide(taGuanzhuFragment)
                            .show(taFensiFragment)
                            .commit();
                }
            }

            @Override
            public void onTabUnselected(XTabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(XTabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public MineCollectionModel getModel() {
        return new MineCollectionModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

}
