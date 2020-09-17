package com.example.arttower.fragment.TestPage.ItemConvert;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public SparseArray<View> mViews;//存储ListItem的view
    public View mConvertView;//ListItem
    public RecyclerViewHolder(@NonNull View itemView, ViewGroup parent, Context context) {
        super(itemView);
        mConvertView = itemView;
        mViews = new SparseArray<View>();
    }

    //获取实例
    public static RecyclerViewHolder get(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(itemView, parent,context);
        return holder;
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }
}
