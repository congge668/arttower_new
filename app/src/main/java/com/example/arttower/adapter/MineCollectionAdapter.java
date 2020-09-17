package com.example.arttower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.Frame.BaseRvViewHolder;
import com.example.arttower.R;
import com.example.arttower.bean.CollectBean;

import java.util.List;

import butterknife.BindView;

/*
 * 我的收藏adapter
 * */
public class MineCollectionAdapter extends BaseRvAdapter<CollectBean.DataBean, MineCollectionAdapter.cetionholder> {

    public MineCollectionAdapter(Context context, List<CollectBean.DataBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(cetionholder holder, CollectBean.DataBean data, int position) {
        Glide.with(context).load(data.getCoverImg()).into(holder.mCollection_img);
    }


    @NonNull
    @Override
    public cetionholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_collection, null);
        return new cetionholder(inflate);
    }

    public class cetionholder extends BaseRvViewHolder {
        @BindView(R.id.collection_img)
        ImageView mCollection_img;
        public cetionholder(View itemView) {
            super(itemView);
        }
    }
}
