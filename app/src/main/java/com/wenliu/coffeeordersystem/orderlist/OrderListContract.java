package com.wenliu.coffeeordersystem.orderlist;

import com.wenliu.coffeeordersystem.base.BasePresenter;
import com.wenliu.coffeeordersystem.base.BaseView;
import com.wenliu.coffeeordersystem.object.CoffeeOrder;

import java.util.ArrayList;

public interface OrderListContract {

    interface View extends BaseView<Presenter> {

        void showCoffeeOrders(ArrayList<CoffeeOrder> coffeeOrders);
    }

    interface Presenter extends BasePresenter {


    }

}
