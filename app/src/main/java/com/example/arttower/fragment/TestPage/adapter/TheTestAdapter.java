package com.example.arttower.fragment.TestPage.adapter;

import android.content.Context;
import android.util.Log;
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
import com.example.arttower.fragment.TestPage.view.TestFragmentBean;

import java.util.List;

import butterknife.BindView;

public class TheTestAdapter extends BaseRvAdapter<TestFragmentBean.DataBean.GradeTagListBean.GradeLevelListBean, TheTestAdapter.TestHolder> {

    public TheTestAdapter(Context context, List<TestFragmentBean.DataBean.GradeTagListBean.GradeLevelListBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(TestHolder holder, TestFragmentBean.DataBean.GradeTagListBean.GradeLevelListBean data, int position) {
        Glide.with(context).load(data.getGradeLevelUrl()).into(holder.mImg);
        holder.mTX.setText(data.getGradeLevelName());
        Log.e("TAG", "onBindData: "+data.getGradeLevelName() );
    }





    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thetest_rlv, null);
        return new TestHolder(inflate);
    }

    public class TestHolder extends BaseRvViewHolder {
        @BindView(R.id.rlv_thetest_img)
        ImageView mImg;
        @BindView(R.id.rlv_thetest_tx)
        TextView mTX;

        public TestHolder(View itemView) {
            super(itemView);
        }
    }
}
