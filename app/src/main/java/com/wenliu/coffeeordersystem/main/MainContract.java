package com.wenliu.coffeeordersystem.main;

import com.wenliu.coffeeordersystem.base.BasePresenter;
import com.wenliu.coffeeordersystem.base.BaseView;
import com.wenliu.coffeeordersystem.object.CoffeeItem;

import java.util.ArrayList;

public interface MainContract {

    interface View extends BaseView<Presenter> {
        void showCoffeeItems(ArrayList<CoffeeItem> coffeeItems);
    }

    interface Presenter extends BasePresenter {

    }

}
