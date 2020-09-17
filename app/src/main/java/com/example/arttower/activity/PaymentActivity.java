package com.example.arttower.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.bean.JianchapasswordBean;
import com.example.arttower.bean.RSApsdWordBean;
import com.example.arttower.fragment.LocalPage.model.TeacherCouserModel;
import com.example.arttower.local_utils.RSAUtils;

import butterknife.BindView;
import butterknife.OnClick;

/*
* 创建订单
* */
public class PaymentActivity extends BaseMvpActivity<TeacherCouserModel> {

    private static final String PRIVATE_KEY = "RSAPrivateKey";
    ;
    @BindView(R.id.affirm_zf_image)//图片
            ImageView mZfImage;
    @BindView(R.id.affirm_zf_goumai)//购买
            Button mZfGoumai;
    @BindView(R.id.affirm_zf_name)
    TextView mZfName;
    @BindView(R.id.affirm_teacherName)
    TextView mteacherZfName;
    @BindView(R.id.affirm_zf_pric)
    TextView mZforiginPric;
    @BindView(R.id.affirm_fukuan_wubi)
    TextView mfukuanconPric;
    @BindView(R.id.affirm_practical_fukuan)
    TextView mactualzfPric;
private String psd="";
    @Override
    public int getLayoutId() {
        return R.layout.activity_payment;
    }

    public void initView() {
        Intent intent = getIntent();
        String price = intent.getStringExtra("testprice");
        String courseName = intent.getStringExtra("testname");
        String coverImg = intent.getStringExtra("headimg");
        String username = intent.getStringExtra("username");
        String originaltestprice = intent.getStringExtra("originaltestprice");

        String indentTimer = intent.getStringExtra("indentTimer");//订单创建时间

        Glide.with(this).load(coverImg).into(mZfImage);
        mZforiginPric.setText(originaltestprice);
        mfukuanconPric.setText(originaltestprice);
        mactualzfPric.setText(price);
        Log.e("实际支付价格", "initView: " + price);
        mteacherZfName.setText(username);
        mZfName.setText(courseName);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.affirm_zf_goumai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.affirm_zf_goumai:
                Intent intent = new Intent(this, CustomiActivity.class);
                mPresenter.getData(ApiConfig.UPPAYPASSWORDKEY);
                startActivity(intent);
                break;
        }
    }

    @Override
    public TeacherCouserModel getModel() {
        return new TeacherCouserModel();
    }


    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.UPPAYPASSWORDKEY:
                break;
            case ApiConfig.EXAMINEPAYPASSWORD:
                Log.e("支付密码是否正确", "onError: " + e.getMessage());
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.UPPAYPASSWORDKEY:
                RSApsdWordBean rsApsdWordBean = (RSApsdWordBean) t[0];
                String data = rsApsdWordBean.getData();
                Log.e("支付的公钥", "onResponse: " + data);
                //对公钥进行加密
                String base64Value = RSAUtils.getBase64Value(data);
                String jiamigongyao = RSAUtils.encryptedDataOnJava(psd, base64Value);
                //对公钥加密完成后进行检查
                Log.e("支付的公钥", "onResponse: "+base64Value);
                mPresenter.getData(ApiConfig.EXAMINEPAYPASSWORD,jiamigongyao);
                break;
            case ApiConfig.EXAMINEPAYPASSWORD:
                JianchapasswordBean jianchapasswordBean = (JianchapasswordBean) t[0];
                String msg = jianchapasswordBean.getMsg();
                Log.e("支付密码是否正确", "onResponse: " + msg);
                break;
        }
    }
}