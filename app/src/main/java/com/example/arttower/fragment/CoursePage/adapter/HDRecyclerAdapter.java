package com.example.arttower.fragment.CoursePage.adapter;

import android.content.Context;
import android.util.Log;
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
import com.example.arttower.bean.HuoDongBean;

import java.util.List;

import butterknife.BindView;

public class HDRecyclerAdapter extends BaseRvAdapter<HuoDongBean.DataBean, HDRecyclerAdapter.hdholder> {
    private LayoutInflater mInflate;
    private Context mContext;
    public HDRecyclerAdapter(Context context, List<HuoDongBean.DataBean> datas) {
        super(context, datas);
        mInflate= LayoutInflater.from(context);
        this.mContext=context;
    }

    @Override
    protected void onBindData(hdholder holder, HuoDongBean.DataBean data, int position) {
        Log.e("TAG",data.getCoverImg()+"====================");
        Glide.with(mContext).load(data.getCoverImg()).into(holder.img);
        holder.name.setText(data.getCourseName());
        holder.but.setText(data.getCreateTime1());
    }

    @NonNull
    @Override
    public hdholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflate .inflate(R.layout.item_huodong, null,false);
        return new hdholder(view);
    }


    public class hdholder extends BaseRvViewHolder {
        @BindView(R.id.but)
        Button but;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.img111)
        ImageView img;
        public hdholder(View itemView) {
            super(itemView);
        }
    }
}
