package com.wenliu.coffeeordersystem;

import com.wenliu.coffeeordersystem.base.BasePresenter;
import com.wenliu.coffeeordersystem.base.BaseView;
import com.wenliu.coffeeordersystem.main.MainContract;

public interface CoffeeOrderContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

        void transToMain();

        void transToOrderList();

        void transToOrderDetail();
    }

}


