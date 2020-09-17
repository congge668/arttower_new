package com.example.arttower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.Frame.BaseRvViewHolder;
import com.example.arttower.R;
import com.example.arttower.bean.OthersNewsBean;

import java.util.List;

public class OtherRenAdapter extends BaseRvAdapter<OthersNewsBean.DataBean, OtherRenAdapter.Holder> {

    public OtherRenAdapter(Context context, List<OthersNewsBean.DataBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(Holder holder, OthersNewsBean.DataBean data, int position) {

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.other_xinxi, parent);
        return new Holder(view);
    }

    public class Holder extends BaseRvViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }
    }
}
