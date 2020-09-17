//package com.example.arttower.fragment.HomePage.Recommend;
//
//import android.media.MediaPlayer;
//import android.net.Uri;
//import android.os.Build;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.VideoView;
//
//import androidx.annotation.RequiresApi;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.OrientationHelper;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.dingmouren.layoutmanagergroup.viewpager.OnViewPagerListener;
//import com.dingmouren.layoutmanagergroup.viewpager.ViewPagerLayoutManager;
//import com.example.arttower.Frame.ApiConfig;
//import com.example.arttower.Frame.BaseMvpFragment;
//import com.example.arttower.R;
//import com.example.arttower.model.HomeModel;
//
//import butterknife.BindView;
//
//import static com.umeng.socialize.utils.ContextUtil.getPackageName;
//
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class RecommendFragment extends BaseMvpFragment<HomeModel> {
//
//    @BindView(R.id.rlv_recommend)
//    RecyclerView rlvRecommend;
//
//    private String userId;
//    private int offset = 1;
//    private int rows = 5;
//
//    private ViewPagerLayoutManager mLayoutManager;
//    private MyAdapter1 mAdapter;
//    private String TAG = "yuyyyy";
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.fragment_recommend;
//    }
//
//    @Override
//    public void initView() {
////
//        mLayoutManager = new ViewPagerLayoutManager(getContext(), OrientationHelper.VERTICAL);
//        mAdapter = new MyAdapter1();
//        rlvRecommend.setLayoutManager(mLayoutManager);
//        rlvRecommend.setAdapter(mAdapter);
//        initListener();
//    }
//
//    private void initListener(){
//        mLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
//            @Override
//            public void onInitComplete() {
//
//            }
//
//            @Override
//            public void onPageRelease(boolean isNext,int position) {
//                Log.e(TAG,"释放位置:"+position +" 下一页:"+isNext);
//                int index = 0;
//                if (isNext){
//                    index = 0;
//                }else {
//                    index = 1;
//                }
//                releaseVideo(index);
//            }
//
//            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//            @Override
//            public void onPageSelected(int position,boolean isBottom) {
//                Log.e(TAG,"选中位置:"+position+"  是否是滑动到底部:"+isBottom);
//                playVideo(0);
//            }
//
//
//            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//            public void onLayoutComplete() {
//                playVideo(0);
//            }
//
//        });
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//    private void playVideo(int position) {
//        View itemView = rlvRecommend.getChildAt(0);
//        final VideoView videoView = itemView.findViewById(R.id.video_view);
//        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
//        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
//        final RelativeLayout rootView = itemView.findViewById(R.id.root_view);
//        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];
//        videoView.start();
//        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
//            @Override
//            public boolean onInfo(MediaPlayer mp, int what, int extra) {
//                mediaPlayer[0] = mp;
//                Log.e(TAG,"onInfo");
//                mp.setLooping(true);
//                imgThumb.animate().alpha(0).setDuration(200).start();
//                return false;
//            }
//        });
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                Log.e(TAG,"onPrepared");
//
//            }
//        });
//
//        videoView.setOnClickListener(new View.OnClickListener() {
//            boolean isPlaying = true;
//            @Override
//            public void onClick(View v) {
//                if (videoView.isPlaying()){
//                    Log.e(TAG,"isPlaying:"+videoView.isPlaying());
//                    imgPlay.animate().alpha(1f).start();
//                    videoView.pause();
//                    isPlaying = false;
//                }else {
//                    Log.e(TAG,"isPlaying:"+videoView.isPlaying());
//                    imgPlay.animate().alpha(0f).start();
//                    videoView.start();
//                    isPlaying = true;
//                }
//            }
//        });
//        imgPlay.setOnClickListener(new View.OnClickListener() {
//            boolean isPlaying = true;
//            @Override
//            public void onClick(View v) {
//                if (videoView.isPlaying()){
//                    Log.e(TAG,"isPlaying:"+videoView.isPlaying());
//                    imgPlay.animate().alpha(1f).start();
//                    videoView.pause();
//                    isPlaying = false;
//                }else {
//                    Log.e(TAG,"isPlaying:"+videoView.isPlaying());
//                    imgPlay.animate().alpha(0f).start();
//                    videoView.start();
//                    isPlaying = true;
//                }
//            }
//        });
//    }
//
//    private void releaseVideo(int index){
//        View itemView = rlvRecommend.getChildAt(index);
//        final VideoView videoView = itemView.findViewById(R.id.video_view);
//        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
//        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
//        videoView.stopPlayback();
//        imgThumb.animate().alpha(1).start();
//        imgPlay.animate().alpha(0f).start();
//    }
//
//
//    @Override
//    public void initData() {
////        mPresenter.getData(ApiConfig.VIDEO_DATA, userId, offset, rows);
//    }
//
//    @Override
//    public HomeModel getModel() {
//        return new HomeModel();
//    }
//
//    @Override
//    public void onError(int whichApi, Throwable e) {
//
//    }
//
//    @Override
//    public void onResponse(int whichApi, Object[] t) {
//        switch (whichApi) {
//            case ApiConfig.VIDEO_DATA:
////                VideoInfo videoInfo = (VideoInfo) t[0];
////                List<VideoInfo.DataBean.RowsBean> rowsBeans = videoInfo.getData().getRows();
////                rowsList.addAll(rowsBeans);
////                rlvAdapter.notifyDataSetChanged();
////                Log.i("饕餮", "onResponse: "+videoInfo.getData().toString());
//                break;
//        }
//    }
//    class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder>{
//        private int[] imgs = {R.mipmap.cover1,R.mipmap.cover2,R.mipmap.video13,R.mipmap.video14,R.mipmap.img_video_2};
//        private int[] videos = {R.raw.video1,R.raw.video2,R.raw.video13,R.raw.video14,R.raw.video_2};
//        public MyAdapter1(){
//        }
//
//
//        @Override
//        public MyAdapter1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommed_layout,parent,false);
//            return new MyAdapter1.ViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(MyAdapter1.ViewHolder holder, int position) {
//
//
//
//
//
//
//            holder.img_thumb.setImageResource(imgs[position%5]);
//
//
//
//            holder.videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+ videos[position%5]));
//        }
//
//        @Override
//        public int getItemCount() {
//            return 50;
//        }
//
//        public class ViewHolder extends RecyclerView.ViewHolder{
//            ImageView img_thumb;
//            VideoView videoView;
//            ImageView img_play;
//            RelativeLayout rootView;
//            public ViewHolder(View itemView) {
//                super(itemView);
//                img_thumb = itemView.findViewById(R.id.img_thumb);
//                videoView = itemView.findViewById(R.id.video_view);
//                img_play = itemView.findViewById(R.id.img_play);
//                rootView = itemView.findViewById(R.id.root_view);
//            }
//        }
//    }
//}
