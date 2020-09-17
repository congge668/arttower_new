package com.example.arttower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.Frame.BaseRvViewHolder;
import com.example.arttower.R;
import com.example.arttower.fragment.HomePage.bean.CommentBean;

import java.util.List;

import butterknife.BindView;

/**
 * description
 */
public class CommentAdapter extends BaseRvAdapter<CommentBean.DataBean.RowsBean, CommentAdapter.CommentViewHolder> {

    public CommentAdapter(Context context, List<CommentBean.DataBean.RowsBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(CommentViewHolder holder, CommentBean.DataBean.RowsBean data, int position) {
        //评论加载数据
        Glide.with(context).load(data.getHeadUrl()).into(holder.mComment_item_image);
        holder.mItem_rlv_name.setText(data.getNickName());
        holder.mItem_rlv_data.setText(data.getMessage());
        holder.mItem_rlv_num.setText(data.getReplyNum());

    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rlv_comment, parent, false);
        return new CommentViewHolder(view);
    }

    public class CommentViewHolder extends BaseRvViewHolder {
        @BindView(R.id.comment_item_image)
        ImageView mComment_item_image;
        @BindView(R.id.item_rlv_name)
        TextView mItem_rlv_name;
        @BindView(R.id.item_rlv_num)
        TextView mItem_rlv_num;
        @BindView(R.id.item_rlv_data)
        TextView mItem_rlv_data;
        @BindView(R.id.item_rlv_huifu)
        RecyclerView mItem_rlv_huifu;
        @BindView(R.id.item_rlv_comment_dianzan)
        ImageView mItem_comment_DianZan;

        public CommentViewHolder(View itemView) {
            super(itemView);
        }
    }
}
