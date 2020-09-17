package com.example.arttower.fragment.MinePage.Inform;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.fragment.CoursePage.CourseRlvAdapter;
import com.example.arttower.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ReplyMeFragment extends BaseMvpFragment<HomeModel> {

    @BindView(R.id.rlv_replyme)
    RecyclerView rlvReplyme;
    private ReplyMeAdapter replyMeAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_reply_me;
    }

    @Override
    public void initView() {

        List<ReplyMeBean> list = new ArrayList<>();
        replyMeAdapter = new ReplyMeAdapter(getContext(), list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rlvReplyme.setLayoutManager(linearLayoutManager);
        rlvReplyme.setAdapter(replyMeAdapter);
    }

    @Override
    public void initData() {

    }

    @Override
    public HomeModel getModel() {
        return null;
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }
}
