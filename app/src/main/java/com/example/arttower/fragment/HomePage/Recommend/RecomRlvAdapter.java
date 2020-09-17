package com.example.arttower.fragment.HomePage.Recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.arttower.R;
import com.example.arttower.bean.VideoInfo;
import com.example.arttower.design.RoundOrCircleImage;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecomRlvAdapter extends RecyclerView.Adapter<RecomRlvAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<VideoInfo.DataBean.RowsBean> mRowsList;

    public RecomRlvAdapter(Context mContext, ArrayList<VideoInfo.DataBean.RowsBean> rowsList) {
        this.mContext = mContext;
        mRowsList = rowsList != null ? rowsList : new ArrayList<VideoInfo.DataBean.RowsBean>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recommed_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
//        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
//        Glide.with(mContext).load(mRowsList.get(position).getHeadUrl()).into(holder.recomHead);
//        if (mRowsList.get(position).getIsPraise().equals("0")) {
//            Glide.with(mContext).load(R.mipmap.ic_dianzanqian).into(holder.imgLove);
//        } else {
//            Glide.with(mContext).load(R.mipmap.ic_dianzanhou).into(holder.imgLove);
//        }
//        holder.recomName.setText(mRowsList.get(position).getNickName());
//        Glide.with(mContext).load(mRowsList.get(position).getImgUrl()).into(holder.recomCover);
//        holder.recomContent.setText(mRowsList.get(position).getName());
//        holder.numShare.setText(mRowsList.get(position).getForwardNum());
//        holder.numPinglun.setText(mRowsList.get(position).getCommentNum());

    }

    @Override
    public int getItemCount() {
        return mRowsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recom_head)
        RoundOrCircleImage recomHead;
        @BindView(R.id.img_love)
        ImageView imgLove;
        @BindView(R.id.num_love)
        TextView numLove;
        @BindView(R.id.img_share)
        ImageView imgShare;
        @BindView(R.id.num_share)
        TextView numShare;
        @BindView(R.id.img_pinglun)
        ImageView imgPinglun;
        @BindView(R.id.num_pinglun)
        TextView numPinglun;
        @BindView(R.id.recom_name)
        TextView recomName;
        @BindView(R.id.recom_content)
        TextView recomContent;
//        @BindView(R.id.recom_cover)
//        ImageView recomCover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
