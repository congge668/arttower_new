package com.example.arttower.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.activity.MineHistoryActivity;
import com.example.arttower.bean.DataBean;

import java.util.List;

public class MineHistoryAdapter extends RecyclerView.Adapter {
    public MineHistoryAdapter(MineHistoryActivity mineHistoryActivity, List<DataBean> testData) {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
