package com.example.arttower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.Frame.BaseRvViewHolder;
import com.example.arttower.R;
import com.example.arttower.bean.ParticularsBean;

import java.util.List;

import butterknife.BindView;

public class CompilationsAdapter extends BaseRvAdapter<ParticularsBean.DataBean.RowsBean, CompilationsAdapter.Holder> {
    public CompilationsAdapter(Context context, List<ParticularsBean.DataBean.RowsBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(CompilationsAdapter.Holder holder, ParticularsBean.DataBean.RowsBean data, int position) {

        Glide.with(context).load(data.getCoverImg()).into(holder.tm_image);
        //加载圆形头像
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(context).load(data.getCoverImg()).apply(requestOptions).into(holder.tx_image);
        holder.teachername.setText(data.getCourseTeacherName());
        holder.kc_name.setText(data.getCourseName());
    }

    @NonNull
    @Override
    public CompilationsAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.compilations_item, null, false);
        return new Holder(inflate);
    }

    public class Holder extends BaseRvViewHolder {
        @BindView(R.id.tm_image)
        ImageView tm_image;
        @BindView(R.id.kc_name)
        TextView kc_name;
        @BindView(R.id.xiangqing_couser_name)
        TextView teachername;
        @BindView(R.id.tx_image)
        ImageView tx_image;
        public Holder(View itemView) {
            super(itemView);
        }
    }
}
