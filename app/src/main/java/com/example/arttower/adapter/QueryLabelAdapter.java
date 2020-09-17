package com.example.arttower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.Frame.BaseRvViewHolder;
import com.example.arttower.R;
import com.example.arttower.bean.QueryLabelBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QueryLabelAdapter extends BaseRvAdapter<QueryLabelBean.DataBean, QueryLabelAdapter.QueryLabelHolder> {
    public QueryLabelAdapter(Context context, List<QueryLabelBean.DataBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(QueryLabelHolder holder, QueryLabelBean.DataBean data, int position) {
        //标签id
        String id = data.getId();
        holder.mLabelQueryText.setText(data.getTagName());
        holder.mLabelnumdynamic.setText(data.getTagVideoNum()+"条动态");
    }

    @NonNull
    @Override
    public QueryLabelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_query_label, null);
        return new QueryLabelHolder(view);
    }

    public class QueryLabelHolder extends BaseRvViewHolder {
        @BindView(R.id.label_querytext)
        TextView mLabelQueryText;
        @BindView(R.id.label_num_dynamic)
        TextView mLabelnumdynamic;

        public QueryLabelHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
