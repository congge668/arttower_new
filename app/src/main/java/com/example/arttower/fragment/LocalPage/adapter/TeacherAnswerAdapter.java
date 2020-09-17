package com.example.arttower.fragment.LocalPage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.Frame.BaseRvViewHolder;
import com.example.arttower.R;
import com.example.arttower.bean.TeacherAnswerBean;

import java.util.List;

import butterknife.BindView;

public class TeacherAnswerAdapter extends BaseRvAdapter<TeacherAnswerBean.DataBean, TeacherAnswerAdapter.userholder> {
    public TeacherAnswerAdapter(Context context, List<TeacherAnswerBean.DataBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(userholder holder, TeacherAnswerBean.DataBean data, int position) {
        holder.mUserName.setText(data.getYptCourseQuestionsDO().getUserName());
        holder.mUserContent.setText(data.getYptCourseQuestionsDO().getContent());
        Glide.with(context).load(data.getYptCourseQuestionsDO().getUserHeadUrl()).into(holder.mHeadimg);

        init( holder);
    }

    private void init(userholder holder) {
        holder.mTeacherRlv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false));
    }

    @NonNull
    @Override
    public userholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.answer_rlv_user, null);
        return new userholder(view);
    }

    public class userholder extends BaseRvViewHolder {
        @BindView(R.id.answer_teacger_rlv)
        RecyclerView mTeacherRlv;
        @BindView(R.id.answer_user_headimg)
        ImageView mHeadimg;
        @BindView(R.id.answer_user_content)
        TextView mUserContent;
        @BindView(R.id.answer_user_name)
        TextView mUserName;

        public userholder(View itemView) {
            super(itemView);
        }
    }
}
