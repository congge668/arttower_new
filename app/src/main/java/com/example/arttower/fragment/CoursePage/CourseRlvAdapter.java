package com.example.arttower.fragment.CoursePage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.arttower.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CourseRlvAdapter extends RecyclerView.Adapter<CourseRlvAdapter.ViewHolder> {

    private Context mContext;
    private List<CourseDataBean.DataBean> mCourseList;

    public CourseRlvAdapter(Context mContext, List<CourseDataBean.DataBean> courseList) {
        this.mContext = mContext;
        mCourseList = courseList != null ? courseList : new ArrayList<CourseDataBean.DataBean>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.rlv_item_course, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RequestOptions options = new RequestOptions().bitmapTransform(new RoundedCorners(8));
        Glide.with(mContext).load(mCourseList.get(position).getCoverImg()).apply(options).into(holder.imgCourse);
        holder.courseName.setText(mCourseList.get(position).getCourseName());
        holder.courseStudynum.setText(mCourseList.get(position).getStudyNum()+"");
    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_course)
        ImageView imgCourse;
        @BindView(R.id.course_name)
        TextView courseName;
        @BindView(R.id.course_studynum)
        TextView courseStudynum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
