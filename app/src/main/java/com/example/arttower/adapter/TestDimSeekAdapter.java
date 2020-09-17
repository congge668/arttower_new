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
import com.example.arttower.bean.TestDimSeekInfo;

import java.util.List;

import butterknife.BindView;

public class TestDimSeekAdapter extends BaseRvAdapter<TestDimSeekInfo.DataBean.RowsBean, TestDimSeekAdapter.testholder> {
    public TestDimSeekAdapter(Context context, List<TestDimSeekInfo.DataBean.RowsBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(testholder holder, TestDimSeekInfo.DataBean.RowsBean data, int position) {
        holder.mName.setText(data.getCourseName());
        Glide.with(context).load(data.getCoverImg()).into(holder.mHeadImg);

    }

    @NonNull
    @Override
    public testholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.three_test_rlv, null);

        return new testholder(inflate);
    }

    public class testholder extends BaseRvViewHolder {
        @BindView(R.id.three_test_headimg)
        ImageView mHeadImg;

        @BindView(R.id.three_test_name)
        TextView mName;

        public testholder(View itemView) {
            super(itemView);
        }
    }
}
