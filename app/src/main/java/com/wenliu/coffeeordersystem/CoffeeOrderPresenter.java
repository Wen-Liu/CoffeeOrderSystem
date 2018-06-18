package com.wenliu.coffeeordersystem;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.wenliu.coffeeordersystem.main.MainFragment;
import com.wenliu.coffeeordersystem.main.MainPresenter;

public class CoffeeOrderPresenter implements CoffeeOrderContract.Presenter {

    private final CoffeeOrderContract.View mCoffeeOrderView;
    private final FragmentManager mFragmentManager;
    private MainFragment mMainFragment;
    private MainPresenter mMainPresenter;

    public static final String MAIN = "MAIN";
    public static final String DETAIL = "DETAIL";

    public CoffeeOrderPresenter(CoffeeOrderContract.View coffeeOrderView, FragmentManager fragmentManager) {
        mCoffeeOrderView = coffeeOrderView;
        mFragmentManager = fragmentManager;
    }

    @Override
    public void start() {
        transToMain();
    }

    @Override
    public void transToMain() {
        Log.d(Constants.TAG_COFFEE_ORDER_PRESENTER, "transToMain: ");

        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (mMainFragment == null) mMainFragment = MainFragment.newInstance();
        if (!mMainFragment.isAdded()) {
            transaction.add(R.id.frame_container_coffee_activity, mMainFragment, MAIN);
        } else {
            transaction.show(mMainFragment);
        }
        transaction.commit();

        if (mMainPresenter == null) {
            mMainPresenter = new MainPresenter(mMainFragment);
        }
    }

    @Override
    public void transToOrderList() {

    }

    @Override
    public void transToOrderDetail() {

    }
}
