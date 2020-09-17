package com.example.arttower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.Frame.BaseRvViewHolder;
import com.example.arttower.R;
import com.example.arttower.bean.TaGuanzhuBean;

import java.util.List;

import butterknife.BindView;

public class TaGuanzhuAdapter extends BaseRvAdapter<TaGuanzhuBean.DataBean, TaGuanzhuAdapter.Holder> {

    public TaGuanzhuAdapter(Context context, List<TaGuanzhuBean.DataBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(Holder holder, TaGuanzhuBean.DataBean data, int position) {
        Glide.with(context).load(data.getHeadUrl()).into(holder.mFensihead);
        holder.mFensiname.setText(data.getNickName());
        holder.mFensicontent.setText(data.getContent());

        int bitmap= R.drawable.noattention;
        int bitmap2= R.drawable.yesattention;
        if (data.getIsFocus().equals("1")) {
            holder.mIte_jiaguanzhu.setText("已关注");
            holder.mIte_jiahao.setImageResource(bitmap2);
        }else {
            holder.mIte_jiaguanzhu.setText("加关注");
            holder.mIte_jiahao.setImageResource(bitmap);
        }
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_replyme, null);
        return new Holder(view);
    }

    public class Holder extends BaseRvViewHolder {
        @BindView(R.id.replyme_head)
        ImageView mFensihead;
        @BindView(R.id.replyme_name)
        TextView mFensiname;
        @BindView(R.id.replyme_content)
        TextView mFensicontent;
        @BindView(R.id.replyme_revert)
        LinearLayout mFensirevert;
        @BindView(R.id.ite_jiaguanzhu)
        TextView mIte_jiaguanzhu;
        @BindView(R.id.ite_jiahao)
        ImageView mIte_jiahao;

        public Holder(View itemView) {
            super(itemView);
        }
    }
}
