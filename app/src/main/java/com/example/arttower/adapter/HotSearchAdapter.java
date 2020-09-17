package com.example.arttower.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.arttower.Frame.BaseRvAdapter;
import com.example.arttower.Frame.BaseRvViewHolder;
import com.example.arttower.R;
import com.example.arttower.bean.HotSearchBena;

import java.util.List;

import butterknife.BindView;

public class HotSearchAdapter extends BaseRvAdapter<HotSearchBena.DataBean, HotSearchAdapter.ViewHolder> {
    public HotSearchAdapter(Context context, List<HotSearchBena.DataBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(ViewHolder holder, HotSearchBena.DataBean data, int position) {
        holder.hot_desc.setText(data.getKeywords());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hotseacher_item, parent, false);
        return new ViewHolder(inflate);
    }

    public class ViewHolder extends BaseRvViewHolder {
        @BindView(R.id.hot_desc)
        TextView hot_desc;
        @BindView(R.id.hot_image)
        ImageView hot_image;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
