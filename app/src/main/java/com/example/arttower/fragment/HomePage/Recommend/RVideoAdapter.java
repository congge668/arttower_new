package com.example.arttower.fragment.HomePage.Recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arttower.R;
import com.example.arttower.design.RoundOrCircleImage;
import com.example.arttower.falsedata.CurUserBean;
import com.example.arttower.falsedata.DataCreate;
import com.example.arttower.falsedata.VideoBean;
import com.example.arttower.view.FullScreenVideoView;

import java.util.ArrayList;

import butterknife.BindView;

import static com.umeng.socialize.utils.ContextUtil.getPackageName;

public class RVideoAdapter extends RecyclerView.Adapter<RVideoAdapter.ViewHolder> {
   private Context context;
   private ArrayList<VideoBean> list;

    public RVideoAdapter(Context context, ArrayList<VideoBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommed_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String bgVideoPath = "android.resource://" + getPackageName() + "/" + DataCreate.datas.get(position).getVideoRes();
        holder.videoView.setVideoPath(bgVideoPath);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.video_view)
        FullScreenVideoView videoView;
        @BindView(R.id.img_thumb)
        ImageView imgThumb;
        @BindView(R.id.recom_head)
        RoundOrCircleImage recomHead;
        @BindView(R.id.recom_name)
        TextView recomName;
        @BindView(R.id.recom_content)
        TextView recomContent;
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
