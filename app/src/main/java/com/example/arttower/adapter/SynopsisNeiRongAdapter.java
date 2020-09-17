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
import com.example.arttower.bean.CouserDetailsBean;

import java.util.List;

import butterknife.BindView;

public class SynopsisNeiRongAdapter extends BaseRvAdapter<CouserDetailsBean.DataBean.YptCourseVideoDOListBean, SynopsisNeiRongAdapter.NeirongHolder> {
    public SynopsisNeiRongAdapter(Context context, List<CouserDetailsBean.DataBean.YptCourseVideoDOListBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(NeirongHolder holder, CouserDetailsBean.DataBean.YptCourseVideoDOListBean data, int position) {
        holder.mName.setText(data.getVideoName());
        holder.mTime.setText(data.getVideoTime());
        Glide.with(context).load(data.getCoverImg()).into(holder.mRlvImg);
    }

    @NonNull
    @Override
    public NeirongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.synopsis_neirong, null);
        return new NeirongHolder(view);
    }

    public class NeirongHolder extends BaseRvViewHolder {
        @BindView(R.id.synopsis_neirong_rlv_img)
        ImageView mRlvImg;
        @BindView(R.id.synopsis_neirong_rlv_name)
        TextView mName;
        @BindView(R.id.synopsis_neirong_rlv_time)
        TextView mTime;

        public NeirongHolder(View itemView) {
            super(itemView);
        }
    }
}
