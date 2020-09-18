package com.example.arttower.adapter;

import android.content.Context;
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
import com.example.arttower.other.HomeCommentListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeCommentAdapter extends BaseRvAdapter<HomeCommentListBean.DataBean.RowsBean, HomeCommentAdapter.VideoViewHolder> {




    public HomeCommentAdapter(Context context, List<HomeCommentListBean.DataBean.RowsBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(VideoViewHolder holder, HomeCommentListBean.DataBean.RowsBean data, int position) {
        Glide.with(context).load(data.getHeadUrl()).into(holder.ivHead);
        holder.tvUserName.setText(data.getNickName());
        holder.tvUserComment.setText(data.getMessage());

    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_comment, parent, false);
        return new VideoViewHolder(view);
    }

    public class VideoViewHolder extends BaseRvViewHolder {
        @BindView(R.id.iv_head)
        ImageView ivHead;
        @BindView(R.id.tv_user_name)
        TextView tvUserName;
        @BindView(R.id.tv_user_comment)
        TextView tvUserComment;

        public VideoViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    public void setNewDatas(List<HomeCommentListBean.DataBean.RowsBean> datas){
        this.mDatas = datas;
        notifyDataSetChanged();
    }
}
