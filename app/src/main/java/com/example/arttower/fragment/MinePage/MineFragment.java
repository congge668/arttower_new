package com.example.arttower.fragment.MinePage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.activity.FeedbackActivity;
import com.example.arttower.activity.MineAttentionActivity;
import com.example.arttower.activity.MineCollectionActivity;
import com.example.arttower.activity.MineHistoryActivity;
import com.example.arttower.activity.MineSetActivity;
import com.example.arttower.activity.MoneyChongActivity;
import com.example.arttower.activity.MyDynamicActivity;
import com.example.arttower.activity.OrderformActivity;
import com.example.arttower.activity.PostureActivity;
import com.example.arttower.activity.TeacherActivity;
import com.example.arttower.activity.WdInformActivity;
import com.example.arttower.bean.MineBean;
import com.example.arttower.bean.MyMineBannerBean;
import com.example.arttower.fragment.MinePage.view.MineFansActivity;
import com.example.arttower.local_utils.SharedPrefrenceUtils;
import com.example.arttower.model.MineModel;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

//我的页面

public class MineFragment extends BaseMvpFragment<MineModel> {
    @BindView(R.id.xiaoxi)//消息
            ImageView xiaoxi;

    @BindView(R.id.iv_set)//设置
            ImageView ivSet;

    @BindView(R.id.ic_mine_head)//头像
            ImageView icMineHead;
    @BindView(R.id.user_name)//昵称
            TextView userName;
    @BindView(R.id.tv_shengwang)//声望
            TextView tvShengwang;

    @BindView(R.id.mine_wubi)
    TextView wubi;

    @BindView(R.id.rl_guanzhu)
    RelativeLayout mRlGuanZhu;

    @BindView(R.id.num_guanzhu)
    TextView numGuanzhu;
    @BindView(R.id.rl_fensi)
    RelativeLayout mRlFensi;

    @BindView(R.id.num_fensi)
    TextView numFensi;

    @BindView(R.id.num_dongtai)
    TextView numDongtai;
    @BindView(R.id.rl_dongtai)
    RelativeLayout mRlDongtai;

    @BindView(R.id.mine_balance)
    TextView mBalance;
    @BindView(R.id.ll_titai)
    LinearLayout llTitai;
    @BindView(R.id.ll_shoucang)
    LinearLayout llShoucang;
    @BindView(R.id.ll_dingdan)
    LinearLayout llDingdan;
    @BindView(R.id.ll_teacher)
    LinearLayout llTeacher;
    @BindView(R.id.ll_xiazai)
    LinearLayout llGuanzhu;
    @BindView(R.id.ll_lishijvlu)
    LinearLayout llLishijvlu;
    @BindView(R.id.ll_shezhi)
    LinearLayout llShezhi;
    @BindView(R.id.ll_wenti)
    LinearLayout llWenti;


    @BindView(R.id.wd_banner)
    Banner mBanner;


    static MineFragment fragment;
    private MineBean.DataBean data;
    private String userId;

    public static MineFragment newInstance() {
        if (fragment == null) fragment = new MineFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        mPresenter.getData(ApiConfig.GETMYINFO_CODE);
        super.onStart();

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    //点击事件
    @OnClick({R.id.xiaoxi, R.id.iv_set, R.id.ic_mine_head,
            R.id.wd_banner, R.id.ll_titai, R.id.ll_shoucang,
            R.id.ll_dingdan, R.id.ll_teacher, R.id.ll_xiazai, R.id.ll_lishijvlu,
            R.id.ll_shezhi, R.id.ll_wenti, R.id.rl_guanzhu, R.id.rl_fensi, R.id.rl_dongtai,R.id.mine_balance})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //消息
            case R.id.xiaoxi:
                startActivity(new Intent(getContext(), WdInformActivity.class));
                break;
            //设置
            case R.id.iv_set:
                startActivity(new Intent(getContext(), MineSetActivity.class));
                break;
            //头像
            case R.id.ic_mine_head:

                break;
            //体态
            case R.id.ll_titai:
                startActivity(new Intent(getContext(), PostureActivity.class));
                break;
            //收藏
            case R.id.ll_shoucang:
                Intent intent1 = new Intent(getContext(), MineCollectionActivity.class);
                intent1.putExtra("uid", userId);
                startActivity(intent1);
                break;
            //订单
            case R.id.ll_dingdan:
                Intent intent = new Intent(getContext(), OrderformActivity.class);
                intent.putExtra("userid", userId);
                startActivity(intent);
                break;
            //教师认证
            case R.id.ll_teacher:
                startActivity(new Intent(getContext(), TeacherActivity.class));

                break;
            //下载管理
            case R.id.ll_xiazai:

                break;
            //历史记录
            case R.id.ll_lishijvlu:
                startActivity(new Intent(getContext(), MineHistoryActivity.class));
                break;
            //设置
            case R.id.ll_shezhi:
                startActivity(new Intent(getContext(), MineSetActivity.class));
                break;
            //问题反馈
            case R.id.ll_wenti:
                startActivity(new Intent(getContext(), FeedbackActivity.class));
                break;

            //关注
            case R.id.rl_guanzhu:
                Intent attention = new Intent(getContext(), MineAttentionActivity.class);
                attention.putExtra("userid", userId);
                Log.e("TAG", "onViewClicked: " + userId);
                startActivity(attention);
                break;
            //粉丝
            case R.id.rl_fensi:
                Toast.makeText(getContext(), "跳转粉丝页面", Toast.LENGTH_SHORT).show();
                Intent fans = new Intent(getContext(), MineFansActivity.class);
                fans.putExtra("userid", userId);
                startActivity(fans);
                break;

            //动态
            case R.id.rl_dongtai:
                Intent dongtai = new Intent(getContext(), MyDynamicActivity.class);
                startActivity(dongtai);
                break;
            case R.id.mine_balance:
                Intent moneyIntent = new Intent(getContext(), MoneyChongActivity.class);
                startActivity(moneyIntent);
                break;
        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

        //用户信息
        mPresenter.getData(ApiConfig.GETMYINFO_CODE);
        //banner数据
        mPresenter.getData(ApiConfig.MYMINEBANNER);
    }

    @Override
    public MineModel getModel() {
        return new MineModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.GETMYINFO_CODE:
                MineBean mineBean = (MineBean) t[0];
                data = mineBean.getData();
                //获取当前用户id
                userId = data.getUserId();
                Log.i("userIduserId",userId);
                SharedPrefrenceUtils.saveString(getContext(),"mineUserId","");
                if (data != null) {
                    Glide.with(getContext()).load(data.getHeadUrl()).into(icMineHead);//头像
                    userName.setText(data.getNickName());//用户名
                    tvShengwang.setText("声望值：" + data.getPrestige());//声望值
                    wubi.setText(data.getDanceMoney() + "");//舞币
                    numGuanzhu.setText("" + data.getFocusCount());//关注
                    int smallchange = data.getSmallchange();
                    int msmallchange = smallchange / 100;
                    mBalance.setText("" + msmallchange);
                    numFensi.setText(data.getFansCount() + "");//粉丝
                    numDongtai.setText(data.getVideoCount() + "");//动态
                }
                break;
            case ApiConfig.MYMINEBANNER:
                MyMineBannerBean myMineBannerBean= (MyMineBannerBean) t[0];
                //String imgUrl = myMineBannerBean.getData().get(0).getImgUrl();


                break;
        }
    }
}
