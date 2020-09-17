package com.example.arttower.fragment.HomePage.homeclass;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.adapter.VideoRetrievalAdapter;
import com.example.arttower.bean.VideoRetrievalBean;
import com.example.arttower.model.SeekModel;

import java.util.List;

import butterknife.BindView;

/*
* 搜索视频
* */
public class OneVideoFragment extends BaseMvpFragment {
    @BindView(R.id.one_seel_rlv)
    RecyclerView mRlv;
    @BindView(R.id.kong_img)
    ImageView mKongImg;
    @BindView(R.id.kong_text)
    TextView mKongText;
    private String keyword;

    @Override
    public int getLayoutId() {
        return R.layout.one_video_fragment;
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        keyword = bundle.getString("keyword");
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        mRlv.setLayoutManager(manager);
    }


    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.VIDEOMOHUSOUSUO, keyword);
        Log.e("搜索的数据", "initData: "+keyword );
    }

    @Override
    public SeekModel getModel() {
        return new SeekModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.VIDEOMOHUSOUSUO:
                Toast.makeText(getContext(), "请求数据失败", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.VIDEOMOHUSOUSUO:
                VideoRetrievalBean videoRetrievalBean = (VideoRetrievalBean) t[0];
               // List<VideoRetrievalBean.DataBean.RowsBean> rows1 = videoRetrievalBean.getData().getRows();

                   // mKongImg.setImageResource(R.mipmap.icon_kong);
                    //mKongText.setText("暂无搜索结果，试试其他关键词吧~");
                List<VideoRetrievalBean.DataBean.RowsBean> rows = videoRetrievalBean.getData().getRows();
                VideoRetrievalAdapter adapter = new VideoRetrievalAdapter(getContext(), rows);
                mRlv.setAdapter(adapter);
                break;
        }
    }
}
