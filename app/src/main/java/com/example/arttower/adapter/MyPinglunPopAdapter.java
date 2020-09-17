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
import com.example.arttower.fragment.HomePage.bean.CommentBean;

import java.util.List;

import butterknife.BindView;


public class MyPinglunPopAdapter extends BaseRvAdapter<CommentBean.DataBean.RowsBean, MyPinglunPopAdapter.pinglunHolder> {

    public MyPinglunPopAdapter(Context context, List<CommentBean.DataBean.RowsBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(pinglunHolder holder, CommentBean.DataBean.RowsBean data, int position) {
        holder.mItemName.setText(data.getNickName());
        holder.mItemNum.setText(data.getReplyNum());
        holder.mItemRlvData.setText(data.getMessage());
        Glide.with(context).load(data.getHeadUrl()).into(holder.mItemCommentImage);
    }


    @NonNull
    @Override
    public pinglunHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rlv_comment, parent);

        return new pinglunHolder(view);
    }

    public class pinglunHolder extends BaseRvViewHolder {
        @BindView(R.id.item_rlv_comment_dianzan)
        ImageView mItemCommentDianzan;

        @BindView(R.id.item_rlv_data)
        TextView mItemRlvData;

        @BindView(R.id.item_rlv_name)
        TextView mItemName;

        @BindView(R.id.item_rlv_num)
        TextView mItemNum;
        @BindView(R.id.comment_item_image)
        ImageView mItemCommentImage;

        public pinglunHolder(View itemView) {
            super(itemView);
        }
    }
}
