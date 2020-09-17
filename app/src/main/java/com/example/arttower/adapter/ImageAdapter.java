package com.example.arttower.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.arttower.fragment.LocalPage.bean.InlandBanner;
import com.example.arttower.viewholder.ImageHolder;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

/**
 * 自定义布局，图片
 */
public class ImageAdapter extends BannerAdapter<InlandBanner.DataBean, ImageHolder> {
    public ImageAdapter(Context context, List<InlandBanner.DataBean> datas) {

        super(datas);
    }


    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Log.e("lige", "create ImageHolder");
        return new ImageHolder(imageView);
    }

    /**
     * 绑定布局数据
     *
     * @param holder   XViewHolder
     * @param data     数据实体
     * @param position 当前位置
     * @param size     总数
     */
    @Override
    public void onBindView(ImageHolder holder, InlandBanner.DataBean data, int position, int size) {
        Log.e("lige", "width = " + holder.imageView.getWidth() + "  height = " + holder.imageView.getHeight());

       // holder.imageView.setImageResource(data.getImgUrl());
    }



/*
    public ImageAdapter(List<DataBean> mDatas) {
        //设置数据，也可以调用banner提供的方法,或者自己在adapter中实现
        super(mDatas);
    }

    //更新数据
    public void updateData(List<DataBean> data) {
        if (mDatas != null) {
            //这里的代码自己发挥，比如如下的写法等等
            Log.e("lige","添加数据");
            mDatas.clear();
            mDatas.addAll(data);
            notifyDataSetChanged();
        }
    }


    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Log.e("lige", "create ImageHolder");
        return new ImageHolder(imageView);
    }

    @Override
    public void onBindView(ImageHolder holder, DataBean data, int position, int size) {
        Log.e("lige", "width = " + holder.imageView.getWidth() + "  height = " + holder.imageView.getHeight());
        holder.imageView.setImageResource(data.imageRes);
    }
*/

}
