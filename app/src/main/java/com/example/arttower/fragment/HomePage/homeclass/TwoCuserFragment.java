package com.example.arttower.fragment.HomePage.homeclass;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.model.SeekModel;

import butterknife.BindView;

/*
* 搜索用户
* */
public class TwoCuserFragment extends BaseMvpFragment<SeekModel> {
    @BindView(R.id.two_user_rlv)
    RecyclerView mRlv;
    @BindView(R.id.user_kong_img)
    ImageView mKongImg;
    @BindView(R.id.user_kong_text)
    TextView mKongText;
    private String keyword;

    @Override
    public int getLayoutId() {
        return R.layout.twocuserfragment;
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        keyword = bundle.getString("keyword");

        mRlv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.UCERMOHUSUOSUO,keyword);
    }

    @Override
    public SeekModel getModel() {
        return new SeekModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.UCERMOHUSUOSUO:
                Log.e("asndankdsakm", "onError: ");
                Toast.makeText(getContext(), "获取用户数据失败", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.UCERMOHUSUOSUO:
               /* UserDimSeekBean userDimSeekBean= (UserDimSeekBean) t[0];
                UserDimSeekBean.DataBean data = userDimSeekBean.getData();
                List<UserDimSeekBean.DataBean.RowsBean> rows = data.getRows();
                if (rows.isEmpty()){
                    break;
                }

             *//*   mKongImg.setImageResource(R.mipmap.icon_kong);
                    mKongText.setText("暂无搜索结果，试试其他关键词吧~");
*//*
                UserDimSeekAdapter userDimSeekAdapter = new UserDimSeekAdapter(getContext(), rows);
                mRlv.setAdapter(userDimSeekAdapter);*/
                break;
        }
    }
}
