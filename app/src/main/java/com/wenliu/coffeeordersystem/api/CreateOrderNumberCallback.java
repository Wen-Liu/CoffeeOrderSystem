package com.wenliu.coffeeordersystem.api;

public interface CreateOrderNumberCallback {

    public void onCompleted(String orderNumber);
    public void onError(String error);
}
