package com.wenliu.coffeeordersystem.orderlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wenliu.coffeeordersystem.Constants;
import com.wenliu.coffeeordersystem.R;
import com.wenliu.coffeeordersystem.object.CoffeeOrder;
import com.wenliu.coffeeordersystem.object.CoffeeType;

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

    }

    @Override
    public int getItemCount() {
        return 5;
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

        //endregion

        public OrderListViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
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
        Log.d(Constants.TAG_MAIN_COFFEE_ORDER_ADAPTER, "updateData, data count= " + coffeeOrders.size());
        mCoffeeOrders = new ArrayList<>(coffeeOrders);
        Collections.reverse(mCoffeeOrders);
        notifyDataSetChanged();
    }

}
