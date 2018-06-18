package com.wenliu.coffeeordersystem.api;

import com.wenliu.coffeeordersystem.object.CoffeeItem;

import java.util.ArrayList;

public interface GetCoffeeItemCallback {

    public void onCompleted(ArrayList<CoffeeItem> coffeeItems);
    public void onError(String error);


}
