package com.example.arttower.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.R;
import com.example.arttower.design.CommonTitle;

/*
* 支付成功
* */
public class CustomiActivity extends AppCompatActivity implements View.OnClickListener {

    private CommonTitle mZfComm;
    private ImageView mZfcgCus;
    private RelativeLayout mZfcgRelat;
    private RecyclerView mZfcgRecycler;
    private RelativeLayout mZfcgRelativelayout;
    /**
     * 完成
     */
    private Button mZfcgBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customi);
        initView();
    }

    private void initView() {
        mZfComm = (CommonTitle) findViewById(R.id.zf_comm);
        mZfcgCus = (ImageView) findViewById(R.id.zfcg_cus);
        mZfcgRelat = (RelativeLayout) findViewById(R.id.zfcg_relat);
        mZfcgRelativelayout = (RelativeLayout) findViewById(R.id.zfcg_relativelayout);
        mZfcgBut = (Button) findViewById(R.id.zfcg_but);
        mZfcgBut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.zfcg_but:
                finish();
                break;
        }
    }
}