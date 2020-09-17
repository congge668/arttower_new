package com.example.arttower.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.adapter.OtherRenAdapter;
import com.example.arttower.bean.AlterUserBean;
import com.example.arttower.bean.OthersNewsBean;
import com.example.arttower.bean.ZhanghuInitBean;
import com.example.arttower.model.OtherNewsModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

//他人主页
public class OtherpageActivity extends BaseMvpActivity<OtherNewsModel> {
    @BindView(R.id.ic_ot_head)
    ImageView mIcothead;
    @BindView(R.id.ot_rlv)
    RecyclerView mOtRlv;
    @BindView(R.id.ot_guanzhu)
    TextView mOt_guanzhu;


    @BindView(R.id.ot_user_name)
    TextView mOtusername;
    @BindView(R.id.num_kecheng)
    TextView mNum_kecheng;
    @BindView(R.id.ot_num_fensi)
    TextView mOt_num_fensi;
    @BindView(R.id.ot_num_guanzhu)
    TextView mOt_num_guanzhu;
    @BindView(R.id.ot_num_shoucang)
    TextView mOt_num_shoucang;
    @BindView(R.id.ot_num_shengwang)
    TextView mOt_num_shengwang;

    //用户的id  根据获取到用户信息
    private String someoneId;
    private String userId;
    private OthersNewsBean.DataBean data;
    private ArrayList<OthersNewsBean.DataBean> list;
    private OtherRenAdapter adapter;
    //登录的账户的id
    private String userid;

    @Override
    public int getLayoutId() {
        return R.layout.activity_otherpage;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        //首页视频传过来的id
        someoneId = intent.getStringExtra("id");
        //他人的个人信息
        mPresenter.getData(ApiConfig.OTHERSNEWSCODE, someoneId);

        //获取到当前登录用户的userid
        mPresenter.getData(ApiConfig.ZHANGHU_CODE);
    }

    @Override
    public void initData() {
        //他人主页的rlv数据
        mOtRlv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list = new ArrayList<>();
        adapter = new OtherRenAdapter(this, list);
        mOtRlv.setAdapter(adapter);

    }

    @Override
    public OtherNewsModel getModel() {
        return new OtherNewsModel();
    }

    @OnClick({R.id.ot_tx_fensi, R.id.ot_tx_kecheng, R.id.ot_tx_shoucang, R.id.ot_tx_guanzhu, R.id.ot_guanzhu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //粉丝
            case R.id.ot_tx_fensi:
                Intent fensi = new Intent(this, TafriendActivity.class);
                fensi.putExtra("userid",userId);
                startActivity(fensi);
                break;
            //关注
            case R.id.ot_tx_guanzhu:
                Intent guanzhu = new Intent(this, TafriendActivity.class);
                guanzhu.putExtra("userid",userId);
                startActivity(guanzhu);

                break;
            //课程
            case R.id.ot_tx_kecheng:
                Intent kecheng = new Intent(this, CurriCulumActivity.class);
                startActivity(kecheng);
                break;
            //收藏
            case R.id.ot_tx_shoucang:
                this.userId = data.getUserId();
                Intent intent = new Intent(this, ItCollectionActivity.class);
                intent.putExtra("userid", this.userId);
                startActivity(intent);

                break;
            //关注
            case R.id.ot_guanzhu:
                mPresenter.getData(ApiConfig.GUANZHUANDCANCAL, userid, someoneId);

                break;
        }
    }


    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.OTHERSNEWSCODE:
                Log.e("他的主页", "onError: " );
                break;
            case ApiConfig.ZHANGHU_CODE:
                Log.e("获得登录用户的信息", "onError: " );
                break;
            case ApiConfig.GUANZHUANDCANCAL:
                Log.e("关注和取消关注", "onError: " );
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.OTHERSNEWSCODE:
                OthersNewsBean othersNewsBean = (OthersNewsBean) t[0];
                data = othersNewsBean.getData();
                if (data != null) {
                    mOtusername.setText(data.getNickName()); //用户名
                    mOt_num_fensi.setText("" + data.getFansCount()); //粉丝
                    mOt_num_guanzhu.setText("" + data.getFocusCount());//关注
                    mNum_kecheng.setText("" + data.getCourseNum()); //课程数量
                    if (data.getHeadUrl()!=null){
                        Glide.with(this).load(data.getHeadUrl()).into(mIcothead);//头像
                    }
                    Log.e("头像", "onResponse: "+data.getHeadUrl() );
                    mOt_num_shoucang.setText("" + data.getCollectNum());//收藏
                    mOt_num_shengwang.setText("声望：" + data.getPrestige());

                    //是否关注
                    String isFocus = (String) data.getIsFocus();
                    if (isFocus.equals("0")) {
                        mOt_guanzhu.setText("关注");
                    } else {
                        mOt_guanzhu.setText("已关注");
                    }
                }
                break;
            case ApiConfig.ZHANGHU_CODE:
                //账户信息
                ZhanghuInitBean zhanghuInitBean = (ZhanghuInitBean) t[0];
                //userid = zhanghuInitBean.getData().getId();

                break;
            case ApiConfig.GUANZHUANDCANCAL:
                //关注和取消关注
                AlterUserBean alterUserBean = (AlterUserBean) t[0];
                Toast.makeText(mApplication, alterUserBean.getMsg(), Toast.LENGTH_SHORT).show();
                initView();
                break;
        }
    }
}