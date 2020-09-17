package com.example.arttower.adapter;

import android.content.Context;
import android.util.Log;
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
import com.example.arttower.bean.CouserCommentBean;

import java.util.List;

import butterknife.BindView;

/*
* 试听课程 评价的适配器
* */
public class CouserCommentAdaptet extends BaseRvAdapter<CouserCommentBean.DataBean, CouserCommentAdaptet.commholder> {
    public CouserCommentAdaptet(Context context, List<CouserCommentBean.DataBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(commholder holder, CouserCommentBean.DataBean data, int position) {
        //评价的数据
        Glide.with(context).load(data.getHeadUrl()).into(holder.mHeadimage);
       // holder.mLikenum.setText(""+data.getReplyCount());
        holder.mCount.setText(data.getContent());
        holder.mName.setText(data.getNickName());
        Log.e("mName", "onBindData: "+data.getNickName() );
        //教师回复的数据
        //holder.mRlv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));


    }

    @NonNull
    @Override
    public commholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.couser_comment, null);
        return new commholder(view);
    }

    public class commholder extends BaseRvViewHolder {
        @BindView(R.id.couser_comment_count)//评价内容
                TextView mCount;
        @BindView(R.id.couser_comment_headimg)//头部图片
                ImageView mHeadimage;
        @BindView(R.id.couser_comment_name)//教师name
                TextView mName;
      /*  @BindView(R.id.couser_comment_zan)//赞的图片
        ImageView mZanImg;
        @BindView(R.id.couser_comment_zannum)//赞的数量
        TextView mLikenum;*/
        @BindView(R.id.couser_comment_rlv)//教师回复的rlv
              RecyclerView mRlv;

        public commholder(View itemView) {
            super(itemView);
        }
    }
}
