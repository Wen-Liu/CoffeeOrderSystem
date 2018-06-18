package com.wenliu.coffeeordersystem.orderlist;

import android.util.Log;

import com.wenliu.coffeeordersystem.Constants;

public class OrderListPresenter implements OrderListContract.Presenter {
    private OrderListContract.View mOrderListView;


    public OrderListPresenter(OrderListContract.View orderListView) {
        Log.d(Constants.TAG_ORDER_LIST_PRESENTER, "CoffeeOrderPresenter: ");
        mOrderListView = orderListView;
        mOrderListView.setPresenter(this);
    }



    @Override
    public void start() {

    }
}
