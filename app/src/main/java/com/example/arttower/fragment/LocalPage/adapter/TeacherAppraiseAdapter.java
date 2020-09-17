package com.example.arttower.fragment.LocalPage.adapter;

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
import com.example.arttower.bean.TeacherAppraiseBean;

import java.util.List;

import butterknife.BindView;

public class TeacherAppraiseAdapter extends BaseRvAdapter<TeacherAppraiseBean.DataBean, TeacherAppraiseAdapter.AppraiseHolder> {

    public TeacherAppraiseAdapter(Context context, List<TeacherAppraiseBean.DataBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(AppraiseHolder holder, TeacherAppraiseBean.DataBean data, int position) {
        Glide.with(context).load(data.getHeadUrl()).into(holder.mHeadimage);
        holder.mCount.setText(data.getContent());
        holder.mTime.setText(data.getDateTime());
        holder.mUserName.setText(data.getUserName());

    }

    @NonNull
    @Override
    public AppraiseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rlv_teacher_appraise, parent);

        return new AppraiseHolder(view);
    }

    public class AppraiseHolder extends BaseRvViewHolder {
        @BindView(R.id.item_appraise_headimg)
        ImageView mHeadimage;
        @BindView(R.id.item_appraise_username)
        TextView mUserName;
        @BindView(R.id.item_appraise_count)
        TextView mCount;
        @BindView(R.id.item_appraise_time)
        TextView mTime;
        public AppraiseHolder(View itemView) {
            super(itemView);
        }
    }
}
