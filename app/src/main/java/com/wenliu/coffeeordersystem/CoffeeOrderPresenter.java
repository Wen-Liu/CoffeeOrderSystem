package com.wenliu.coffeeordersystem;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.wenliu.coffeeordersystem.main.MainFragment;
import com.wenliu.coffeeordersystem.main.MainPresenter;
import com.wenliu.coffeeordersystem.orderlist.OrderListFragment;
import com.wenliu.coffeeordersystem.orderlist.OrderListPresenter;

public class CoffeeOrderPresenter implements CoffeeOrderContract.Presenter {

    private final CoffeeOrderContract.View mCoffeeOrderView;
    private final FragmentManager mFragmentManager;
    private MainFragment mMainFragment;
    private MainPresenter mMainPresenter;
    private OrderListFragment mOrderListFragment;
    private OrderListPresenter mOrderListPresenter;

    public static final String MAIN = "MAIN";
    public static final String ORDER_LIST = "ORDER_LIST";

    public CoffeeOrderPresenter(CoffeeOrderContract.View coffeeOrderView, FragmentManager fragmentManager) {
        Log.d(Constants.TAG_COFFEE_ORDER_PRESENTER, "CoffeeOrderPresenter: ");
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

        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (mMainFragment != null && !mMainFragment.isHidden()) {
            transaction.hide(mMainFragment);
            transaction.addToBackStack(MAIN);
        }

        if (mOrderListFragment == null) mOrderListFragment = OrderListFragment.newInstance();
        if (!mOrderListFragment.isAdded()) {
            transaction.add(R.id.frame_container_coffee_activity, mOrderListFragment, ORDER_LIST);
        } else {
            transaction.show(mOrderListFragment);
        }
        transaction.commit();

        if (mOrderListPresenter == null) {
            mOrderListPresenter = new OrderListPresenter(mOrderListFragment);
        }

    }

    @Override
    public void transToOrderDetail() {

    }
}
