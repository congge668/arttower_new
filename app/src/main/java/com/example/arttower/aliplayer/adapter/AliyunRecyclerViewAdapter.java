package com.example.arttower.aliplayer.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.ApiConfig;
import com.example.arttower.R;
import com.example.arttower.activity.OtherpageActivity;
import com.example.arttower.bean.VideoInfo;
import com.example.arttower.fragment.HomePage.bean.HomeBean;
import com.example.arttower.fragment.HomePage.dialog.Share_popDialog;
import com.example.arttower.other.HomeCommentDialogEvent;
import com.example.arttower.utils.image.ImageLoaderImpl;
import com.example.arttower.utils.image.ImageLoaderOptions;
import com.example.arttower.utils.image.ImageLoaderRequestListener;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class AliyunRecyclerViewAdapter extends RecyclerView.Adapter<AliyunRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private Point mScreenPoint = new Point();
    private List<VideoInfo.DataBean.RowsBean> mVideoListBeanItems;
    private List<HomeBean.DataBean> mData;
    private static  String userid;
    private View inflate;
    private static AppCompatActivity Oncontext;

    public AliyunRecyclerViewAdapter(Context context) {
        this.mContext = context;
        this.Oncontext = (AppCompatActivity) context;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        mScreenPoint.x = displayMetrics.widthPixels;
        mScreenPoint.y = displayMetrics.heightPixels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflate = LayoutInflater.from(mContext).inflate(R.layout.item_layout_list_player_recyclerview, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HomeBean.DataBean dataBean = mData.get(position);
        String coverUrlPath;
        if (TextUtils.isEmpty(dataBean.getHeadUrl())) {
            coverUrlPath = dataBean.getImgUrl();
        } else {
            coverUrlPath = dataBean.getImgUrl();
        }
        ImageView mThumb = holder.getCoverView();


        //用户id
        userid = mData.get(position).getId();
        ImageView like = inflate.findViewById(R.id.img_love);
        if (dataBean.getIsPraise().equals("1")) {
            like.setColorFilter(mContext.getResources().getColor(R.color.cl_FF0041));
        } else {
            like.setColorFilter(mContext.getResources().getColor(R.color.white));
        }
        //  给首页视频绑定数据
        holder.mData.setText(mData.get(position).getVideoContent());
        holder.mName.setText(mData.get(position).getNickName());
        Glide.with(mContext).load(mData.get(position).getHeadUrl()).into(holder.mImgTouXiang);
        holder.num_share.setText(mData.get(position).getForwardNum());
        holder.num_love.setText(mData.get(position).getIsPraise());
        holder.num_pinglun.setText(mData.get(position).getCommentNum());


        if (mContext != null) {
            if (mContext instanceof Activity) {
                Activity activity = (Activity) mContext;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    if (!activity.isFinishing() || !activity.isDestroyed()) {
                        loadPicture(holder, coverUrlPath, mThumb);
                    }
                } else {
                    if (!activity.isFinishing()) {
                        loadPicture(holder, coverUrlPath, mThumb);
                    }
                }
            }
        }

        holder.pinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new HomeCommentDialogEvent(ApiConfig.home_comment_list,mData.get(position).getId(),mData.get(position).getUid(),mData.get(position).getVideoContent(),true));
            }
        });
    }

    private void loadPicture(final MyViewHolder holder, String coverPath, final ImageView iv) {
        new ImageLoaderImpl().loadImage(mContext, coverPath, new ImageLoaderOptions.Builder()
                .asBitmap()
                .placeholder(android.R.color.black)
                .thumbnail(0.1f)
                .build()
        ).listener(new ImageLoaderRequestListener<Bitmap>() {
            @Override
            public boolean onLoadFailed(String exception, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, boolean isFirstResource) {
                float aspectRatio = (float) resource.getWidth() / resource.getHeight();
                float screenRatio = mScreenPoint.x / (float) mScreenPoint.y;
                if (aspectRatio <= (9f / 16f + 0.01) && aspectRatio >= (9f / 16f - 0.01) //考虑到float值不精确的原因取一个范围值 视频比例 = 9/16
                        && (screenRatio < 9f / 16f - 0.01) //屏幕宽高比例小于9/16(长手机)
                ) {
                    float height = holder.getContainerView().getHeight();
                    float width = height * resource.getWidth() / resource.getHeight();
                    ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
                    layoutParams.width = (int) width;
                    layoutParams.height = (int) height;
                    iv.setLayoutParams(layoutParams);
                } else {
                    //获取屏幕宽度
                    float screenWith = mScreenPoint.x;
                    ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
                    //获取imageview的高度
                    float height = screenWith * resource.getHeight() / resource.getWidth();
                    layoutParams.width = (int) screenWith;
                    layoutParams.height = (int) height;
                    iv.setLayoutParams(layoutParams);
                }
                return false;
            }
        }).into(iv);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setData(List<HomeBean.DataBean> dataBeans) {
        this.mData = dataBeans;
    }


    public void addMoreData(List<HomeBean.DataBean> videoListBeanItems) {
        this.mData.addAll(videoListBeanItems);
        notifyItemRangeInserted(this.mData.size() - videoListBeanItems.size(), videoListBeanItems.size());
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView share;
        private ImageView pinglun;
        private ImageView mThumb;
        private ViewGroup mRootView;
        private ImageView mImgTouXiang;
        private TextView mName;
        private TextView mData;
        private FrameLayout mPlayerViewRoot;
        private final TextView num_share;
        private final TextView num_love;
        private final TextView num_pinglun;
        private final View like;

        public MyViewHolder(View itemView) {
            super(itemView);
            mThumb = itemView.findViewById(R.id.img_thumb);
            mPlayerViewRoot = itemView.findViewById(R.id.list_player_root);
            mRootView = itemView.findViewById(R.id.root_view);

            mImgTouXiang = itemView.findViewById(R.id.recom_head); //头像
            mName = itemView.findViewById(R.id.recom_name);        //名字
            mData = itemView.findViewById(R.id.recom_content);     //介绍
            num_pinglun = itemView.findViewById(R.id.num_pinglun);
            num_love = itemView.findViewById(R.id.num_love);
            num_share = itemView.findViewById(R.id.num_share);


            //喜欢
            like = itemView.findViewById(R.id.img_love);
            share = itemView.findViewById(R.id.img_share);         //分享
            pinglun = itemView.findViewById(R.id.img_pinglun);     //评论

            // todo 分享
            share.setOnClickListener(v -> {
                Share_popDialog sharePopDialog = new Share_popDialog();
                sharePopDialog.show(Oncontext.getSupportFragmentManager(), "share");
            });

            //todo 点击头像去他人主页
            mImgTouXiang.setOnClickListener(v -> {
                Intent intent = new Intent(Oncontext, OtherpageActivity.class);
                intent.putExtra("id", userid);
                Oncontext.startActivity(intent);
            });
        }

        public ImageView getCoverView() {
            return mThumb;
        }

        public ViewGroup getContainerView() {
            return mRootView;
        }
    }
}
