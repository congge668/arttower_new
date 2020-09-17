package com.example.arttower.fragment.HomePage.homeclass;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.model.SeekModel;

import butterknife.BindView;

/*
 * 搜索课程
 * */
public class ThreeTestFragment extends BaseMvpFragment<SeekModel> {
    @BindView(R.id.three_test_rlv)
    RecyclerView mTestRlv;
    @BindView(R.id.kong_img)
    ImageView mKongImg;
    @BindView(R.id.kong_text)
    TextView mKongText;
    private String text;
    private String keyword;

    @Override
    public int getLayoutId() {
        return R.layout.threetestfragment;
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        keyword = bundle.getString("keyword");
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        mTestRlv.setLayoutManager(manager);

    }

    @Override
    public void initData() {
       mPresenter.getData(ApiConfig.TESTMOHUSOUSUO, keyword);
    }

    @Override
    public SeekModel getModel() {
        return new SeekModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.TESTMOHUSOUSUO:
                Log.e("搜索课程", "onError: "+e.getMessage() );
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TESTMOHUSOUSUO:
            /*    TestDimSeekInfo testDimSeekInfo= (TestDimSeekInfo) t[0];
                if (testDimSeekInfo.getData().getRows().isEmpty()){
                    break;
                }
               *//* if (testDimSeekInfo.getData().getRows()==null){
                    mKongImg.setImageResource(R.mipmap.icon_kong);
                    mKongText.setText("暂无搜索结果，试试其他关键词吧~");
                }*//*
                List<TestDimSeekInfo.DataBean.RowsBean> rows = testDimSeekInfo.getData().getRows();
                TestDimSeekAdapter adapter = new TestDimSeekAdapter(getContext(), rows);
                mTestRlv.setAdapter(adapter);*/
                break;
        }
    }
}
