package com.wenliu.coffeeordersystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.wenliu.coffeeordersystem.main.MainContract;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoffeeOrderActivity extends AppCompatActivity implements CoffeeOrderContract.View {


    @BindView(R.id.toolbar_coffee_order)
    Toolbar mToolbarCoffeeOrder;

    private CoffeeOrderContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_system);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        Log.d(Constants.TAG_COFFEE_ORDER_ACTIVITY, "CoffeeOrderActivity init: ");

        mPresenter = new CoffeeOrderPresenter(this, getSupportFragmentManager());
        mPresenter.start();
    }

    private void setToolbar() {
        // Set the padding to match the Status Bar height
        mToolbarCoffeeOrder.setPadding(0, getStatusBarHeight(), 0, 0);
        setSupportActionBar(mToolbarCoffeeOrder);
    }

    private int getStatusBarHeight() {

        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId > 0) { // resourceId > 0 means get resource id, = 0 means not get
            result = getResources().getDimensionPixelSize(resourceId);
            Log.d(Constants.TAG_COFFEE_ORDER_ACTIVITY, "getStatusBarHeight: " + result);
        }
        return result;
    }


    @Override
    public void setPresenter(CoffeeOrderContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
