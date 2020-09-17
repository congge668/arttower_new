package com.example.arttower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.Frame.BaseRvViewHolder;
import com.example.arttower.R;
import com.example.arttower.bean.ToUpWuBiBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WuBiAdapter extends BaseRvAdapter<ToUpWuBiBean.DataBean.MoneyListBean, WuBiAdapter.rlvholder> {


    public WuBiAdapter(Context context, List<ToUpWuBiBean.DataBean.MoneyListBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(rlvholder holder, ToUpWuBiBean.DataBean.MoneyListBean data, int position) {
        if (data.isSelect()){
            holder.moneyOnehundred.setBackground(context.getResources().getDrawable(R.drawable.shape_submit));
        } else {
            holder.moneyOnehundred.setBackground(context.getResources().getDrawable(R.drawable.shape_collection));
        }
        holder.shiRmb.setText(data.getMoney()+"");
        holder.yibaiWu.setText(data.getDanceCoin());
    }

    @NonNull
    @Override
    public rlvholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chongzhiwubi_rlv, null);
        return new rlvholder(inflate);
    }

    public class rlvholder extends BaseRvViewHolder {
        @BindView(R.id.yibai_wu)
        TextView yibaiWu;
        @BindView(R.id.shi_rmb)
        TextView shiRmb;
        @BindView(R.id.money_onehundred)
        LinearLayout moneyOnehundred;
        public rlvholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
