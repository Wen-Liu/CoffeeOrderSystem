package com.wenliu.coffeeordersystem.orderlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wenliu.coffeeordersystem.Constants;
import com.wenliu.coffeeordersystem.R;
import com.wenliu.coffeeordersystem.Utils;
import com.wenliu.coffeeordersystem.object.CoffeeOrder;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private OrderListContract.Presenter mPresenter;
    private ArrayList<CoffeeOrder> mCoffeeOrders;

    public OrderListAdapter(Context context, OrderListContract.Presenter presenter, ArrayList<CoffeeOrder> coffeeOrders) {
        mContext = context;
        mPresenter = presenter;
        mCoffeeOrders = coffeeOrders;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_list_linear, parent, false);
        return new OrderListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(position%2==0){
            ((OrderListViewHolder)holder).getConsLayoutOrderList().setBackgroundColor(mContext.getColor(R.color.Grey_200));
            ((OrderListViewHolder)holder).getTvOrderStatus().setBackgroundColor(mContext.getColor(R.color.Grey_50));
        } else {
            ((OrderListViewHolder)holder).getTvOrderStatus().setBackgroundColor(mContext.getColor(R.color.Grey_200));
        }


        ((OrderListViewHolder)holder).getTvOrderNumber().setText(mCoffeeOrders.get(position).getOrderNumber());
        ((OrderListViewHolder)holder).getTvOrderTime().setText(Utils.getCreatedTime(mCoffeeOrders.get(position).getTime()));
        ((OrderListViewHolder)holder).getTvOrderAccount().setText(mCoffeeOrders.get(position).getAccount());
        ((OrderListViewHolder)holder).getTvOrderItems().setText(String.valueOf(mCoffeeOrders.get(position).getItemCount()));
        ((OrderListViewHolder)holder).getTvTotalPrice().setText(String.valueOf(mCoffeeOrders.get(position).getPrice())+ " TWD");

        setOrderStatusView(mCoffeeOrders.get(position).getStatus(), holder);
    }

    private void setOrderStatusView(int orderStatus, RecyclerView.ViewHolder holder) {
        String statusString = "";
        int statusTextColor = 0;

        switch (orderStatus) {
            case Constants.STATUS_PROCESS:
                statusString = mContext.getString(R.string.order_status_process);
                statusTextColor = R.color.Blue_600;
                break;
            case Constants.STATUS_COMPLETE:
                statusString = mContext.getString(R.string.order_status_complete);
                statusTextColor = R.color.Green_600;
                break;
            case Constants.STATUS_CANCEL:
                statusString = mContext.getString(R.string.order_status_cancel);
                statusTextColor = R.color.Red_600;
                break;
        }
        ((OrderListViewHolder) holder).getTvOrderStatus().setText(statusString);
        ((OrderListViewHolder) holder).getTvOrderStatus().setTextColor(mContext.getColor(statusTextColor));
    }

    @Override
    public int getItemCount() {
        return mCoffeeOrders.size();
    }


    public class OrderListViewHolder extends RecyclerView.ViewHolder {
        //region "BindView"
        @BindView(R.id.tv_order_status)
        TextView mTvOrderStatus;
        @BindView(R.id.tv_order_number)
        TextView mTvOrderNumber;
        @BindView(R.id.tv_order_time)
        TextView mTvOrderTime;
        @BindView(R.id.tv_order_account)
        TextView mTvOrderAccount;
        @BindView(R.id.tv_order_items)
        TextView mTvOrderItems;
        @BindView(R.id.tv_total_price)
        TextView mTvTotalPrice;
        @BindView(R.id.consLayout_order_list)
        ConstraintLayout mConsLayoutOrderList;
        //endregion

        public OrderListViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public ConstraintLayout getConsLayoutOrderList() {
            return mConsLayoutOrderList;
        }

        public TextView getTvOrderStatus() {
            return mTvOrderStatus;
        }

        public TextView getTvOrderNumber() {
            return mTvOrderNumber;
        }

        public TextView getTvOrderTime() {
            return mTvOrderTime;
        }

        public TextView getTvOrderAccount() {
            return mTvOrderAccount;
        }

        public TextView getTvOrderItems() {
            return mTvOrderItems;
        }

        public TextView getTvTotalPrice() {
            return mTvTotalPrice;
        }
    }


    public void updateData(ArrayList<CoffeeOrder> coffeeOrders) {
        Log.d(Constants.TAG_ORDER_LIST_ADAPTER, "updateData, data count= " + coffeeOrders.size());
        mCoffeeOrders = new ArrayList<>(coffeeOrders);
        Collections.reverse(mCoffeeOrders);
        notifyDataSetChanged();
    }

}
