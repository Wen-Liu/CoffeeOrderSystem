package com.wenliu.coffeeordersystem.main;

import com.wenliu.coffeeordersystem.base.BasePresenter;
import com.wenliu.coffeeordersystem.base.BaseView;
import com.wenliu.coffeeordersystem.object.CoffeeItem;
import com.wenliu.coffeeordersystem.object.CoffeeOrder;

import java.util.ArrayList;

public interface MainContract {

    interface View extends BaseView<Presenter> {
        void showCoffeeItems(ArrayList<CoffeeItem> coffeeItems);

        void showCoffeeOrders(CoffeeItem coffeeItem);
    }

    interface Presenter extends BasePresenter {

        void addCoffeeOrder(CoffeeItem coffeeItem);

        void uploadOrderData(CoffeeOrder coffeeOrder);
    }

}
