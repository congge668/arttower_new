package com.example.arttower.fragment.HomePage.Recommend;

import android.app.Dialog;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;

import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.Frame.BaseMvpFragment;
import com.example.arttower.R;
import com.example.arttower.adapter.HomeCommentAdapter;
import com.example.arttower.aliplayer.view.AliyunListPlayerView;
import com.example.arttower.eventbus.EventBusUtils;
import com.example.arttower.fragment.HomePage.bean.HomeBean;
import com.example.arttower.local_utils.SharedPrefrenceUtils;
import com.example.arttower.model.HomeModel;
import com.example.arttower.other.DialogUtils;
import com.example.arttower.other.HomeAddCommentBean;
import com.example.arttower.other.HomeCommentDialogEvent;
import com.example.arttower.other.HomeCommentListBean;
import com.example.arttower.utils.NetWatchdog;
import com.example.arttower.utils.PauseVideoEvent;
import com.example.arttower.utils.ToastUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.UUID;

import butterknife.BindView;

public class VideoListFragment extends BaseMvpFragment<HomeModel> {

    @BindView(R.id.list_player_view)
    AliyunListPlayerView mListPlayerView;
    @BindView(R.id.iv_back)
    ImageView mBackImageView;

    private NetWatchdog mNetWatchDog;
    private boolean mIsLoadMore = false;

    private int offset = 1;
    private int rows = 10;
    // 总共有几页
    private int total = 0;

    private HomeCommentDialogEvent homeCommentDialogEvent;
    private HomeCommentAdapter homeCommentAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_videolist;
    }
    @Override
    public void initView() {
        initListener();
    }

    @Override
    public void initData() {
        EventBusUtils.register(this);
        mPresenter.getData(ApiConfig.VIDEO_DATA, offset, rows);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHomeCommentDialogEvent(HomeCommentDialogEvent event){
        switch (event.getApiConfig()){
            case ApiConfig.home_comment_list:
                homeCommentDialogEvent = event;
                if (event.isClickPinglu()){
                    homeCommentAdapter = null;
                }
                mPresenter.getData(ApiConfig.home_comment_list,offset,rows, "51fde5a3def8754d1d7a2716862293f0",event.getId(),
                        event.getUid(),event.getVideoContent());
                break;
            case ApiConfig.add_home_comment:
                mPresenter.getData(ApiConfig.add_home_comment,offset,rows, "51fde5a3def8754d1d7a2716862293f0",event.getId(),
                        event.getUid(),event.getVideoContent());
                break;
        }


    }

    private void refreshListDatas() {
        offset = 1;
        getDatas(offset);

    }

    private void getDatas(int offset) {
        mPresenter.getData(ApiConfig.VIDEO_DATA, offset, rows);
    }


    private void initListener() {
        mNetWatchDog = new NetWatchdog(getActivity());
        mNetWatchDog.setNetChangeListener(new MyNetChangeListener(this));
        mNetWatchDog.setNetConnectedListener(new MyNetConnectedListener(this));
        mListPlayerView.setOnRefreshDataListener(new MyOnRefreshListener(this));
        mBackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        switch (whichApi) {
            case ApiConfig.VIDEO_DATA:
                Log.e("首页视频", "onError: ");
                break;
        }
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.VIDEO_DATA:
                HomeBean homeBean = (HomeBean) t[0];
                List<HomeBean.DataBean> data = homeBean.getData();
                SparseArray<String> mSparseArray;
                if (mListPlayerView != null && data != null) {
                    if (!mIsLoadMore) {
                        mSparseArray = new SparseArray<>();
                        mListPlayerView.setData(data);
                    } else {
                        mSparseArray = mListPlayerView.getCorrelationTable();
                        mListPlayerView.addMoreData(data);
                    }
                    //遍历资源,添加到列表播放器当中
                    int size = mSparseArray.size();
                    for (int i = 0; i < data.size(); i++) {

                        String randomUUID = UUID.randomUUID().toString();
                        mListPlayerView.addUrl(data.get(i).getVideoUrl().get(0).getVideoUrl(), randomUUID);
                        Log.e("首页视频", "onResponse: " + data.get(i).getVideoUrl().get(0).getVideoUrl());
                        mSparseArray.put(size + i, randomUUID);
                    }
                    mListPlayerView.setCorrelationTable(mSparseArray);
                }

                if (mListPlayerView != null) {
                    mListPlayerView.hideRefresh();
                }

                break;
            case ApiConfig.home_comment_list:
                HomeCommentListBean homeCommentListBean = (HomeCommentListBean)t[0];
                if (homeCommentListBean.getData() != null){
                    Log.i("home_comment_list",homeCommentListBean.getData().getTotal()+"");
                    if (homeCommentAdapter == null){
                        homeCommentAdapter = DialogUtils.homeCommentDialog(getContext(),homeCommentListBean.getData().getRows(),homeCommentDialogEvent);
                    } else {
                        homeCommentAdapter.setNewDatas(homeCommentListBean.getData().getRows());
                    }
                }

                break;
            case ApiConfig.add_home_comment:
                HomeAddCommentBean homeAddCommentBean = (HomeAddCommentBean)t[0];
                if (homeAddCommentBean != null && homeAddCommentBean.getData() != null && homeAddCommentBean.getData().getResult().equals("1") && homeCommentAdapter != null){

                    mPresenter.getData(ApiConfig.home_comment_list,offset,rows, "51fde5a3def8754d1d7a2716862293f0",homeCommentDialogEvent.getId(),
                            homeCommentDialogEvent.getUid(),homeCommentDialogEvent.getVideoContent());
                }
                break;
        }
    }

    @Subscribe
    public void getEventBus(PauseVideoEvent event) {
        if (event != null) {
            if (event.isPlayOrPause()) {
                mListPlayerView.setOnBackground(false);
            } else {
                mListPlayerView.setOnBackground(true);
            }
        }
    }



    @Override
    public void onStart() {
        super.onStart();
        if (mListPlayerView != null) {
            mListPlayerView.setOnBackground(false);
        }
        if (mNetWatchDog != null) {
            mNetWatchDog.startWatch();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mListPlayerView != null) {
            mListPlayerView.setOnBackground(true);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mListPlayerView != null) {
            mListPlayerView.setOnBackground(true);
        }
        if (mNetWatchDog != null) {
            mNetWatchDog.stopWatch();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mListPlayerView != null) {
            mListPlayerView.destroy();
        }
    }

    /**
     * 刷新数据监听
     */
    private static class MyOnRefreshListener implements AliyunListPlayerView.OnRefreshDataListener {

        private WeakReference<VideoListFragment> weakReference;

        public MyOnRefreshListener(VideoListFragment videoListFragment) {
            weakReference = new WeakReference<>(videoListFragment);
        }

        @Override
        public void onRefresh() {
            VideoListFragment videoListFragment = weakReference.get();
            if (videoListFragment != null) {
                videoListFragment.onRefresh();
            }
        }

        @Override
        public void onLoadMore() {
            VideoListFragment videoListFragment = weakReference.get();
            if (videoListFragment != null) {
                videoListFragment.onLoadMore();
            }
        }
    }

    private void onRefresh() {
        mIsLoadMore = false;
        refreshListDatas();
    }

    private void onLoadMore() {
        mIsLoadMore = true;
        if (offset < total) {
            offset++;
        }
        getDatas(offset);
    }


    private static class MyNetChangeListener implements NetWatchdog.NetChangeListener {

        private WeakReference<VideoListFragment> weakReference;

        public MyNetChangeListener(VideoListFragment videoListFragment) {
            weakReference = new WeakReference<>(videoListFragment);
        }

        @Override
        public void onWifiTo4G() {
            VideoListFragment videoListFragment = weakReference.get();
            if (videoListFragment != null) {
                videoListFragment.onWifiTo4G();
            }
        }

        @Override
        public void on4GToWifi() {
            VideoListFragment videoListFragment = weakReference.get();
            if (videoListFragment != null) {
                videoListFragment.on4GToWifi();
            }
        }

        @Override
        public void onNetDisconnected() {
            VideoListFragment videoListFragment = weakReference.get();
            if (videoListFragment != null) {
                videoListFragment.onNetDisconnected();
            }
        }
    }

    private void onNetDisconnected() {
    }

    private void on4GToWifi() {
    }

    private void onWifiTo4G() {
        ToastUtils.show(getActivity(), getString(R.string.alivc_operator_play));
    }

    private static class MyNetConnectedListener implements NetWatchdog.NetConnectedListener {

        private final WeakReference<VideoListFragment> weakReference;

        public MyNetConnectedListener(VideoListFragment videoListFragment) {
            weakReference = new WeakReference<>(videoListFragment);
        }

        @Override
        public void onReNetConnected(boolean isReconnect) {
            VideoListFragment videoListFragment = weakReference.get();
            if (videoListFragment != null) {
                videoListFragment.onReNetConnected(isReconnect);
            }

        }

        @Override
        public void onNetUnConnected() {
            VideoListFragment videoListFragment = weakReference.get();
            if (videoListFragment != null) {
                videoListFragment.onNetUnConnected();
            }

        }
    }

    //无网络
    private void onNetUnConnected() {
        ToastUtils.show(getActivity(), getString(R.string.alivc_player_net_unconnect));
    }

    private void onReNetConnected(boolean isReconnect) {
    }
}
