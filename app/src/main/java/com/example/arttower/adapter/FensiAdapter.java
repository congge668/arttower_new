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
import com.example.arttower.bean.FenSiBean;

import java.util.List;

import butterknife.BindView;

public class FensiAdapter extends BaseRvAdapter<FenSiBean.DataBean.YptUserDOSBean, FensiAdapter.Holder> {

    private View view;

    public FensiAdapter(Context context, List<FenSiBean.DataBean.YptUserDOSBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(Holder holder, FenSiBean.DataBean.YptUserDOSBean data, int position) {
        Glide.with(context).load(data.getHeadUrl()).into(holder.mFensihead);
        holder.mFensiname.setText(data.getNickName());
        holder.mFensicontent.setText(data.getContent());
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_replyme, parent);


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

        public Holder(View itemView) {
            super(itemView);
        }
    }
}
