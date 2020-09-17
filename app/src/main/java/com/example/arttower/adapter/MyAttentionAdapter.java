package com.example.arttower.adapter;

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
import com.example.arttower.bean.MyAttentionBean;

import java.util.List;

import butterknife.BindView;

public class MyAttentionAdapter extends BaseRvAdapter<MyAttentionBean.DataBean, MyAttentionAdapter.Attentionholder> {

    public MyAttentionAdapter(Context context, List<MyAttentionBean.DataBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(Attentionholder holder, MyAttentionBean.DataBean data, int position) {
        Glide.with(context).load(data.getHeadUrl()).into(holder.mAttentionHead);
        holder.mAttentionName.setText(data.getNickName());
        Log.e("我的关注", "onBindData: "+data.getNickName() );
        holder.mAttenttionContent.setText(data.getContent());

    }


    @NonNull
    @Override
    public Attentionholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rlv_item_attention, null);
        Log.e("我的关注", "onCreateViewHolder: " );
        return new Attentionholder(inflate);
    }


    public class Attentionholder extends BaseRvViewHolder {
        @BindView(R.id.attention_head)
        ImageView mAttentionHead;
        @BindView(R.id.attention_name)
        TextView mAttentionName;
        @BindView(R.id.attention_content)
        TextView mAttenttionContent;
        public Attentionholder(View itemView) {
            super(itemView);
            Log.e("我的关注", "Attentionholder: " );


        }
    }
}
