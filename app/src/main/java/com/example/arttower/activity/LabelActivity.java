package com.example.arttower.activity;


import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpActivity;
import com.example.arttower.R;
import com.example.arttower.adapter.QueryLabelAdapter;
import com.example.arttower.bean.HistroyLabelBean;
import com.example.arttower.bean.QueryLabelBean;
import com.example.arttower.model.QueryLabelModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/*
* 标签页面
* */
public class LabelActivity extends BaseMvpActivity<QueryLabelModel> {
    @BindView(R.id.label_fish)
    TextView mLabelfish;
    @BindView(R.id.label_history)
    RecyclerView mLabelhistory;
    @BindView(R.id.label_tuijian)
    RecyclerView mLabeltuijian;
    @BindView(R.id.label_img_sousuo)
    ImageView mLabel_img_sousuo;
    @BindView(R.id.label_ed_sousuo)
    EditText mLabel_ed_sousuo;
    private ArrayList<QueryLabelBean.DataBean> list;
    private QueryLabelAdapter queryLabelAdapter;
    private ArrayList<HistroyLabelBean.DataBean> dataBeans;
    private final int offset = 1;
    private final int rows = 10;

    @Override
    public int getLayoutId() {
        return R.layout.activity_label;
    }

    @Override
    public void initView() {
        /*
         * 推荐标签数据
         * */
        list = new ArrayList<>();
        mLabeltuijian.setLayoutManager(new LinearLayoutManager(this));
        queryLabelAdapter = new QueryLabelAdapter(this, list);
        mLabeltuijian.setAdapter(queryLabelAdapter);
        /*
         * 历史标签数据
         * */
        dataBeans = new ArrayList<>();
        mLabelhistory.setLayoutManager(new LinearLayoutManager(this));
        queryLabelAdapter = new QueryLabelAdapter(this, list);
        mLabelhistory.setAdapter(queryLabelAdapter);


    }

    @Override
    public void initData() {
        //推荐标签数据
        mPresenter.getData(ApiConfig.LABELQUERY);
        //历史标签数据
        mPresenter.getData(ApiConfig.LABELHITORY, offset, rows);
    }

    @OnClick({R.id.label_fish, R.id.label_ed_sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.label_fish:

                break;
            case R.id.label_ed_sousuo:
                int white = R.color.white;
                mLabel_img_sousuo.setColorFilter(white);
                break;
        }
    }

    @Override
    public QueryLabelModel getModel() {
        return new QueryLabelModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.LABELQUERY:

                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.LABELQUERY:
                QueryLabelBean queryLabelBean = (QueryLabelBean) t[0];
                List<QueryLabelBean.DataBean> data = queryLabelBean.getData();
                Log.e("推荐标签数据", "LabelActivity================onResponse:" + data.toString());
                list.addAll(data);
                queryLabelAdapter.notifyDataSetChanged();
                break;
            case ApiConfig.LABELHITORY:
                HistroyLabelBean histroyLabelBean = (HistroyLabelBean) t[0];
                List<HistroyLabelBean.DataBean> histroyLabelBeanData = histroyLabelBean.getData();
                dataBeans.addAll(histroyLabelBeanData);
                queryLabelAdapter.notifyDataSetChanged();
                break;
        }
    }
}