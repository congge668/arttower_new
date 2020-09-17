package com.example.arttower.fragment.LocalPage.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.Frame.BaseRvViewHolder;
import com.example.arttower.R;
import com.example.arttower.activity.BuyCourseActivity;
import com.example.arttower.fragment.LocalPage.bean.TeacherCouserBean;

import java.util.List;

import butterknife.BindView;

public class TeacherCouserAdapter extends BaseRvAdapter<TeacherCouserBean.DataBean, TeacherCouserAdapter.CouserHolder> {
    public TeacherCouserAdapter(Context context, List<TeacherCouserBean.DataBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(CouserHolder holder, TeacherCouserBean.DataBean data, int position) {
        Glide.with(context).load(data.getCoverImg()).into(holder.mHeadimg);
        holder.mAmount.setText(data.getAmount() + "人已报名");
        holder.mCourseName.setText(data.getCourseName());
        holder.mCourseTag.setText(data.getCourseTag());
        holder.mPrice.setText(data.getAmount() + "");
        holder.mUsername.setText(data.getCourseTeacherName());
        holder.mWuPrice.setText(data.getPrice()+"");
        holder.mAtonce_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = data.getId();
                Intent intent = new Intent(context, BuyCourseActivity.class);
                intent.putExtra("id",id);
                context.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public CouserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rlv_teacher_couser, null);
        return new CouserHolder(view);
    }

    public class CouserHolder extends BaseRvViewHolder {
        @BindView(R.id.rlv_teacher_couser_amount)
        TextView mAmount;
        @BindView(R.id.rlv_teacher_couser_courseName)
        TextView mCourseName;
        @BindView(R.id.rlv_teacher_couser_courseTag)
        TextView mCourseTag;
        @BindView(R.id.rlv_teacher_couser_headimg)
        ImageView mHeadimg;
        @BindView(R.id.rlv_teacher_couser_price)
        TextView mPrice;
        @BindView(R.id.rlv_teacher_couser_username)
        TextView mUsername;
        @BindView(R.id.atonce_apply)
        Button mAtonce_apply;

        @BindView(R.id.wu_price)
        TextView mWuPrice;


        public CouserHolder(View itemView) {
            super(itemView);
        }
    }
}
