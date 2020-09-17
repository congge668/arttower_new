package com.example.arttower.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.CommonPresenter;
import com.example.arttower.Frame.ICommonModel;
import com.example.arttower.Frame.ICommonView;
import com.example.arttower.Frame.NetManager;
import com.example.arttower.R;
import com.example.arttower.adapter.CommentAdapter;
import com.example.arttower.fragment.HomePage.bean.CommentBean;
import com.example.arttower.fragment.HomePage.model.CommentpopModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * description 评论弹框
 */
public class CommentDialog extends BaseBottomSheetDialog implements ICommonView, ICommonModel<com.example.arttower.fragment.HomePage.model.CommentpopModel> {

    @BindView(R.id.rlv_pop)
    RecyclerView mRecyclerView;
    @BindView(R.id.poprlv_ed)
    EditText mPoprlv_ed;
    private CommentAdapter adapter;
    private View view;
    private final int offset = 1;
    private final int rows = 10;
    private com.example.arttower.fragment.HomePage.model.CommentpopModel CommentpopModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_comment_pop_adapter, container);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        CommonPresenter presenter = new CommonPresenter();

        presenter.getData(ApiConfig.HOMECOMMENT, offset,rows);
        // getData((ICommonView) view,ApiConfig.HOMECOMMENT,CommentpopModel);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected int getHeight() {
        return getResources().getDisplayMetrics().heightPixels - 600;
    }


    //model层
    public com.example.arttower.fragment.HomePage.model.CommentpopModel getModel() {
        return new CommentpopModel();
    }
    @Override
    public void onError(int whichApi, Throwable e){
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.HOMECOMMENT:
                CommentBean list = (CommentBean) t[0];
                List<CommentBean.DataBean.RowsBean> data = list.getData().getRows();
                adapter = new CommentAdapter(getContext(), data);
                mRecyclerView.setAdapter(adapter);
                break;
        }
    }

    @Override
    public void getData(ICommonView view, int whichApi, com.example.arttower.fragment.HomePage.model.CommentpopModel... t) {
        NetManager manager = NetManager.getNetManager();
        switch (whichApi){
            case ApiConfig.HOMECOMMENT:
                //manager.method(manager.getNetManager().getNetService().getCommentInfo(offset,rows,userId,videoId), view, whichApi);
                break;
        }
    }
}
