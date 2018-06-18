package com.wenliu.coffeeordersystem.main;

import android.util.Log;

import com.wenliu.coffeeordersystem.Constants;
import com.wenliu.coffeeordersystem.api.FirebaseApiHelper;
import com.wenliu.coffeeordersystem.api.GetCoffeeItemCallback;
import com.wenliu.coffeeordersystem.object.CoffeeItem;
import com.wenliu.coffeeordersystem.object.CoffeeOrder;

import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mMainView;

    public MainPresenter(MainContract.View mainView) {
        Log.d(Constants.TAG_MAIN_PRESENTER, "MainPresenter: ");
        mMainView = mainView;
        mMainView.setPresenter(this);
    }

    @Override
    public void start() {
        loadCoffeeItems();
    }

    private void loadCoffeeItems() {
        Log.d(Constants.TAG_MAIN_PRESENTER, "loadCoffeeItems: ");

        FirebaseApiHelper.getInstance().getCoffeeItem(new GetCoffeeItemCallback() {
            @Override
            public void onCompleted(ArrayList<CoffeeItem> coffeeItems) {
                mMainView.showCoffeeItems(coffeeItems);
            }

            @Override
            public void onError(String error) {

            }
        });

    }


    @Override
    public void addCoffeeOrder(CoffeeItem coffeeItem) {
        mMainView.showCoffeeOrders(coffeeItem);
    }

    @Override
    public void uploadOrderData(CoffeeOrder coffeeOrder) {
        FirebaseApiHelper.getInstance().uploadOrderData(coffeeOrder);
    }
}
