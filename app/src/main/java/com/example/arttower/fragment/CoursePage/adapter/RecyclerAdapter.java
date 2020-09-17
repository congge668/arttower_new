package com.example.arttower.fragment.CoursePage.adapter;

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
import com.example.arttower.bean.ClassBean;

import java.util.List;

import butterknife.BindView;

public class RecyclerAdapter extends BaseRvAdapter<ClassBean.DataBean.YptCourseDOListBean, RecyclerAdapter.ViewHolder> {
    public RecyclerAdapter(Context context, List<ClassBean.DataBean.YptCourseDOListBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(ViewHolder holder, ClassBean.DataBean.YptCourseDOListBean data, int position) {
        Glide.with(context).load(data.getCoverImg()).into(holder.imgCourse);
        holder.courseName.setText(data.getCourseName());
       // holder.courseStudynum.setText(data.getCreateUser());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.class_item, parent, false);
        return new ViewHolder(inflate);
    }

    public class ViewHolder extends BaseRvViewHolder {
        @BindView(R.id.img_course)
        ImageView imgCourse;
        @BindView(R.id.course_name)
        TextView courseName;
       /* @BindView(R.id.course_studynum)
        TextView courseStudynum;*/
        public ViewHolder(View itemView) {
            super(itemView);

        }
    }

}
