package com.wenliu.coffeeordersystem.orderlist;

import android.util.Log;

import com.wenliu.coffeeordersystem.Constants;
import com.wenliu.coffeeordersystem.api.FirebaseApiHelper;
import com.wenliu.coffeeordersystem.api.GetOrderDataCallback;
import com.wenliu.coffeeordersystem.object.CoffeeOrder;

import java.util.ArrayList;

public class OrderListPresenter implements OrderListContract.Presenter {
    private OrderListContract.View mOrderListView;


    public OrderListPresenter(OrderListContract.View orderListView) {
        Log.d(Constants.TAG_ORDER_LIST_PRESENTER, "CoffeeOrderPresenter: ");
        mOrderListView = orderListView;
        mOrderListView.setPresenter(this);
    }

    @Override
    public void start() {
        loadOrderItems();
    }

    private void loadOrderItems() {
        Log.d(Constants.TAG_ORDER_LIST_PRESENTER, "loadOrderItems: ");

        FirebaseApiHelper.getInstance().getOrderList(new GetOrderDataCallback() {
            @Override
            public void onCompleted(ArrayList<CoffeeOrder> coffeeOrders) {
                mOrderListView.showCoffeeOrders(coffeeOrders);
            }

            @Override
            public void onError(String error) {

            }
        });

    }
}
