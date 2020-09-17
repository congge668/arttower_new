package com.example.arttower.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.Frame.BaseRvViewHolder;
import com.example.arttower.R;
import com.example.arttower.bean.VideoRetrievalBean;

import java.util.List;

import butterknife.BindView;

public class VideoRetrievalAdapter extends BaseRvAdapter<VideoRetrievalBean.DataBean.RowsBean, VideoRetrievalAdapter.reholder> {


    public VideoRetrievalAdapter(Context context, List<VideoRetrievalBean.DataBean.RowsBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(reholder holder, VideoRetrievalBean.DataBean.RowsBean data, int position) {
        holder.mCount.setText(data.getName());
        Log.e("搜索视频", "onResponse: "+data.getName() );
        holder.mDianzanNum.setText(data.getPraiseCounts());
        Glide.with(context).load(data.getImgUrl()).into(holder.mImg);

    }

    @NonNull
    @Override
    public reholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.one_video_rlv, null);
        return new reholder(view);
    }

    public class reholder extends BaseRvViewHolder {
        @BindView(R.id.shipin_count)
        TextView mCount;
        @BindView(R.id.shipin_img)
        ImageView mImg;//封面

        @BindView(R.id.shipin_dianzna)
        ImageView mDianzan; //点赞

        @BindView(R.id.shipin_dianzan_num)
        TextView mDianzanNum;//点赞数量

        public reholder(View itemView) {
            super(itemView);
        }
    }
}
