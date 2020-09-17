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
import com.example.arttower.bean.UserDimSeekBean;

import java.util.List;

import butterknife.BindView;

public class UserDimSeekAdapter extends BaseRvAdapter<UserDimSeekBean.DataBean.RowsBean, UserDimSeekAdapter.userholder> {
    public UserDimSeekAdapter(Context context, List<UserDimSeekBean.DataBean.RowsBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(userholder holder, UserDimSeekBean.DataBean.RowsBean data, int position) {
        holder.mName.setText(data.getNickName());
        holder.mCouent.setText(data.getContent());
        Glide.with(context).load(data.getHeadUrl()).into(holder.mHead);
    }

    @NonNull
    @Override
    public userholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_seek_rlv, null);
        return new userholder(view);
    }

    public class userholder extends BaseRvViewHolder {
        @BindView(R.id.two_user_name)
        TextView mName;
        @BindView(R.id.two_user_couent)
        TextView mCouent;
        @BindView(R.id.two_user_head)
        ImageView mHead;

        public userholder(View itemView) {
            super(itemView);
        }
    }
}
