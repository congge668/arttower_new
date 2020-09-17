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
import com.example.arttower.design.StarBar;
import com.example.arttower.fragment.LocalPage.bean.InlandTeacherBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class inlandAdapter extends BaseRvAdapter<InlandTeacherBean.DataBean, inlandAdapter.inlandViewholder> {

    public inlandAdapter(Context context, ArrayList<InlandTeacherBean.DataBean> datas) {

        super(context, datas);
    }



    @NonNull
    @Override
    public inlandViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rlv_local, parent,false);
        return new inlandViewholder(view);
    }

    @Override
    protected void onBindData(inlandViewholder holder, InlandTeacherBean.DataBean data, int position) {
        //图片
        Glide.with(context).load(data.getDiplomaImgUrl()).into(holder.TeacherImg);
        //Name
        holder.TeacherName.setText(data.getIdCardName());
        // College
        holder.TeacherAcademy.setText(data.getDiploma());
        //degree
        holder.TeacherDegree.setText(data.getDegree());
        //Data
        holder.TeacherIntroduce.setText(data.getRemark());
        //holder.mStart.setStarMark(Float.parseFloat(data.getScore()));
        holder.mStart.setStarMark(3.1f);
    }


    public class inlandViewholder extends BaseRvViewHolder {
        @BindView(R.id.img_teacher)
        ImageView TeacherImg;
        @BindView(R.id.teacher_name)
        TextView TeacherName;
        @BindView(R.id.teacher_academy)
        TextView TeacherAcademy;
        @BindView(R.id.teacher_degree)
        TextView TeacherDegree;
        @BindView(R.id.teacher_introduce)
        TextView TeacherIntroduce;

        @BindView(R.id.teacher_star)
        StarBar mStart;

        public inlandViewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }





}
