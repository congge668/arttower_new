package com.example.arttower.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.arttower.R;
import com.example.arttower.activity.OrderformActivity;
import com.example.arttower.bean.DataBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
* 我的订单
* */
public class OrderformAdapter extends RecyclerView.Adapter<OrderformAdapter.ViewHolder> {
    private final OrderformActivity orderformActivity;
    private final List<DataBean> list;

    public OrderformAdapter(OrderformActivity orderformActivity, List<DataBean> list) {
        this.orderformActivity = orderformActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderformAdapter.ViewHolder(LayoutInflater.from(orderformActivity).inflate(R.layout.item_order, null));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderformAdapter.ViewHolder holder, int position) {
        RequestOptions options = new RequestOptions().bitmapTransform(new RoundedCorners(8));
        Glide.with(orderformActivity).load(R.drawable.touxiang).apply(options).into(holder.orderImg);
        holder.orderOdd.setText("订单号：1654151351");
        holder.orderState.setText("交易成功");
        holder.orderName.setText("基础芭蕾-七天体验课");
        holder.orderPrice.setText("￥99");
        holder.orderDiscount.setText("￥199");
        holder.orderDate.setText("2020/07/02");
        holder.orderpay.setText("￥990");
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.order_odd)
        TextView orderOdd;
        @BindView(R.id.order_state)
        TextView orderState;
        @BindView(R.id.order_img)
        ImageView orderImg;
        @BindView(R.id.order_name)
        TextView orderName;
        @BindView(R.id.order_price)
        TextView orderPrice;
        @BindView(R.id.order_discount)
        TextView orderDiscount;
        @BindView(R.id.order_date)
        TextView orderDate;
        @BindView(R.id.order_pay)
        TextView orderpay;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(orderformActivity,itemView);
        }
    }
}
