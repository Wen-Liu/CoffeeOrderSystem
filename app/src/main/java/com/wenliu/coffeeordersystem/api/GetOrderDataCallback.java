package com.wenliu.coffeeordersystem.api;

import com.wenliu.coffeeordersystem.object.CoffeeItem;
import com.wenliu.coffeeordersystem.object.CoffeeOrder;

import java.util.ArrayList;

public interface GetOrderDataCallback {

    public void onCompleted(ArrayList<CoffeeOrder> coffeeOrders);
    public void onError(String error);

}
